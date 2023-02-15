package com.nighthawk.spring_portfolio.mvc.nutritionstorage;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class NutCreateTable {
    private Connection connection;
    private String name;

    public NutCreateTable(Connection connection, String name) {
        this.connection = connection;
        this.name = name;
    }

    public void create() throws SQLException {
        String sql = "CREATE TABLE " + name + " (id INT PRIMARY KEY, name VARCHAR(255))";
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }
}