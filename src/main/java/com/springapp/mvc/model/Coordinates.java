package com.springapp.mvc.Model;

public class Coordinates {
    String date;
    String[] coordinates;

    public void setDate(String date){
        this.date=date;
    }

    public String getDate(){
        return this.date;
    }

    public void setCordinates(String[] coordinates){
        this.coordinates=coordinates;
    }

    public void setCoordinates(String... coordinates){
        this.coordinates = coordinates.clone();
    }

}