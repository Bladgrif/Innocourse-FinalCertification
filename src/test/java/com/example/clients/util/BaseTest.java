package com.example.clients.util;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.clients.config.Config;
import com.example.clients.models.User;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;

import static com.example.clients.config.Config.getAuthUrl;
import static io.restassured.RestAssured.given;

public class BaseTest {

    protected static final User ADMIN = new User(Config.getAdminUsername(), Config.getAdminPassword());
    public static String TOKEN;

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";


        TOKEN = given()
                .contentType(ContentType.JSON)
                .body(ADMIN)
                .when()
                .post(getAuthUrl())
                .then()
                .statusCode(201)
                .extract()
                .path("userToken");
        System.out.println(TOKEN);

        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }
}