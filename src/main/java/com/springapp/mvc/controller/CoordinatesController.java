package com.springapp.mvc.controller;

import com.springapp.mvc.service.CoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CoordinatesController {

    @Autowired
    private CoordinatesService coordinatesService;

    @RequestMapping(value = "/getnames", method = RequestMethod.POST)
    public String printWelcome(@RequestParam(value = "name", required = true) String name,
                               @RequestParam(value = "date", required = true) String date,
                               ModelMap model) {
        System.out.println(name + " " + date);
        Double[] d = coordinatesService.getCoordinates(name, date);
        model.addAttribute("message", d);
        return "hello";
    }

}