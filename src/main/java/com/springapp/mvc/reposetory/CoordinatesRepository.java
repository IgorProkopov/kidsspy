package com.springapp.mvc.reposetory;

public interface CoordinatesRepository {

    public Double[] getCoordinates(String name, String date);

    public String getDate();

    public void setDate(String date);

    public void setCoordinates(Double[] coordinates);

}
