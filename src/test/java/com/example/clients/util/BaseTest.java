package com.example.clients.util;


import com.example.clients.config.Config;
import com.example.clients.models.User;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;

import static com.example.clients.config.Config.getAuthUrl;
import static io.restassured.RestAssured.given;

public class BaseTest {

    protected static final User ADMIN = new User(Config.getAdminUsername(), Config.getAdminPassword());
    public static String TOKEN;

    @BeforeAll
    static void beforeAll() {
        TOKEN = given()
                .contentType(ContentType.JSON)
                .body(ADMIN)
                .when()
                .post(getAuthUrl())
                .then()
                .statusCode(201)
                .extract()
                .path("userToken");
    }
}