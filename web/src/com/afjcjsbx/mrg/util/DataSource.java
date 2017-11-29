package com.afjcjsbx.mrg.util;

import java.sql.*;
import java.util.Properties;


public class DataSource {

    private static final String JDBC_CONNECTION_URL =
            "jdbc:postgresql://127.0.0.1:5433/afjcjsbx";

    private static Connection connection = null;

    public static Connection getConnection() {

        //connection();



        if (connection != null)
            return connection;
        try {
            Class.forName("org.postgresql.Driver");

            Properties props = new Properties();
            props.setProperty("user","afjcjsbx");
            props.setProperty("password","trulli15");
            props.setProperty("ssl","false");
            connection = DriverManager.getConnection(JDBC_CONNECTION_URL, props);


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++)
            getConnection();
    }



    public static void connection() {

        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;

        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5433/afjcjsbx", "afjcjsbx",
                    "trulli15");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }
}
