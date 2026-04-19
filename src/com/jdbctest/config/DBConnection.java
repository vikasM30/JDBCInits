package com.jdbctest.config;

import java.sql.*;

public class DBConnection  {

    private static final String URL = PropertyLoader.get("db.url");
    private static final String USER = PropertyLoader.get("db.user");
    private static final String PASSWORD = PropertyLoader.get("db.password");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
