package com.example.clients.tests;


import com.example.clients.config.Config;
import com.example.clients.service.ApiService;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTests {
    private ApiService apiService = new ApiService(Config.getBaseUrl());

    @Test
    public void testCreateEmployeeInNonExistentCompany() {
        String employeeJson = "{...}";  // Employee details in JSON format
        Response response = apiService.createEmployee("your-token", employeeJson);
        assertEquals(404, response.getStatusCode());
    }

    @Test
    public void testInactiveEmployeeNotInList() {
        // Simulate and verify that inactive employees are not in the list
    }
}