package com.example.clients.util;

import com.example.clients.models.CompanyForCreation;

import static com.example.clients.faker.FakerDataProvider.*;

public class Generation {

    public static CompanyForCreation generateCompany() {
        boolean isActive = generateCompanyStatus();
        return generateCompany(isActive);
    }

    public static CompanyForCreation generateCompany(boolean isActive) {
        String name = generateCompanyName();
        String description = generateCompanyDescription();
        return new CompanyForCreation(name, description, isActive);
    }
}