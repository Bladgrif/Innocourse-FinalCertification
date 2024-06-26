package com.example.clients.tests;

import com.example.clients.models.Company;
import com.example.clients.service.CompanyApiController;
import com.example.clients.service.CompanyJDBCController;
import com.example.clients.util.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static com.example.clients.service.CompanyJDBCController.getCompanyByIdDB;
import static org.apache.commons.lang3.BooleanUtils.isFalse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;


public class XClientsTests extends BaseTest {

    private final CompanyApiController companyApiController = new CompanyApiController();
    int [] companyIdsToDelete = null;

    @AfterEach
    public void cleanUp() throws SQLException {
        if (companyIdsToDelete != null) {
            for (int id : companyIdsToDelete) {
                CompanyJDBCController.deleteCompanyById(id);
            }
            companyIdsToDelete = null;
        }
    }


    @Test
    void CheckThatTheListOfCompaniesIsFilteredByParameterActive() throws SQLException {
        int activeCompanyId = companyApiController.createCompany(true);
        int inactiveCompanyId  = companyApiController.createCompany(false);
        CompanyJDBCController.deactivateCompanyById(inactiveCompanyId);
        List<Company> activeCompanies = companyApiController.getCompanies(true);

        assertThat(activeCompanies, hasItem(hasProperty("id", equalTo(activeCompanyId))));
        assertThat(activeCompanies, not(hasItem(hasProperty("id", equalTo(inactiveCompanyId)))));

        companyIdsToDelete  = new int[]{activeCompanyId, inactiveCompanyId};
    }

    @Test
    void CheckTheCreationOfAnEmployeeInANonExistentCompany() {
        int id = companyApiController.createCompany(false);
        int id1 = companyApiController.createCompany(true);
        System.out.println(id);
        System.out.println(id1);


    }

    @Test
    void CheckThatAnInactiveEmployeeIsNotShownInTheList() {
    }

    @Test
    void CheckThatTheDeletedCompanyHasTheDeletedAtFieldInTheDatabase() throws SQLException {
        int companyId = companyApiController.createCompany();
        String deletedAt = companyApiController.deleteCompanyById(companyId);
        System.out.println(companyId);

        assertThat(deletedAt, is(nullValue()));
        Assertions.assertFalse(CompanyJDBCController.getCompanyByIdDB(companyId));

        companyIdsToDelete  = new int[]{companyId};
    }

}
