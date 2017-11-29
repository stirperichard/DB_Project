package com.afjcjsbx.mrg.control;

import com.afjcjsbx.mrg.model.User;
import com.afjcjsbx.mrg.util.DataSource;
import com.afjcjsbx.mrg.util.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class SatelliteDAO {


    public static boolean insert_satellite(String nome, String operativo_da, String agenzia, String fine_operazione) throws SQLException, ParseException {



        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date parsed = format.parse(operativo_da);
        java.sql.Date operativo = new java.sql.Date(parsed.getTime());

        parsed = format.parse(fine_operazione);
        java.sql.Date fine = new java.sql.Date(parsed.getTime());

        try {

            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_SATELLITE);
            preparedStatement.setString(1, nome);
            preparedStatement.setDate(2, operativo);
            preparedStatement.setString(3, agenzia);
            preparedStatement.setDate(4, fine);

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




    public static ArrayList<String> retrieveAgenzie() throws SQLException {

        PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.GET_AGENZIE);

        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> agenzie = new ArrayList<>();

        while (resultSet.next()) {
            String a_nome = resultSet.getString("nome");
            agenzie.add(a_nome);

            System.out.println("Nome agenzia: " + a_nome);
        }

        return agenzie;
    }


    public static ArrayList<String> retrieveSatelliti() throws SQLException {

        PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.GET_SATELLITI);

        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> satelliti = new ArrayList<>();

        while (resultSet.next()) {
            String s_nome = resultSet.getString("nome");
            satelliti.add(s_nome);

            System.out.println("Nome satellite: " + s_nome);
        }

        return satelliti;
    }


}
