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
    
}
