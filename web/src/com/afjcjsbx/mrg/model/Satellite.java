package com.afjcjsbx.mrg.model;

import java.util.Date;

public class Satellite {

    private String nome;
    private Date operativo_da;
    private int durata;
    private String agenzia;


    public Satellite(String nome, Date operativo_da, int durata, String agenzia) {
        this.nome = nome;
        this.operativo_da = operativo_da;
        this.durata = durata;
        this.agenzia = agenzia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getOperativo_da() {
        return operativo_da;
    }

    public void setOperativo_da(Date operativo_da) {
        this.operativo_da = operativo_da;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getAgenzia() {
        return agenzia;
    }

    public void setAgenzia(String agenzia) {
        this.agenzia = agenzia;
    }
}
