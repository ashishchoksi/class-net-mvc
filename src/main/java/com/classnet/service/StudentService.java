package com.classnet.service;

import com.classnet.dao.StudentDao;
import com.classnet.model.Student;
import com.classnet.util.SessionResolver;
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
    
}
