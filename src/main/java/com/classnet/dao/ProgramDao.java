/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classnet.dao;

import com.classnet.model.Student;
import com.classnet.model.StudentType;
import com.classnet.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import com.classnet.model.*;
import com.classnet.util.SessionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javafx.util.Pair;
import javax.servlet.http.HttpSession;
/**
 *
 * @author dell
 */
@Repository
public class ProgramDao {
    
    
    HashMap<String, Integer> type_count;
    HashMap<Integer, StudentType> stu_types;
    HashMap<String, Program> programs;
    
    @Autowired
    StudentTypeDao stdao;
    
    public HashMap<String, Integer> setProgramDetail(){
        
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getInstance().getConnection();
            System.out.println("Im above query");
            String sql = "SELECT p1.`program_id`,COUNT(p1.`program_id`) as stud_count ,p1.`program_name` FROM `program` p1 JOIN student_detail p2 ON p1.`program_id`=p2.`program_id` GROUP BY p1.`program_id` ";
            PreparedStatement pstmt = con.prepareStatement(sql); 
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Im after query");
            type_count = new HashMap<String,Integer>();
            while(rs.next()){
                System.out.println("In query");
                String prog_name_key = rs.getString("program_id");
                int prog_count_value = Integer.parseInt(rs.getString("stud_count"));
                prog_name_key+= "-" + rs.getString("program_name");
                System.out.println(prog_name_key+ " " + prog_count_value);
                type_count.put(prog_name_key, prog_count_value);
            }    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return type_count;
    }
    
    public HashMap<String,Program> getAllPrograms(){
    	
    	HashMap<String,Program> progs = new HashMap<String,Program>();
    	Connection conn;
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DBConnection.getInstance().getConnection();
            
            String sql = "select * from program";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
            	Program p = new Program();
            	
            	p.setProgram_id(rs.getString(1));
            	p.setProgram_name(rs.getString(2));
            	p.setDuration(rs.getInt(3));
            	
            	progs.put(p.getProgram_id(),p);
            }
            
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return progs;
    	
    }
    
    
    
    
    public ArrayList<Student> getStudentsByProgram(String progID,int year){
    	ArrayList<Student> students = new ArrayList<Student>();
    	
    	stu_types = stdao.getAllStudentTypes();
    	programs = this.getAllPrograms();
    	
        HttpSession sess = SessionResolver.getSession();
        String ssid = (String)sess.getAttribute("ssid");
    	int curr_year =  year == 0 ? Integer.parseInt(ssid.substring(0,4)) : year;
    	
    	Program currProg = programs.get(progID);
    	Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getInstance().getConnection();
            System.out.println("Im above query");
            //String sql = "SELECT p1.`program_id`,COUNT(p1.`program_id`) as stud_count ,p1.`program_name` FROM `program` p1 JOIN student_detail p2 ON p1.`program_id`=p2.`program_id` GROUP BY p1.`program_id` ";
            
            String sql = "select * from student_detail where program_id=? and ssid LIKE ?";
            
            
            PreparedStatement pstmt = con.prepareStatement(sql); 
            pstmt.setString(1,progID);
            pstmt.setString(2, ""+curr_year+"%");
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Im after query");
            
            while(rs.next()){
                Student s = new Student();
                
                s.setSsid(rs.getString(1));
               s.setStudent_name(rs.getString(2));
               s.setEmail(rs.getString(3));
               s.setStu_type(stu_types.get(rs.getInt(4)));
               //s.setPassword(rs.getString(5));
               s.setStatus(rs.getInt(6));
               s.setProgram(currProg);
               
               students.add(s);
            }    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return students;
    	
    }

    
    public ArrayList<Pair<String,Integer>> getProgramYears(String progID){
    	
    	ArrayList<Pair<String,Integer>> progYears = new ArrayList<Pair<String,Integer>>();
    	HashSet<String> hs = new HashSet<String>();
    	Connection conn;
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DBConnection.getInstance().getConnection();
            
            String sql = "select SUBSTR(ssid, 1, 4) As BATCH from student_detail where program_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,progID);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
            	hs.add(rs.getString("BATCH"));
            }
            
            for(String year : hs) {
            	Pair<String,Integer> p = new Pair<String,Integer>(progID,Integer.parseInt(year));
            	
            	progYears.add(p);
            }
    	}
    	catch(Exception e) {
    		System.out.println("*********************************************** ERROR ********************");
    		e.printStackTrace();
    	}
    	
    	
    	return progYears;
    }
    
     public HashMap<String,ArrayList<String>> getECStudentList(){
    	
        HashMap<String,ArrayList<String>> list = new HashMap<>();
//    	ArrayList<Pair<String,Integer>> progYears = new ArrayList<Pair<String,Integer>>();
//    	HashSet<String> hs = new HashSet<String>();
    	Connection conn;
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DBConnection.getInstance().getConnection();
            
            String sql = "SELECT p1.*,p3.`program_name` FROM `student_detail` p1 JOIN `student_type` p2 ON p1.`student_type_id`=p2.`student_type_id` JOIN `program` p3 ON p1.`program_id`=p3.`program_id`WHERE p2.`student_type_id`=3 ORDER BY p3.`program_name`";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                String key_id = rs.getString("program_name");
                if(list.containsKey(key_id)) {
                    String builderBuild = rs.getString("student_name") + ":" + rs.getString("ssid");
                    list.get(key_id).add(builderBuild);
                } else {
                    ArrayList<String> arr_list = new ArrayList<>();
                    String builderBuild = rs.getString("student_name") + ":" + rs.getString("ssid");
                    arr_list.add(builderBuild);
                    list.put(key_id,arr_list);
                }
            }
    	}
    	catch(Exception e) {
    		System.out.println("*********************************************** ERROR ********************");
    		e.printStackTrace();
    	}
    	
    	
    	return list;
    }
}
