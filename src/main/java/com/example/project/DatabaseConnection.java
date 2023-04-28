/*
Olaf Carlson
ocarlson@iu.edu
Spring 2023 Project
Indiana University Southeast

This Class makes connection to mySQL Database in Docker
 */
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

        } catch (Exception exception) {
            System.out.println(exception);
        }
        return connection;
    }
}

