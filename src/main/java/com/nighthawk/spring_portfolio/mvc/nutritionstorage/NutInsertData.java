package com.nighthawk.spring_portfolio.mvc.nutritionstorage;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NutInsertData {
    private Connection connection;
    private String table;

    public NutInsertData(Connection connection, String table) {
        this.connection = connection;
        this.table = table;
    }

    public void insert(int id, String name) throws SQLException {
        String sql = "INSERT INTO " + table + " (id, name) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, name);
        statement.executeUpdate();
    }
}