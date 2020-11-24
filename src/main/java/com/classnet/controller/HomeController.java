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
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        
        // stdservice.setStudetSession(req);
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
    public String profile(HttpServletRequest request, Model model) {
        if(stdservice.check_is_login(request)) {
            Student student = stdservice.get_student_info(request);
            if(student == null) {
                return "login";
            }
            model.addAttribute("ssid", student.getSsid());
            model.addAttribute("email", student.getEmail());
            model.addAttribute("name", student.getStudent_name());
            model.addAttribute("pgm", student.getProgram().getProgram_name());
//            System.out.println(student.getEmail() + " " + student.getStudent_name()+ " " + student.getSsid());
            return "profile";
        } else {
            return "login";
        }
        
    }
    
    
    @RequestMapping(path = "/profilePassword", method = RequestMethod.POST)
    public String doprofilePassword(@RequestParam("old_pass") String old_pass,@RequestParam("new_pass") String new_pass, @RequestParam("conf_new_pass") String re_new_pass, Model model, HttpServletRequest request ) {
    	if(stdservice.check_student_password(old_pass, request)){
            if(new_pass.equals(re_new_pass)) {
                if(new_pass.length() < 6){
                    model.addAttribute("err_msg", new String("Please Enter Valid Password"));
                    return "profile";
                } else {
                    if(stdservice.update_password_student(new_pass,request)) {
                        model.addAttribute("success_msg", new String("Passsword updated successfully!"));
                        return "profile";
                    } else {
                        model.addAttribute("err_msg", new String("There is something wrong! please try again later"));
                        return "profile";
                    }
                }
            } else {
                model.addAttribute("err_msg", new String("please match failed!"));
                return "profile";
            }
        } else {
            model.addAttribute("err_msg", new String("Password is incorrect"));
            return "profile";
        }
        
    }
    
    @RequestMapping("/profileUpdate")
    public String back_to_home_profile_update() {
        return "redirect:/profile";
    }
    @RequestMapping("/profilePassword")
    public String back_to_home_profile_password() {
        return "redirect:/profile";
    }
    
    @RequestMapping(path = "/profileUpdate", method = RequestMethod.POST)
    public String doprofileUpdate(@RequestParam("name") String name,Model model, HttpServletRequest request ) {
    	if(stdservice.set_student_name(name, request)) {
            model.addAttribute("name", name);
            return "profile";
        }
        else {
            model.addAttribute("err_msg", new String("There is something wrong! please try again later"));
            return "redirect:profile";
        }
        
    }

}
