package com.afjcjsbx.mrg.control;


import com.afjcjsbx.mrg.model.Clump;

import java.sql.SQLException;
import java.util.ArrayList;

public class DataController {

    public boolean insertClump(ArrayList<Clump> clumps) {

         /*
        try {

            for(int i = 0; i < clumps.size(); i++) {


                PreparedStatement statement = DataSource.getConnection().prepareStatement(Query.INSERT_CLUMP);

                statement.setString(1, clumps.get(i).getId());
                statement.setString(2, manageProductBean.getCategory());
                statement.setString(3, manageProductBean.getName());
                statement.setString(4, manageProductBean.getDescription());
                statement.setString(5, manageProductBean.getPicture());
                statement.setString(6, manageProductBean.getPrice());
                statement.setString(7, manageProductBean.getManufacturer());
                statement.setString(8, manageProductBean.getIsCharitable());
                statement.setString(9, manageProductBean.getDiscountPercentage());
                statement.setString(10, manageProductBean.getShipment_cost());

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new user was inserted successfully!");
                    return true;
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        */

        return false;
    }





    public static boolean registerUser(String username, String email, String password, String name, String surname) throws SQLException {
 /*
        try {

            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.REGISTER_USER);
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


*/
        return false;
    }




}
