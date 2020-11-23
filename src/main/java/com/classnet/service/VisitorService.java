package com.classnet.service;

import com.classnet.dao.VisitorDao;
import com.classnet.util.SessionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {
    
    @Autowired            
    VisitorDao visdao;
    
    public boolean login(String email, String pass) {
        boolean result = false;
        result = visdao.login(email, pass);        
        return result;
    }
    
    public boolean registration_check(String email) {
        boolean result = false;
        boolean result2 = false;
        result = visdao.registration(email);      
        return result ;
    }
    
    public boolean registration(String email,String name,String program_id, int student_type_id,String ssid) {
        boolean result = false;
        result = visdao.registration(email,name,program_id,student_type_id,ssid);        
        return result;
    }
    
}