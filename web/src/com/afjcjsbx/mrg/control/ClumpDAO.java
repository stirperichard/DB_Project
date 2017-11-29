package com.afjcjsbx.mrg.control;

import com.afjcjsbx.mrg.model.Banda;
import com.afjcjsbx.mrg.model.Clump;
import com.afjcjsbx.mrg.model.Flusso;
import com.afjcjsbx.mrg.model.Sorgente;
import com.afjcjsbx.mrg.util.DataSource;
import com.afjcjsbx.mrg.util.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClumpDAO {

    public static ArrayList<Sorgente> retrieveClumpInfo(String id_clump) throws SQLException {

        PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.SEARCH_CLUMP_BY_ID);

        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.setString(1, id_clump);

        ArrayList<Sorgente> oggetti = new ArrayList<>();

        while (resultSet.next()) {

            Flusso f = new Flusso();
            f.setId(resultSet.getInt("id"));
            f.setValore(resultSet.getDouble("valore"));
            f.setError(resultSet.getDouble("error"));
            f.setSorgente(resultSet.getInt("sorgente"));
            f.setA_min(resultSet.getDouble("a_min"));
            f.setA_max(resultSet.getDouble("a_max"));

            Banda b = new Banda();
            b.setRisoluzione(resultSet.getDouble("risoluzione"));
            b.setLunghezza_spettrale(resultSet.getDouble("lunghezza_spettrale"));
            b.setStrumento(resultSet.getString("strumento"));
            b.setFlussi(f);

            Sorgente s = new Sorgente();
            s.setBanda(b);

            oggetti.add(s);
        }

        return oggetti;
    }



    public static int retrieveClumpsNumber() throws SQLException {

        PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.COUNT_CLUMPS);

        ResultSet resultSet = preparedStatement.executeQuery();

        int count = 0;

        while (resultSet.next()) {
            count = resultSet.getInt("number");
        }

        return count;
    }



    public static ArrayList<Clump> retrieveClumpById(String id_clump) throws SQLException {

        PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.SEARCH_CLUMP_BY_ID);

        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.setString(1, id_clump);

        ArrayList<Clump> clumps = new ArrayList<>();

        while (resultSet.next()) {

            Clump c = new Clump();

            c.setId(resultSet.getInt("id"));
            c.setLatitude(resultSet.getDouble("lat"));
            c.setLongitude(resultSet.getDouble("lng"));
            c.setTemp(resultSet.getDouble("temp"));
            c.setDens(resultSet.getDouble("den_sup"));
            c.setRatio(resultSet.getDouble("t_m"));
            c.setType(resultSet.getString("type"));

            clumps.add(c);

        }

        return clumps;
    }




    public static ArrayList<Clump> retrieveClumpsByDensity() throws SQLException {

        PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.SEARCH_CLUMPS_BY_DENSITY);

        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Clump> clumps = new ArrayList<>();

        while (resultSet.next()) {

            Clump c = new Clump();

            c.setId(resultSet.getInt("id"));
            c.setLatitude(resultSet.getDouble("lat"));
            c.setLongitude(resultSet.getDouble("lng"));
            c.setTemp(resultSet.getDouble("temp"));
            c.setDens(resultSet.getDouble("den_sup"));
            c.setRatio(resultSet.getDouble("t_m"));
            c.setType(resultSet.getString("type"));

            clumps.add(c);
        }

        return clumps;
    }



    public static ArrayList<Clump> retrieveClumpsInRegion(String latitude, String longitude, String radius) throws SQLException {

        PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement("SELECT * " +
                "FROM clump, sorgenti " +
                "WHERE sorgenti.clump = clump.id AND " +
                "SQRT( (clump.lng - "+ longitude + ") * (clump.lng - "+ longitude + ") + (clump.lat - " + latitude + ") * (clump.lat - " + latitude +")) < " + radius);

        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Clump> clumps = new ArrayList<>();

        while (resultSet.next()) {

            Clump c = new Clump();

            c.setId(resultSet.getInt("id"));
            c.setLatitude(resultSet.getDouble("lat"));
            c.setLongitude(resultSet.getDouble("lng"));
            c.setTemp(resultSet.getDouble("temp"));
            c.setDens(resultSet.getDouble("den_sup"));
            c.setRatio(resultSet.getDouble("t_m"));
            c.setType(resultSet.getString("type"));

            clumps.add(c);
        }

        double lat = Double.parseDouble(latitude);
        double lng = Double.parseDouble(longitude);
        double r = Double.parseDouble(radius);


        ArrayList<Clump> clumps_in_region = new ArrayList<>();

        for(int i = 0; i < clumps.size(); i++){
            Clump c = clumps.get(i);

            double distance = Math.hypot(c.getLatitude() - lat, c.getLongitude() - lng);
            if(distance < r){
                clumps_in_region.add(c);
            }
        }

        return clumps_in_region;
    }




    public static boolean insertClump(Clump c) throws SQLException {

        try {

            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_CLUMP);
            preparedStatement.setInt(1, c.getId());
            preparedStatement.setDouble(2, c.getLatitude());
            preparedStatement.setDouble(3, c.getLongitude());
            preparedStatement.setDouble(4, c.getTemp());
            preparedStatement.setDouble(5, c.getDens());
            preparedStatement.setDouble(6, c.getRatio());

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



    public static ArrayList<Clump> viewClumpsMass() throws SQLException {

        Statement statement = DataSource.getConnection().createStatement();

        statement.executeUpdate(Query.VIEW_MASSA_CLUMP);
        ResultSet resultSet = statement.executeQuery(Query.MASSA_CLUMP);

        ArrayList<Clump> clumps = new ArrayList<>();

        while (resultSet.next()) {

            Clump c = new Clump();

            c.setId(resultSet.getInt("id"));
            c.setMassa(resultSet.getDouble("massa_clump"));

            clumps.add(c);
        }

        return clumps;
    }



    public static double[] clumpStatistics() throws SQLException {

        Statement statement = DataSource.getConnection().createStatement();

        statement.executeUpdate(Query.SEARCH_CLUMPS_BY_DENSITY);

        statement.executeUpdate(Query.VIEW_MASSA_CLUMP);
        statement.executeUpdate(Query.MASSA_CLUMP);

        ResultSet resultSet = statement.executeQuery(Query.STATISTICS);


        double[] statistic = new double[4];

        while (resultSet.next()) {


            statistic[0] = resultSet.getDouble("media");
            statistic[1] = resultSet.getDouble("deviazione_standard");
            statistic[2] = resultSet.getDouble("mediana");
            statistic[3] = resultSet.getDouble("mediana_media_assoluta");
        }

        return statistic;
    }


}
