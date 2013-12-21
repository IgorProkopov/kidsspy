package com.springapp.mvc.controller;

import com.springapp.mvc.reposetory.CoordinatesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

    private CoordinatesRepository coordinatesRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
        Double[] d = coordinatesRepository.getCoordinates(null,null);
		model.addAttribute("message", d.toString());
		return "hello";
	}

}