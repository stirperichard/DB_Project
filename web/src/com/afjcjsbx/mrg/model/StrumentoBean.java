package com.afjcjsbx.mrg.model;

/**
 * Created by afjcjsbx on 24/02/17.
 */
public class StrumentoBean {

    private String nome;
    private String satellite;
    private String mappa;


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

    public boolean validate(){
        if(!nome.isEmpty() || !satellite.isEmpty() || !mappa.isEmpty()){
            return true;
        }
        return false;
    }
}
