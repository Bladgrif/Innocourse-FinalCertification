package com.example.clients.tests;



import com.example.clients.config.Config;
import com.example.clients.service.ApiService;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CompanyTests {
    private ApiService apiService = new ApiService(Config.getBaseUrl());

    @Test
    public void testGetActiveCompanies() {
        Response response = apiService.getCompanies(true);
        assertEquals(200, response.getStatusCode());
        // Additional assertions to verify the response body
        assertThat(response.jsonPath().getList("isActive"), everyItem(equalTo(true)));
    }

    @Test
    public void testCompanyDeletion() {
        // Simulate company deletion and verify 'deletedAt' field
    }
}