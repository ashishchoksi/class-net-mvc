package com.classnet.service;

import com.classnet.dao.StudentDao;
import com.classnet.model.Student;
import com.classnet.util.SessionResolver;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    @Autowired
    StudentDao sdao;
    
    public void setStudetSession(HttpServletRequest req){
        HttpSession session = req.getSession();  
        String ssid = (String) session.getAttribute("ssid");
        Student student = sdao.getStudentById(ssid);
        SessionResolver.create(req, "studobj", student);       
    }
    
    public boolean check_student_password(String old_pass,HttpServletRequest req) {
        HttpSession session = req.getSession();  
        String ssid = (String)session.getAttribute("ssid");
        Student student = sdao.getStudentById(ssid);
        return old_pass.equals(student.getPassword());
    }
    
    public boolean update_password_student(String new_pass,HttpServletRequest req) {
        HttpSession session = req.getSession();  
        String ssid = (String)session.getAttribute("ssid");
        Student student = sdao.getStudentById(ssid);
        if(sdao.student_update_password(new_pass, student.getSsid())) {
            student.setPassword(new_pass);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean check_is_login(HttpServletRequest req) {
        HttpSession session = req.getSession();
        return session.getAttribute("ssid") != null;
    }
    
    public Student get_student_info(HttpServletRequest req) {
        HttpSession session = req.getSession();  
        String ssid = (String)session.getAttribute("ssid");
        Student student = sdao.getStudentById(ssid);
        return student;
    }
    
    public boolean set_student_name(String name,HttpServletRequest req) {
        HttpSession session = req.getSession();  
        String ssid = (String)session.getAttribute("ssid");
        Student student = sdao.getStudentById(ssid);
        if(sdao.student_update_name(name, ssid)) {
            student.setStudent_name(name);
            return true;
        }else {
            return false;
        }
    }
    
    public ArrayList<Student> getNotAssignedStudents(){  //get students who has not assigned any role
        ArrayList<Student> students = sdao.getNotAssignedStudents();
        return students;		
    }
    
    public void assignRole(String ssid, String role_id){
        sdao.assignRole(ssid,role_id);
    }
    
    public void revokeRole(String ssid){
        sdao.revokeRole(ssid);
    }
    
    public ArrayList<Student> getAssignedStudents(){  //get students who has assigned any role
        ArrayList<Student> students = sdao.getAssignedStudents();
        return students;		
    }
    
//    public ArrayList<Student> getStudentCount(){ //get all the students
//        ArrayList<Student> students = sdao.getStudentCount();
//        return students;		
//    }
}
