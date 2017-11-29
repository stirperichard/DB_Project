package com.afjcjsbx.mrg.model;

/**
 * Created by afjcjsbx on 24/02/17.
 */
public class ObjectMapBean {

    private String mappa;
    private String banda;

    public String getMappa() {
        return mappa;
    }

    public void setMappa(String mappa) {
        this.mappa = mappa;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public boolean validate(){
        if(!mappa.isEmpty()){
            return true;
        }
        return false;
    }
}
