package com.afjcjsbx.mrg.model;

public class Strumento {

    private String nome;
    private String satellite;
    private String mappa;

    public Strumento(String nome, String satellite, String mappa) {
        this.nome = nome;
        this.satellite = satellite;
        this.mappa = mappa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSatellite() {
        return satellite;
    }

    public void setSatellite(String satellite) {
        this.satellite = satellite;
    }

    public String getMappa() {
        return mappa;
    }

    public void setMappa(String mappa) {
        this.mappa = mappa;
    }
}
