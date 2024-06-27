package com.example.clients.service;

import com.example.clients.config.Config;
import com.example.clients.models.CompanyForCreation;
import com.example.clients.util.Generation;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.example.clients.util.BaseTest.TOKEN;
import static io.restassured.RestAssured.given;

public class CompanyApiController {

    public Response getCompanies() {
        return given()
                .when()
                .get(Config.getCompanyUrl());
    }

    public Response getCompanies(boolean active) {
        String activeStatus = "?active=" + active;
        return given()
                .when()
                .get(Config.getCompanyUrl() + activeStatus);

    }

    public Response createCompany() {
        CompanyForCreation companyForCreation = Generation.generateCompany();
        return given()
                .contentType(ContentType.JSON)
                .body(companyForCreation)
                .header("X-Client-Token", TOKEN)
                .post(Config.getCompanyUrl());
    }

    public Response createCompany(boolean active) {
        CompanyForCreation companyForCreation = Generation.generateCompany(active);
        return given()
                .contentType(ContentType.JSON)
                .body(companyForCreation)
                .header("X-Client-Token", TOKEN)
                .post(Config.getCompanyUrl());
    }

    public Response deleteCompanyById(int id) {
        return given()
                .header("X-Client-Token", TOKEN)
                .get(Config.getCompanyUrl() + "/delete/" + id);
    }


}