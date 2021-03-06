package com.classnet.controller;

import com.classnet.service.EmailService;
import com.classnet.service.StudentService;
import com.classnet.service.VisitorService;
import com.classnet.util.SessionResolver;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VisitorController {
    
    @Autowired
    VisitorService visService;
    
    @Autowired
    StudentService studService;
    
    
    @RequestMapping("/forgot-password")
    public String forgot_pass(){
        return "forgot-password";
    }
    
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    
    @RequestMapping(path = "/forgot-password", method = RequestMethod.POST)
    public String do_forgot_pass(@RequestParam("email") String email, Model model, HttpServletRequest request ){
        String student_id = email.substring(0,9);
    	String check_collage = email.substring(10,email.length());
        if(!(check_collage.equals("daiict.ac.in"))) {
    		String str_id = check_collage + " is invalid collage";
    		model.addAttribute("err_msg", str_id);
    		return "forgot-password";
    	}
        else if(!visService.registration_check(email)) {
    		String str_id = email + " id not registered";
    		model.addAttribute("err_msg", str_id);
    		return "forgot-password";
    	} 
    	else {
    		if(visService.forgotPass(email, student_id)) {
        		model.addAttribute("success_msg", "Your new password is send to your registered email-id");
        		return "forgot-password";
    		}else {
        		model.addAttribute("err_msg", "There is some error in database please try again later");
        		return "forgot-password";
    		}
    	}
        
    }
    
    // For post request RequestMapping Look like this
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam("email") String email, @RequestParam("pass") String pass, 
            Model model, HttpServletRequest request){
        // getting data from "Form" use @RequestParam("?") -> "?" should be name attribute of form tag 
        
        // call service method
        boolean result = visService.login(email, pass);
        //System.out.println(result);
        if(result) {
            // login success
            
            // create session of student id & student obj
            String student_id = email.substring(0, 9);
            SessionResolver.create(request, "ssid", student_id);
            studService.setStudetSession(request);
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
    
    @RequestMapping(path = "/registration", method = RequestMethod.POST)
    public String doRegistration(@RequestParam("email") String email,@RequestParam("name") String name, Model model, HttpServletRequest request ) {
        String student_id = email.substring(0,9);
    	String check_collage = email.substring(10,email.length());
    	if(visService.registration_check(email)) {
    		String str_id = student_id + " is Already registed";
    		model.addAttribute("err_msg", str_id);
    		return "registration";
    	} else if(!(check_collage.equals("daiict.ac.in"))) {
    		String str_id = check_collage + " is invalid collage";
    		model.addAttribute("err_msg", str_id);
    		return "registration";
    	}
    	else {
    		final int student_type_id=1;
    		final String program_id = student_id.substring(4,6);
    		if(visService.registration(email, name, program_id, student_type_id, student_id)) {
        		model.addAttribute("success_msg", "Your password is send to your registered email-id");
        		return "registration";
    		}else {
        		model.addAttribute("err_msg", "There is some error in database please try again later");
        		return "registration";
    		}
    	}
        
    }
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest req){
        
//        work here 
    	
    	HttpSession sess = req.getSession();
    	SessionResolver.remove(req, "studobj", null);
    	SessionResolver.remove(req, "ssid", null);
    	sess.invalidate();
    	
        return "redirect:/";
    }
    
    @RequestMapping("/error")
    public String error_page(){
        return "error";
    }
    
}


