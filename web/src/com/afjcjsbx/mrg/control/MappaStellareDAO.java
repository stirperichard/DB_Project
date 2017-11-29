package com.afjcjsbx.mrg.control;

import com.afjcjsbx.mrg.model.Sorgente;
import com.afjcjsbx.mrg.util.DataSource;
import com.afjcjsbx.mrg.util.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MappaStellareDAO {


    public static ArrayList<String> retrieveMappeStellari() throws SQLException {

        PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.GET_MAPPE_STELLARI);

        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> mappe_stellari = new ArrayList<>();

        while (resultSet.next()) {
            String ms_nome = resultSet.getString("nome");
            mappe_stellari.add(ms_nome);

            System.out.println("Nome satellite: " + ms_nome);
        }

        return mappe_stellari;
    }



    public static ArrayList<Sorgente> retrieveOggettiInMappa(String mappa, String banda) throws SQLException {

        PreparedStatement preparedStatement;

        if(banda.isEmpty()){
            preparedStatement = DataSource.getConnection().prepareStatement(Query.GET_OGGETTI_IN_MAPPA);
            preparedStatement.setString(1, mappa);

        }else{
            preparedStatement = DataSource.getConnection().prepareStatement(Query.GET_OGGETTI_IN_MAPPA_WITH_BANDA);
            preparedStatement.setString(1, mappa);
            preparedStatement.setString(1, banda);
        }

        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Sorgente> oggetti = new ArrayList<>();

        while (resultSet.next()) {

            Sorgente s = new Sorgente();

            s.setId(resultSet.getInt("id"));
            s.setLat(resultSet.getDouble("lat"));
            s.setLng(resultSet.getDouble("lng"));
            s.setType(resultSet.getString("type"));
            s.setLum(resultSet.getDouble("lum"));
            s.setMappa(resultSet.getString("mappa"));
            s.setClump(resultSet.getInt("clump"));
            s.setSorgente(resultSet.getInt("sorgente"));
            s.setBanda_l(resultSet.getDouble("banda_r"));
            s.setBanda_r(resultSet.getDouble("banda_l"));

            System.out.println("Id oggetto: " + s.getId());

            oggetti.add(s);
        }

        return oggetti;
    }


}
