package com.example.clients.tests;

import com.example.clients.models.Company;
import com.example.clients.models.EmployeeCompany;
import com.example.clients.service.CompanyApiController;
import com.example.clients.service.CompanyJDBCController;
import com.example.clients.service.EmployeeApiController;
import com.example.clients.service.EmployeeJDBCController;
import com.example.clients.util.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("XClients Tests Selenide")
@Feature("Service for making appointments with specialized specialists")
public class XClientsTests extends BaseTest {

//    Проблемы:
//    В тесте 01: при создании компании с признаком false, у нее проставляется true
//    В тесте 02: при создании сотрудника с несуществующей компанией, возвращается статус 500, ошибка не описана в документации
//    В тесте 03: при отображении списка сотрудников, неактивный сотрудник тоже отображается
//    В тесте 04: при удалении компании возвращается статус 200, но компания не удаляется из БД

    private final CompanyApiController companyApiController = new CompanyApiController();
    private final CompanyJDBCController companyJDBCController = new CompanyJDBCController();
    private final EmployeeApiController employeeApiController = new EmployeeApiController();
    private final EmployeeJDBCController employeeJDBCController = new EmployeeJDBCController();
    SoftAssertions softAssertions = new SoftAssertions();
    int[] companyIdsToDelete = null;

    @AfterEach
    public void cleanUp() throws SQLException {
        if (companyIdsToDelete != null) {
            for (int id : companyIdsToDelete) {
                companyJDBCController.deleteCompanyById(id);
            }
            companyIdsToDelete = null;
        }
    }

    @Test
    @Tag("XClient")
    @Story("Company Filter")
    @Owner("Grigoriev Roman")
    @Severity(SeverityLevel.NORMAL)
    @Description("Этот тест проверяет, что список компаний фильтруется по параметру активные компании.")
    void CheckThatTheListOfCompaniesIsFilteredByParameterActive() throws SQLException {

        Response activeCompany = companyApiController.createCompany(true);
        assertEquals(activeCompany.getStatusCode(), 201);
        int activeCompanyId = activeCompany.jsonPath().getInt("id");

        Response inactiveCompany = companyApiController.createCompany(false);
        assertEquals(inactiveCompany.getStatusCode(), 201);
        int inactiveCompanyId = inactiveCompany.jsonPath().getInt("id");

        companyJDBCController.deactivateCompanyById(inactiveCompanyId);

        Response collectionOfCompanies = companyApiController.getCompanies(true);
        assertEquals(collectionOfCompanies.getStatusCode(), 200);
        List<Company> activeCompanies = collectionOfCompanies.jsonPath().getList(".", Company.class);


        assertThat(activeCompanies, hasItem(hasProperty("id", equalTo(activeCompanyId))));
        assertThat(activeCompanies, not(hasItem(hasProperty("id", equalTo(inactiveCompanyId)))));

        companyIdsToDelete = new int[]{activeCompanyId, inactiveCompanyId};
    }

    @Test
    @Tag("XClient")
    @Story("Employee Creation")
    @Owner("Grigoriev Roman")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Этот тест проверяет создание сотрудника в несуществующей компании.")
    void CheckTheCreationOfAnEmployeeInANonExistentCompany() {
        Response employee = employeeApiController.createEmployee(0);
        assertEquals(employee.getStatusCode(), 500);
        assertEquals(employee.jsonPath().getString("message"), "Internal server error");

    }

    @Test
    @Tag("XClient")
    @Story("Employee List")
    @Owner("Grigoriev Roman")
    @Severity(SeverityLevel.NORMAL)
    @Description("Этот тест проверяет, что неактивный сотрудник не отображается в списке сотрудников.")
    void CheckThatAnInactiveEmployeeIsNotShownInTheList() throws SQLException {
        Response company = companyApiController.createCompany();
        assertEquals(company.getStatusCode(), 201);
        int companyId = company.jsonPath().getInt("id");

        Response activeEmployee = employeeApiController.createEmployee(companyId, true);
        assertEquals(activeEmployee.getStatusCode(), 201);
        int activeEmployeeId = activeEmployee.jsonPath().getInt("id");

        Response inactiveEmployee = employeeApiController.createEmployee(companyId, false);
        assertEquals(inactiveEmployee.getStatusCode(), 201);
        int inactiveEmployeeId = inactiveEmployee.jsonPath().getInt("id");
        employeeJDBCController.deactivateEmployeeById(inactiveEmployeeId);

        Response CollectionActiveEmployees = employeeApiController.getListOfEmployees(companyId);
        assertEquals(CollectionActiveEmployees.getStatusCode(), 200);
        List<EmployeeCompany> activeEmployees = CollectionActiveEmployees.jsonPath().getList(".", EmployeeCompany.class);

        assertThat(activeEmployees, hasItem(hasProperty("id", equalTo(activeEmployeeId))));
        assertThat(activeEmployees, not(hasItem(hasProperty("id", equalTo(inactiveEmployeeId)))));
    }

    @Test
    @Tag("XClient")
    @Story("Company Deletion")
    @Owner("Grigoriev Roman")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Этот тест проверяет, что поле deletedAt у удаленной компании имеет значение null в базе данных.")
    void CheckThatTheDeletedCompanyHasTheDeletedAtFieldInTheDatabase() throws SQLException {
        Response company = companyApiController.createCompany();
        assertEquals(company.getStatusCode(), 201);
        int companyId = company.jsonPath().getInt("id");

        Response deletedCompany = companyApiController.deleteCompanyById(companyId);
        assertEquals(deletedCompany.getStatusCode(), 200);
        assertEquals(companyId, deletedCompany.jsonPath().getInt("id"));
        assertThat(deletedCompany.jsonPath().getString("deletedAt"), is(nullValue()));

        softAssertions.assertThat(companyJDBCController.getCompanyByIdDB(companyId))
                .as("Компания существует в БД")
                .isFalse();

        companyIdsToDelete = new int[]{companyId};

        softAssertions.assertAll(); // softAssertions чтобы удалить компанию из БД после теста
    }

}
