/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classnet.service;
import com.classnet.dao.*;
import com.classnet.model.Program;
import com.classnet.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javafx.util.Pair;
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
    
    
    public ArrayList<Student> getStudentsByProgram(String progID,int year){
    	
    	ArrayList<Student> students = new ArrayList<Student>();
    	
    	students = proDao.getStudentsByProgram(progID,year);
    	
    	return students;
    	
    }
    
    public ArrayList<Pair<String,Integer>> getProgramYears(String progID){
    	
    	ArrayList<Pair<String,Integer>> progYears = proDao.getProgramYears(progID);
    	
    	
    	return progYears;
    }
    
    public HashMap<String,ArrayList<String>> getECStudntList() {
        HashMap<String,ArrayList<String>> hash_list = proDao.getECStudentList();
        return  hash_list;
    }
}
