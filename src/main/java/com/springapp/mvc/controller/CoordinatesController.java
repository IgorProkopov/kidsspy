package com.springapp.mvc.controller;

import com.springapp.mvc.service.CoordinatesService;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Hashtable;

@Controller
public class CoordinatesController {

    @Autowired
    private CoordinatesService coordinatesService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getnames", method = RequestMethod.POST)
    public String printWelcome(@RequestParam(value = "name", required = true) String name,
                               @RequestParam(value = "date", required = true) String date,
                               ModelMap model) {
        System.out.println(name + " " + date);
        String[] children = userService.getConnectedChildren(name);
        Hashtable<String, Double[]> coordinates = new Hashtable<String, Double[]>();
        for(int x = 0; x<children.length;x++){
            coordinates.put(children[x], coordinatesService.getCoordinates(children[x], date));
        }
        model.addAttribute("message", coordinates);
        return "hello";
    }

}