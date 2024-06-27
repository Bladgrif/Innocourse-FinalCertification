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

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generateBirthdate() {
        return faker.date().birthday().toString();
    }

    public static String generatePhone() {
        return faker.phoneNumber().cellPhone();
    }

    public static String generateMiddleName() {
        return faker.name().username();
    }

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    public static boolean generateActive() {
        return faker.bool().bool();
    }


}
