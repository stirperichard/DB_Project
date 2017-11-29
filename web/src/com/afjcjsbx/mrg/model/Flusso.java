package com.afjcjsbx.mrg.model;

public class Flusso {

    private int id;
    private double valore;
    private double error;
    private int sorgente;
    private double a_min;
    private double a_max;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValore() {
        return valore;
    }

    public void setValore(double valore) {
        this.valore = valore;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }

    public int getSorgente() {
        return sorgente;
    }

    public void setSorgente(int sorgente) {
        this.sorgente = sorgente;
    }

    public double getA_min() {
        return a_min;
    }

    public void setA_min(double a_min) {
        this.a_min = a_min;
    }

    public double getA_max() {
        return a_max;
    }

    public void setA_max(double a_max) {
        this.a_max = a_max;
    }
}
