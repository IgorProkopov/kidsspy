package com.springapp.mvc.controller;

import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String printWelcome(ModelMap model) {
        System.out.println("BLABLABLABLABLABLABLABLABLABLABLABLA");
       return "login";
    }

    @RequestMapping(value = "/gotothemap", method = RequestMethod.POST)
    public String goToTheMap(@RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "pass", required = true) String pass,
                             ModelMap model) {
        int x =  userService.checkUser(name, pass);
        //if(x==1)
            return "hello";
        /*else if(x==0)
            return "login";
        else
            return "login";*/
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestParam(value = "name", required = true) String name,
                          @RequestParam(value = "pass", required = true) String pass,
                          ModelMap model) {
        userService.addNewUser(name, pass);
        return "ok";
    }

}
