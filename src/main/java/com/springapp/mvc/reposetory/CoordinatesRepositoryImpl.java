package com.springapp.mvc.reposetory;

import org.springframework.stereotype.Repository;


@Repository
public class CoordinatesRepositoryImpl implements CoordinatesRepository {


     Sender sender = new Sender("127.0.0.1"/*"178.150.190.201"*/);




    @Override
    public Double[] getCoordinates(String name, String date) {
        String[] cors = sender.getCoordinates(name, date);
        Double[] res = new Double[cors.length];
        for(int x = 0;x<cors.length;x++){
            res[x]= Double.parseDouble(cors[x]);
        }
        return res;
    }


}
