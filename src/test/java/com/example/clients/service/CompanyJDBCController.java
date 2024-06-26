package com.example.clients.service;

import com.example.clients.config.Config;
import com.example.clients.models.Company;

import java.sql.*;

import static com.example.clients.config.Config.*;

public class CompanyJDBCController {


    public static void deleteCompanyById(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(
                getDBConnection(),
                getDBLogin(),
                getDBPassword());

        PreparedStatement statement = connection.prepareStatement(sqlDeleteCompanyById());
        statement.setInt(1, id);
        statement.executeUpdate();
        connection.close();
    }

    public static void deactivateCompanyById(int id) throws SQLException {

        Connection connection = DriverManager.getConnection(
                getDBConnection(),
                getDBLogin(),
                getDBPassword());

        PreparedStatement statement = connection.prepareStatement(sqlUpdateCompanyById());
        statement.setInt(1, id);
        statement.executeUpdate();
        connection.close();
    }

    public static boolean getCompanyByIdDB(int id) throws SQLException {

        Connection connection = DriverManager.getConnection(
                getDBConnection(),
                getDBLogin(),
                getDBPassword());

        PreparedStatement statement = connection.prepareStatement(sqlSelectCompanyById());
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        return resultSet.next();
    }
}

