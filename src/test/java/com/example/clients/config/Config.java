package com.example.clients.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final String CONFIG_FILE = "src/test/resources/config.properties";
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream(CONFIG_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getAuthUrl() {
        return properties.getProperty("URL_AUTH");
    }

    public static String getCompanyUrl() {
        return properties.getProperty("URL_COMPANY");
    }

    public static String getEmployeeUrl() {
        return properties.getProperty("URL_EMPLOYEE");
    }

    public static String getDBConnection() {
        return properties.getProperty("db_connection");
    }

    public static String getDBLogin() {
        return properties.getProperty("db_login");
    }

    public static String getDBPassword() {
        return properties.getProperty("db_password");
    }

    public static String getAdminUsername() {
        return properties.getProperty("admin_username");
    }

    public static String getAdminPassword() {
        return properties.getProperty("admin_password");
    }


    public static String sqlSelectEmployeeById() {
        return properties.getProperty("SQL_SELECT_BY_ID");
    }

    public static String sqlSelectCompanyById() {
        return properties.getProperty("SQL_SELECT_COMPANY_BY_ID");
    }

    public static String sqlDeleteEmployeeById() {
        return properties.getProperty("SQL_DELETE_BY_ID");
    }

    public static String sqlDeleteCompanyById() {
        return properties.getProperty("SQL_DELETE_COMPANY_BY_ID");
    }

    public static String sqlUpdateCompanyById() {
        return properties.getProperty("SQL_UPDATE_ACTIVE_COMPANY_BY_ID");
    }

    public static String sqlUpdateEmployeeById() {
        return properties.getProperty("SQL_UPDATE_ACTIVE_EMPLOYEE_BY_ID");
    }

}