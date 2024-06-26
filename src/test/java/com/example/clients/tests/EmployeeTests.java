package com.example.clients.tests;


import com.example.clients.config.Config;
import com.example.clients.service.ApiService;
import com.example.clients.util.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTests extends BaseTest {

    @Test
    void getToken() {
        System.out.println(TOKEN);
    }
}