package com.nighthawk.spring_portfolio.mvc.nutritionstorage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NutRetrieveData {
    private Connection connection;
    private String table;

    public NutRetrieveData(Connection connection, String table) {
        this.connection = connection;
        this.table = table;
    }

    public List<DataObject> select() throws SQLException {
        List<DataObject> data = new ArrayList<>();
        String sql = "SELECT * FROM " + table;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            data.add(new DataObject(id, name));
        }
        return data;
    }
}

class DataObject {
    private int id;
    private String name;

    public DataObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}