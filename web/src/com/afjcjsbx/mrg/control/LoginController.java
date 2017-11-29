package com.afjcjsbx.mrg.control;


import com.afjcjsbx.mrg.model.User;
import com.afjcjsbx.mrg.util.DataSource;
import com.afjcjsbx.mrg.util.Query;
import com.afjcjsbx.mrg.util.Roles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {


    private static User retrieveUserInfoFromDatabaseQuery(ResultSet resultSet) throws SQLException {

        String u_username = resultSet.getString("username"),
                u_email = resultSet.getString("email"),
                u_type = resultSet.getString("type"),
                u_password = resultSet.getString("password"),
                u_name = resultSet.getString("nome"),
                u_surname = resultSet.getString("cognome");



        User user = new User();

        switch (u_type) {

            case "A":
                user.setType(Roles.ADMINISTRATOR);
                break;
            case "U":
                user.setType(Roles.USER);
                break;
            default:
                user.setType(Roles.USER);
        }

        user.setUsername(u_username);
        user.setEmail(u_email);
        user.setPassword(u_password);
        user.setName(u_name);
        user.setSurname(u_surname);

        user.setValid(true);

        System.out.println("Welcome " + u_username + " " + u_email);

        return user;
    }


    public static User retrieveOwnerInfoByEmail(String email) throws SQLException {

        PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.FIND_USER_BY_EMAIL);
        preparedStatement.setString(1, email);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return retrieveUserInfoFromDatabaseQuery(resultSet);
        }

        throw new SQLException();
    }


    public static boolean registerUser(String username, String email, String password, String name, String surname) throws SQLException {


        try {

            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_USER);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, name);
            preparedStatement.setString(5, surname);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public static User retrieveUserInfoByUsernamelAndPassword(String username, String password) throws SQLException {

        PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.FIND_REGISTERED_USER);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        System.out.println("Welcome " + username + " " + password);


        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return retrieveUserInfoFromDatabaseQuery(resultSet);
        }

        throw new SQLException();
    }


}
