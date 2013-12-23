package com.springapp.mvc.controller;

import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        if(x==1)
            return "hello";
        else if(x==0)
            return "login";
        else
            return "login";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "name", required = true) String name,
                          @RequestParam(value = "pass", required = true) String pass,
                          ModelMap model) {
        userService.addNewUser(name, pass);
        System.out.println("Adding new user!!!");
        System.out.println(name);
        System.out.println(pass);
        return "hello";
    }

    @RequestMapping(value = "/addtrackingchild", method = RequestMethod.POST)
    public String addChild(@RequestParam(value = "child", required = true) String child,
                           @RequestParam(value = "pass", required = true) String pass,
                          @RequestParam(value = "parent", required = true) String parent,
                          ModelMap model) {
        System.out.println("Connecting child!");
        int res = userService.checkUser(child,pass);
        if(res==0){
            //Show alert dialog that password is incorrect
            System.out.println("Password is incorrect!");
            return "hello";
        }
        if(res==-1){
            //Show alert dialog that user is not exist
            System.out.println("User is not exisit!");
            return "hello";
        }
        if(res== 1){
        res = userService.connectChild(child, parent);
            if(res == 0){
                //Show alert dialog that user has already connected
                System.out.println("User has been already connected!");
                return "hello";
            }
            if(res == 1){
                //Show alert dialog user has been sucssefully connected
                System.out.println("User has beenconnected!");
                return "hello";
            }
        return "hello";
        }
        return "hello";
    }

}
