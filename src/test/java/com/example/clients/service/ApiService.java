package com.example.clients.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiService {
    private String baseUrl;

    public ApiService(String baseUrl) {
        this.baseUrl = baseUrl;
        RestAssured.baseURI = baseUrl;
    }

    public Response getCompanies(boolean active) {
        return given()
                .queryParam("active", active)
                .when()
                .get("/company")
                .then()
                .extract()
                .response();
    }

    public Response createEmployee(String token, String employeeJson) {
        return given()
                .header("x-client-token", token)
                .header("Content-Type", "application/json")
                .body(employeeJson)
                .when()
                .post("/employee")
                .then()
                .extract()
                .response();
    }

    // Other API methods
}