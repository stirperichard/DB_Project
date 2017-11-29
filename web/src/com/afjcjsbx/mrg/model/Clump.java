package com.afjcjsbx.mrg.model;

public class Clump {

    private int id;
    private double longitude;
    private double latitude;
    private double temp;
    private double ratio;
    private double dens;
    private String type;

    private double massa;


    public Clump(int id, double longitude, double latitude, double temp, double ratio, double dens) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.temp = temp;
        this.ratio = ratio;
        this.dens = dens;
    }

    public Clump() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public double getDens() {
        return dens;
    }

    public void setDens(double dens) {
        this.dens = dens;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }
}
