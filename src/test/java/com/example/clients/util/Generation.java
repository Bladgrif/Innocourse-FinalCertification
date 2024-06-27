package com.example.clients.util;

import com.example.clients.models.CompanyForCreation;
import com.example.clients.models.Employee;

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

    public static Employee generateEmployee(int valueCompany) {
        boolean isActive = generateActive();
        return generateEmployee(valueCompany, isActive);
    }

    public static Employee generateEmployee(int valueCompany, boolean valueActive) {
        String firstName = generateFirstName();
        String lastName = generateLastName();
        String middleName = generateMiddleName();
        String email = generateEmail();
        String phone = generatePhone();
        String birthDate = generateBirthdate();
        return new Employee(firstName, lastName, middleName, valueCompany, email, phone, birthDate, valueActive);
    }
}