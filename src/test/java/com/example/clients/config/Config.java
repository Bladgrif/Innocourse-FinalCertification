package com.example.clients.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

    public static String getDBConnectionString() {
        return properties.getProperty("db_connectionString");
    }

    public static String getDBLog() {
        return properties.getProperty("db_log");
    }

    public static String getDBPass() {
        return properties.getProperty("db_pass");
    }

    public static String getAdminUsername() {
        return properties.getProperty("admin_username");
    }

    public static String getAdminPass() {
        return properties.getProperty("admin_pass");
    }

    public static String sqlInsertEmployee() {
        return properties.getProperty("SQL_INSERT_EMPLOYEE");
    }

    public static String sqlSelectById() {
        return properties.getProperty("SQL_SELECT_BY_ID");
    }

    public static String sqlSelectCompanyById() {
        return properties.getProperty("SQL_SELECT_COMPANY_BY_ID");
    }

    public static String sqlDeleteById() {
        return properties.getProperty("SQL_DELETE_BY_ID");
    }

    public static String sqlDeleteCompanyById() {
        return properties.getProperty("SQL_DELETE_COMPANY_BY_ID");
    }
}