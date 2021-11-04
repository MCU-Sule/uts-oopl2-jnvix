package com.jojo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Jonathan-1672012
 */
public class MySQLConnection {
    private static final String URL= "jdbc:mysql://localhost:3306/SquidDB";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        connection.setAutoCommit(false);
        return connection;
    }
}
