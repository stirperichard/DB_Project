package com.afjcjsbx.mrg.model;

public class Sorgente {

    private int id;
    private double lat;
    private double lng;
    private String type;
    private double lum;
    private String mappa;
    private int clump;
    private int sorgente;
    private double banda_r;
    private double banda_l;
    private Clump clump_object;
    private Banda banda;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLum() {
        return lum;
    }

    public void setLum(double lum) {
        this.lum = lum;
    }

    public String getMappa() {
        return mappa;
    }

    public void setMappa(String mappa) {
        this.mappa = mappa;
    }

    public int getClump() {
        return clump;
    }

    public void setClump(int clump) {
        this.clump = clump;
    }

    public int getSorgente() {
        return sorgente;
    }

    public void setSorgente(int sorgente) {
        this.sorgente = sorgente;
    }

    public double getBanda_r() {
        return banda_r;
    }

    public void setBanda_r(double banda_r) {
        this.banda_r = banda_r;
    }

    public double getBanda_l() {
        return banda_l;
    }

    public void setBanda_l(double banda_l) {
        this.banda_l = banda_l;
    }


    public Clump getClump_object() {
        return clump_object;
    }

    public void setClump_object(Clump clump_object) {
        this.clump_object = clump_object;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
}
