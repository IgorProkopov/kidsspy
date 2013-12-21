package com.springapp.mvc.controller;

import com.springapp.mvc.service.CoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private CoordinatesService coordinatesService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
        Double[] d = coordinatesService.getCoordinates(null,null);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int x = 0;x<d.length-1;x++){
            sb.append(String.valueOf(d[x]));
            sb.append(",");
        }
        sb.append(String.valueOf(d[d.length-1]));
		model.addAttribute("message", sb.toString());
		return "hello";
	}

}