package com.example.clients.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeCompany {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("companyId")
    private int companyId;

    @JsonProperty("birthdate")
    private String birthdate;

    @JsonProperty("avatar_url")
    private Object avatarUrl;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("lastChangedDateTime")
    private String lastChangedDateTime;

    @JsonProperty("middleName")
    private String middleName;

    @JsonProperty("id")
    private int id;

    @JsonProperty("isActive")
    private boolean isActive;

    @JsonProperty("email")
    private Object email;

    @JsonProperty("createDateTime")
    private String createDateTime;

    public EmployeeCompany() {
    }

    public EmployeeCompany(String firstName, String lastName, int companyId, String birthdate, Object avatarUrl, String phone, String lastChangedDateTime, String middleName, int id, boolean isActive, Object email, String createDateTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyId = companyId;
        this.birthdate = birthdate;
        this.avatarUrl = avatarUrl;
        this.phone = phone;
        this.lastChangedDateTime = lastChangedDateTime;
        this.middleName = middleName;
        this.id = id;
        this.isActive = isActive;
        this.email = email;
        this.createDateTime = createDateTime;
    }

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

    public void setAvatarUrl(Object avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Object getAvatarUrl() {
        return avatarUrl;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setLastChangedDateTime(String lastChangedDateTime) {
        this.lastChangedDateTime = lastChangedDateTime;
    }

    public String getLastChangedDateTime() {
        return lastChangedDateTime;
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

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getEmail() {
        return email;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    @Override
    public String toString() {
        return
                "EmployeeCompany{" +
                        "firstName = '" + firstName + '\'' +
                        ",lastName = '" + lastName + '\'' +
                        ",companyId = '" + companyId + '\'' +
                        ",birthdate = '" + birthdate + '\'' +
                        ",avatar_url = '" + avatarUrl + '\'' +
                        ",phone = '" + phone + '\'' +
                        ",lastChangedDateTime = '" + lastChangedDateTime + '\'' +
                        ",middleName = '" + middleName + '\'' +
                        ",id = '" + id + '\'' +
                        ",isActive = '" + isActive + '\'' +
                        ",email = '" + email + '\'' +
                        ",createDateTime = '" + createDateTime + '\'' +
                        "}";
    }
}