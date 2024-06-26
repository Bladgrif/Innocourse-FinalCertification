package com.example.clients.service;

import com.example.clients.config.Config;
import com.example.clients.models.Company;
import com.example.clients.models.CompanyForCreation;
import com.example.clients.util.Generation;
import io.restassured.http.ContentType;

import java.util.List;

import static com.example.clients.util.BaseTest.TOKEN;
import static io.restassured.RestAssured.given;

public class CompanyApiController {

    public List<Company> getCompanies() {
        return given()
                .when()
                .get(Config.getCompanyUrl())
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList(".",Company.class);
    }

    public List<Company> getCompanies (boolean active) {
        String activeStatus = "?active=" + active;
        return given()
                .when()
                .get(Config.getCompanyUrl() + activeStatus)
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList(".",Company.class);
    }

    public int createCompany()  {
        CompanyForCreation companyForCreation= Generation.generateCompany();
        return given()
                .contentType(ContentType.JSON)
                .body(companyForCreation)
                .header("X-Client-Token", TOKEN)
                .post(Config.getCompanyUrl())
                .then()
                .statusCode(201)
                .extract().path("id");
    }

    public int createCompany(boolean active)  {
        CompanyForCreation companyForCreation= Generation.generateCompany(active);
        return given()
                .contentType(ContentType.JSON)
                .body(companyForCreation)
                .header("X-Client-Token", TOKEN)
                .post(Config.getCompanyUrl())
                .then()
                .statusCode(201)
                .extract().path("id");
    }

    public String deleteCompanyById(int id)   {
        return given()
                .header("X-Client-Token", TOKEN)
                .log().all()
                .get(Config.getCompanyUrl() + "/delete/" + id)
                .then()
                .statusCode(200)
                .extract().path("deletedAt");
    }



}