package com.afjcjsbx.mrg.model;

/**
 * Created by afjcjsbx on 24/02/17.
 */
public class SatelliteBean {

    private String nome;
    private String operativo_da;
    private String agenzia;
    private String fine_operazione;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOperativo_da() {
        return operativo_da;
    }

    public void setOperativo_da(String operativo_da) {
        this.operativo_da = operativo_da;
    }

    public String getAgenzia() {
        return agenzia;
    }

    public void setAgenzia(String agenzia) {
        this.agenzia = agenzia;
    }

    public String getFine_operazione() {
        return fine_operazione;
    }

    public void setFine_operazione(String fine_operazione) {
        this.fine_operazione = fine_operazione;
    }

    public boolean validate(){
        if(!nome.isEmpty() || !operativo_da.isEmpty() || !agenzia.isEmpty() || !fine_operazione.isEmpty()){
            return true;
        }
        return false;
    }
}
