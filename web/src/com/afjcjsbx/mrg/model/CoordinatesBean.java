package com.afjcjsbx.mrg.model;

public class CoordinatesBean {

    private String lat;
    private String lng;
    private String radius;


    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public boolean validate(){
        if(!lat.isEmpty() || !lng.isEmpty() || !radius.isEmpty()){
            return true;
        }
        return false;
    }
}
