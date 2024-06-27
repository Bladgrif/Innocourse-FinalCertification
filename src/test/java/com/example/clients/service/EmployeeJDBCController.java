package com.example.clients.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.example.clients.config.Config.*;

public class EmployeeJDBCController {


    public void deactivateEmployeeById(int id) throws SQLException {

        Connection connection = DriverManager.getConnection(
                getDBConnection(),
                getDBLogin(),
                getDBPassword());

        PreparedStatement statement = connection.prepareStatement(sqlUpdateEmployeeById());
        statement.setInt(1, id);
        statement.executeUpdate();
        connection.close();
    }
}