package com.example.project;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase",
                    "root", "my-secret-pw");

            System.out.println("made it to database");
        } catch (Exception exception) {
            System.out.println(exception);
        }

        return connection;
    }
}

