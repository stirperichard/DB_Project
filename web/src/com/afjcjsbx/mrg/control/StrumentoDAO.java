package com.afjcjsbx.mrg.control;

import com.afjcjsbx.mrg.util.DataSource;
import com.afjcjsbx.mrg.util.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StrumentoDAO {


    public static boolean insert_strumento(String nome, String satellite, String mappa) throws SQLException, ParseException {

        try {

            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_STRUMENTO);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, satellite);
            preparedStatement.setString(3, mappa);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new satellite was inserted successfully!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }




    public static ArrayList<String> retrieveMappe() throws SQLException {

        PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.GET_MAPPE_STELLARI);

        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> mappe = new ArrayList<>();

        while (resultSet.next()) {
            String m_nome = resultSet.getString("nome");
            mappe.add(m_nome);

            System.out.println("Nome mappa: " + m_nome);
        }

        return mappe;
    }



}
