package com.afjcjsbx.mrg.model;

public class Banda {


    private double risoluzione;
    private double lunghezza_spettrale;
    private String strumento;
    private Flusso flusso;

    public Banda(){
        flusso = new Flusso();
    }

    public double getRisoluzione() {
        return risoluzione;
    }

    public void setRisoluzione(double risoluzione) {
        this.risoluzione = risoluzione;
    }

    public double getLunghezza_spettrale() {
        return lunghezza_spettrale;
    }

    public void setLunghezza_spettrale(double lunghezza_spettrale) {
        this.lunghezza_spettrale = lunghezza_spettrale;
    }

    public String getStrumento() {
        return strumento;
    }

    public void setStrumento(String strumento) {
        this.strumento = strumento;
    }

    public Flusso getFlussi() {
        return flusso;
    }

    public void setFlussi(Flusso flusso) {
        this.flusso = flusso;
    }
}
