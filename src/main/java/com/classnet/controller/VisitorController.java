package com.classnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VisitorController {
    
    @RequestMapping("/forgot-password")
    public String forgot_pass(){
        return "forgot-password";
    }
    
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    
    @RequestMapping("/registration")
    public String registration(){
        return "registration";
    }
    
}
