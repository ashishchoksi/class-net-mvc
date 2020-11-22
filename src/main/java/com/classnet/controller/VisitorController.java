package com.classnet.controller;

import com.classnet.service.VisitorService;
import com.classnet.util.SessionResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VisitorController {
    
    @Autowired
    VisitorService visService;
    
    @RequestMapping("/forgot-password")
    public String forgot_pass(){
        return "forgot-password";
    }
    
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    
    // For post request RequestMapping Look like this
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam("email") String email, @RequestParam("pass") String pass, 
            Model model, HttpServletRequest request){
        // getting data from "Form" use @RequestParam("?") -> "?" should be name attribute of form tag 
        
        // call service method
        boolean result = visService.login(email, pass);
        if(result) {
            // login success
            
            // create session
            // create session of student id
            String student_id = email.substring(0, 9);
            SessionResolver.create(request, "ssid", student_id);
            
            // redirect to index page
            return "redirect:/";
        }
        
        // set error message and access in jsp page -> ${err_msg}
        model.addAttribute("err_msg", new String("Email or Password not valid"));
        return "login";
    }
    
    @RequestMapping("/registration")
    public String registration(){
        return "registration";
    }
    
}
