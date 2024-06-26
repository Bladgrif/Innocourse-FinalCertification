package com.example.clients.faker;

import com.github.javafaker.Faker;

public class FakerDataProvider {

    private static final Faker faker = new Faker();

    public static String generateCompanyName() {
        return faker.company().name();
    }

    public static String generateCompanyDescription() {
        return faker.company().industry();
    }

    public static boolean generateCompanyStatus() {
        return faker.bool().bool();
    }
}
