package com.vti.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCutils {
    public static Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/testingsystem";
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(dbUrl, user, password);

        return connection;
    }
}
