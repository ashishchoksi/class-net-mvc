/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classnet.service;
import com.classnet.dao.*;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dell
 */
@Service
public class ProgramService {
    
    @Autowired
    ProgramDao proDao;
    HashMap<String,Integer> countMap;
    public HashMap<String,Integer> getStudentCount() {
        System.out.println("***********************");
        countMap = proDao.setProgramDetail();
        System.out.println("***********************");
        return countMap;
    }
    
}
