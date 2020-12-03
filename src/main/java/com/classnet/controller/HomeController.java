package com.classnet.controller;

//import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.classnet.model.Student;
import com.classnet.service.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    
    @Autowired
    ProgramService proService;
    
    boolean isError=false;
    int count_page=0;
    HashMap<String,Integer> countProMap;
    
    // index page set
    @RequestMapping("/")
    public String index(HttpServletRequest req, Model model){
        // session created
        String id = (String)req.getSession().getAttribute("ssid");
        System.out.println("id : " + id);
        // stdservice.setStudetSession(req);
        Student std = (Student) req.getSession().getAttribute("studobj");        
        //stdservice.setStudetSession(req);
        System.out.println("student : " + std);
        
        System.out.println("------------------------------------");
        //Fetching user data
        countProMap = new HashMap<String,Integer>();
        countProMap = proService.getStudentCount();
        
//        ArrayList<Student> students;
//        students = stdservice.getStudentCount();  //get all the students
//        for(Student s : students){ 
//           System.out.println("student : " + s);
//            System.out.println(s.getSsid());
//        }
        for(Map.Entry<String,Integer> entry : countProMap.entrySet()) {
            System.out.println(entry.getKey() + " --  " + entry.getValue() );
        }
        model.addAttribute("progCount",countProMap);
//        model.addAttribute("students" , students);
        return "index";
    }
    
    @RequestMapping("/student-info")
    public String student_info(){
        return "student-info";
    }
    
    @RequestMapping("/assign-permission")
    public String assign_permission(HttpServletRequest request, Model model){  
        if(stdservice.check_is_login(request)) {
            ArrayList<Student> students;	
            students = stdservice.getNotAssignedStudents();  //get all students who has not assigned any role
            model.addAttribute("students" , students);
            return "assign-permission";
        }
        else {
            return "redirect:/login";
        }
    }
    
    @RequestMapping(value="/assign-role",method = RequestMethod.POST)
    public String assignRole(@RequestParam("student_id") String ssid, @RequestParam("role_id") String rid, Model model, HttpSession s ){ //HttpServletRequest request,
        stdservice.assignRole(ssid, rid);
        return "redirect:/assign-permission";
    }
    
    @RequestMapping("/revoke-permission")
    public String revoke_permission(HttpServletRequest request, Model model){  
        if(stdservice.check_is_login(request)) {
            if(request.getParameter("id")!=null){
                stdservice.revokeRole(request.getParameter("id"));
                return "redirect:/revoke-permission";
            }
            else{
                ArrayList<Student> students;	
                students = stdservice.getAssignedStudents();  //get all students who has assigned any role
                model.addAttribute("students" , students);
                return "revoke-permission";
            }
        }
        else {
            return "redirect:/login";
        }
    }
    
    @RequestMapping("/profile")
    public String profile(HttpServletRequest request, Model model) {
        if(stdservice.check_is_login(request)) {
            Student student = stdservice.get_student_info(request);
            if(student == null) {
                return "redirect:/login";
            }
            if(count_page!=0) {
                if(isError)
                    model.addAttribute("err_msg", "There is something error!");
                else
                    model.addAttribute("success_msg", "profile updated successfully.");
            }
            model.addAttribute("ssid", student.getSsid());
            model.addAttribute("email", student.getEmail());
            model.addAttribute("name", student.getStudent_name());
            model.addAttribute("pgm", student.getProgram().getProgram_name());
//            System.out.println(student.getEmail() + " " + student.getStudent_name()+ " " + student.getSsid());
            count_page=0;
            return "profile";
        } else {
            return "redirect:/login";
        }
    }
    
    
    @RequestMapping(path = "/profilePassword", method = RequestMethod.POST)
    public String doprofilePassword(@RequestParam("old_pass") String old_pass,@RequestParam("new_pass") String new_pass, @RequestParam("conf_new_pass") String re_new_pass, Model model, HttpServletRequest request ) {
    	count_page++;
        if(stdservice.check_student_password(old_pass, request)){
            if(new_pass.equals(re_new_pass)) {
                if(new_pass.length() < 6){
//                    model.addAttribute("err_msg", new String("Please Enter Valid Password"));
                    isError=true;
                    return "redirect:/profile";
                } else {
                    if(stdservice.update_password_student(new_pass,request)) {
//                        model.addAttribute("success_msg", new String("Passsword updated successfully!"));
                        isError=false;
                        return "redirect:/profile";
                    } else {
//                        model.addAttribute("err_msg", new String("There is something wrong! please try again later"));
                        isError=true;
                        return "redirect:/profile";
                    }
                }
            } else {
//                model.addAttribute("err_msg", new String("please match failed!"));
                isError=true;
                return "redirect:/profile";
            }
        } else {
//            model.addAttribute("err_msg", new String("Password is incorrect"));
            isError=true;
            return "redirect:/profile";
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
        count_page++;
        if(name.length() < 3) {
            model.addAttribute("err_msg", "invalid");
            isError=true;
            return "redirect:/profile";
        }
        else if(stdservice.set_student_name(name, request)) {
//            model.addAttribute("name", name);
//            model.addAttribute("success_msg", new String("User name updated successfully!"));
            isError=false;
            return "redirect:/profile";
        }
        else {
//            model.addAttribute("err_msg", "There is something wrong! please try again later");
            isError=true;
            return "redirect:/profile";
        }
        
    }

}
