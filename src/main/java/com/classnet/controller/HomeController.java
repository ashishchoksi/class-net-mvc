package com.classnet.controller;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    // index page set
    @RequestMapping("/")
    public String index(){
        // serive.getpage(): return
        return "index";
    }
    
    @RequestMapping("/student-info")
    public String student_info(){
        return "student-info";
    }
    
    @RequestMapping("/assign-permission")
    public String assign_permission(){        
        return "assign-permission";
    }
    
    @RequestMapping("/revoke-permission")
    public String revoke_permission(){
        return "revoke-permission";
    }
    
}
