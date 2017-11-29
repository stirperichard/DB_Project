package com.afjcjsbx.mrg.model;

/**
 * Created by afjcjsbx on 24/02/17.
 */
public class ClumpBean {

    private String clump_id;

    public String getClump_id() {
        return clump_id;
    }

    public void setClump_id(String clump_id) {
        this.clump_id = clump_id;
    }

    public boolean validate(){
        if(!clump_id.isEmpty()){
            return true;
        }
        return false;
    }
}
