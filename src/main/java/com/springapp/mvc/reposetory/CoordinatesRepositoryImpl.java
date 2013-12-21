package com.springapp.mvc.reposetory;

import org.springframework.stereotype.Repository;


@Repository
public class CoordinatesRepositoryImpl implements CoordinatesRepository {


     Sender s = new Sender("178.150.190.201");




    @Override
    public Double[] getCoordinates(String name, String date) {
        String[] cors = s.getCoordinates("Сын", "17.12.2013");
        Double[] res = new Double[cors.length];
        for(int x = 0;x<cors.length;x++){
            res[x]= Double.parseDouble(cors[x]);
        }
        return res;
    }

    @Override
    public String getDate() {
        return null;
    }

    @Override
    public void setDate(String date) {

    }

    @Override
    public void setCoordinates(Double[] coordinates) {

    }
}
