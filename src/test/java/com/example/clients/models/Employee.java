package com.example.clients.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("companyId")
    private int companyId;

    @JsonProperty("birthdate")
    private String birthdate;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("middleName")
    private String middleName;

    @JsonProperty("id")
    private int id;

    @JsonProperty("isActive")
    private boolean isActive;

    @JsonProperty("email")
    private String email;

    @JsonProperty("url")
    private String url;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public Employee() {
    }

    public Employee(String firstName, String lastName, String middleName, int companyId, String email, String phone, String birthdate, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.companyId = companyId;
        this.email = email;
        this.phone = phone;
        this.birthdate = birthdate;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return
                "Employee{" +
                        "firstName = '" + firstName + '\'' +
                        ",lastName = '" + lastName + '\'' +
                        ",companyId = '" + companyId + '\'' +
                        ",birthdate = '" + birthdate + '\'' +
                        ",phone = '" + phone + '\'' +
                        ",middleName = '" + middleName + '\'' +
                        ",id = '" + id + '\'' +
                        ",isActive = '" + isActive + '\'' +
                        ",email = '" + email + '\'' +
                        ",url = '" + url + '\'' +
                        "}";
    }
}