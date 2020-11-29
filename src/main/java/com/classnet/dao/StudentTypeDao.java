package com.classnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.classnet.model.StudentType;
import com.classnet.util.DBConnection;

@Repository
public class StudentTypeDao {

	
	HashMap<Integer, StudentType> stu_types;
	Connection con;
	
	public HashMap<Integer,StudentType> getAllStudentTypes(){
		
		stu_types = new HashMap<Integer,StudentType>();
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
	          con = DBConnection.getInstance().getConnection();
	          
	          String sql = "select * from student_type";
	          
	         Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery(sql);
			
	          
	          while(rs.next()) {
	        	  
	        	  StudentType s = new StudentType();
	        	  
	        	  s.setStudent_type_id(rs.getInt(1));
	        	  s.setStudent_type_name(rs.getString(2));
	        	  
	        	  stu_types.put(s.getStudent_type_id(),s);
	          }
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return stu_types;
	}
	
	
}
