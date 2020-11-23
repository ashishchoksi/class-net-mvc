package com.classnet.controller;

//import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.classnet.model.Student;
import com.classnet.service.StudentService;
//import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class HomeController {
    
    @Autowired
    StudentService stdservice;
    
    // index page set
    @RequestMapping("/")
    public String index(HttpServletRequest req){
        
        // session created
        String id = (String)req.getSession().getAttribute("ssid");
        System.out.println("id : " + id);
        
        stdservice.setStudetSession(req);
        Student std = (Student) req.getSession().getAttribute("studobj");        
        //stdservice.setStudetSession(req);
        
        System.out.println("student : " + std);
        
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
    
    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    
    }

}
