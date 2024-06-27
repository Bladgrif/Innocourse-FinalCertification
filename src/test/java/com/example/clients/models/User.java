package com.example.clients.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("password")
    private String password;

    @JsonProperty("username")
    private String username;

    public User(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return
                "User{" +
                        "password = '" + password + '\'' +
                        ",username = '" + username + '\'' +
                        "}";
    }
}