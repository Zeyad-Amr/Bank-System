package com.bank.atm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String HOST = "sql11.freemysqlhosting.net"; // "127.0.0.1" for localhosting
    private static final int PORT = 3306;
    private static final String DB_NAME = "sql11416851"; // "bank_db" for localhosting
    private static final String USERNAME = "sql11416851"; // "root" for localhosting
    private static final String PASSWORD = "2NLnD5ek91"; // "" for localhosting

    private static Connection connection;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DB_NAME),
                    USERNAME, PASSWORD);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return connection;
    }
}
