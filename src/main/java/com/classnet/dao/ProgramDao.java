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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import com.classnet.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author dell
 */
@Repository
public class ProgramDao {
    
    @Autowired
    HashMap<String, Integer> type_count;
    
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
                int prog_count_value = Integer.parseInt(rs.getString("stud_count"));
                String prog_name_key = rs.getString("program_name");
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
    
}
