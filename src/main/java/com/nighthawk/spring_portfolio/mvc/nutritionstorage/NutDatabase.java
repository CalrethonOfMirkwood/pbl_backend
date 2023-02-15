package com.nighthawk.spring_portfolio.mvc.nutritionstorage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NutDatabase {
    private Connection connection;

    public NutDatabase(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() throws SQLException {
        connection.close();
    }
}