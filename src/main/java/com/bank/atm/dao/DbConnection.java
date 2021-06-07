package com.bank.atm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    // local
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String DB_NAME = "bank_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // global
    // private static final String HOST = "sql11.freemysqlhosting.net";
    // private static final int PORT = 3306;
    // private static final String DB_NAME = "sql11416851";
    // private static final String USERNAME = "sql11416851";
    // private static final String PASSWORD = "2NLnD5ek91";

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
