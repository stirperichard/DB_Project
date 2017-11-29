package com.afjcjsbx.mrg.util;

import com.afjcjsbx.mrg.model.Satellite;
import com.afjcjsbx.mrg.model.Strumento;
import com.afjcjsbx.mrg.model.Clump;

import java.io.BufferedReader;
import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Simple Java program to read CSV file in Java. In this program we will read * list of books stored in CSV file as comma separated values. * * @author WINDOWS 8 *
 */
public class CSVReaderInJava {




    public static void main(String... args) {

        /*
        List<Clump> clumps = readBooksFromCSV("books.txt");
        // let's print all the person read from CSV file
        //
        for (Clump b : clumps) {
            System.out.println(b);
        }
        */
    }

    /*
    private static List<Clump> readClumpsFromCSV(String fileName) {
        List<Clump> books = new ArrayList<>();
        Path pathToFile = Paths.get(fileName); // create an instance of BufferedReader // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            // read the first line from the text file
            String line = br.readLine();
            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from // each line of // the file, using a comma as the delimiter
                String[] attributes = line.split(",");
                Clump clump = createClump(attributes);
                // adding book into ArrayList
                books.add(clump);
                // read next line before looping // if end of file reached, line would be null
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return books;
    }


    private static List<Satellite> readSatellitesFromCSV(String fileName) {
        List<Satellite> satellites = new ArrayList<>();
        Path pathToFile = Paths.get(fileName); // create an instance of BufferedReader // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            // read the first line from the text file
            String line = br.readLine();
            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from // each line of // the file, using a comma as the delimiter
                String[] attributes = line.split(",");
                Satellite clump = createSatellite(attributes);
                // adding book into ArrayList
                satellites.add(clump);
                // read next line before looping // if end of file reached, line would be null
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return satellites;
    }


    private static List<Strumento> readStrumentsFromCSV(String fileName) {
        List<Strumento> satellites = new ArrayList<>();
        Path pathToFile = Paths.get(fileName); // create an instance of BufferedReader // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            // read the first line from the text file
            String line = br.readLine();
            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from // each line of // the file, using a comma as the delimiter
                String[] attributes = line.split(",");
                Strumento strumento = createStrumento(attributes);
                // adding book into ArrayList
                satellites.add(strumento);
                // read next line before looping // if end of file reached, line would be null
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return satellites;
    }


    private static Clump createClump(String[] metadata) {

        int id = Integer.parseInt(metadata[0]);
        float longitude = Float.parseFloat(metadata[1]);
        float latitude = Float.parseFloat(metadata[2]);
        float temp = Float.parseFloat(metadata[3]);
        float ratio = Float.parseFloat(metadata[4]);
        float dens = Float.parseFloat(metadata[5]);
        int type = Integer.parseInt(metadata[6]);

        return new Clump(id, longitude, latitude, temp, ratio, dens, type);
    }


    private static Satellite createSatellite(String[] metadata) {

        String nome = metadata[0];
        Date operativo_da = null;

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            operativo_da = format.parse(metadata[1]);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        int durata = Integer.parseInt(metadata[2]);
        String agenzia = metadata[3];

        return new Satellite(nome, operativo_da, durata, agenzia);
    }


    private static Strumento createStrumento(String[] metadata) {

        String nome = metadata[0];
        String satellite = metadata[1];
        String mappa = metadata[2];

        return new Strumento(nome, satellite, mappa);
    }

    */

}

