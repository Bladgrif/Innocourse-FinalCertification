package com.example.clients.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Company {

    @JsonProperty("deletedAt")
    private String deletedAt;

    @JsonProperty("lastChangedDateTime")
    private String lastChangedDateTime;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("id")
    private int id;

    @JsonProperty("isActive")
    private boolean isActive;

    @JsonProperty("createDateTime")
    private String createDateTime;

    public Company() {
    }

    public Company(int id, boolean isActive, String createTimestamp, String changeTimestamp, String name, String description, String deletedAt) {
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setLastChangedDateTime(String lastChangedDateTime) {
        this.lastChangedDateTime = lastChangedDateTime;
    }

    public String getLastChangedDateTime() {
        return lastChangedDateTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
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

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    @Override
    public String toString() {
        return
                "CollectionOfCompanyItem{" +
                        "deletedAt = '" + deletedAt + '\'' +
                        ",lastChangedDateTime = '" + lastChangedDateTime + '\'' +
                        ",name = '" + name + '\'' +
                        ",description = '" + description + '\'' +
                        ",id = '" + id + '\'' +
                        ",isActive = '" + isActive + '\'' +
                        ",createDateTime = '" + createDateTime + '\'' +
                        "}";
    }
}