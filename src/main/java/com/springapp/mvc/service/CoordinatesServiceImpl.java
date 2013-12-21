package com.springapp.mvc.service;

import com.springapp.mvc.reposetory.CoordinatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinatesServiceImpl implements CoordinatesService {

    @Autowired
    private CoordinatesRepository coordinatesRepository;

    @Override
    public Double[] getCoordinates(String name, String date) {
        return coordinatesRepository.getCoordinates(name, date);
    }
}
