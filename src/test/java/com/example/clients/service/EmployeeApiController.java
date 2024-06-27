package com.example.clients.service;

import com.example.clients.config.Config;
import com.example.clients.models.Employee;
import com.example.clients.util.Generation;
import io.restassured.response.Response;

import static com.example.clients.util.BaseTest.TOKEN;
import static io.restassured.RestAssured.given;

public class EmployeeApiController {

    public Response createEmployee(int companyId) {
        Employee employee = Generation.generateEmployee(companyId);
        return given()
                .contentType("application/json")
                .body(employee)
                .header("X-Client-Token", TOKEN)
                .when()
                .post(Config.getEmployeeUrl());
    }

    public Response createEmployee(int companyId, boolean isActive) {
        Employee employee = Generation.generateEmployee(companyId, isActive);
        return given()
                .contentType("application/json")
                .body(employee)
                .header("X-Client-Token", TOKEN)
                .when()
                .post(Config.getEmployeeUrl());
    }

    public Response getListOfEmployees(int companyId) {
        return given()
                .when()
                .get(Config.getEmployeeUrl() + "?company=" + companyId);

    }
}
