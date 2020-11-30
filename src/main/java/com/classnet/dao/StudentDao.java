package com.classnet.dao;

import com.classnet.model.Program;
import com.classnet.model.Student;
import com.classnet.model.StudentType;
import com.classnet.util.DBConnection;
import com.classnet.util.SessionResolver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
   
	@Autowired
	StudentTypeDao stdao;
	
	HashMap<Integer, StudentType> stu_types;
	
    public Student getStudentById(String ssid){
        Student student = new Student();
        Program program = new Program();
        stu_types = stdao.getAllStudentTypes();
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getInstance().getConnection();
            
            String sql = "select ssid, student_name, email_id, password, status, registration_date, student_type_id, p.program_id, program_name, duration from student_detail sd join program p on p.program_id = sd.program_id where sd.ssid = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ssid);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
            	StudentType s = new StudentType();
                program.setProgram_id( rs.getString("program_id") );
                program.setProgram_name( rs.getString("program_name") );
                program.setDuration( rs.getInt("duration") );
                student.setSsid( ssid );
                student.setEmail( rs.getString("email_id") );
                student.setStudent_name( rs.getString("student_name") );
                student.setPassword( rs.getString("password") );
                student.setStatus( rs.getInt("status") );
                //student.setType_id( rs.getInt("student_type_id") );
                
                // setting student type
                student.setStu_type(stu_types.get(rs.getInt("student_type_id")));
                student.setProgram(program);
            }    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return student;
    }
    
    public boolean student_update_password(String passowrd,String ssid) { 
     Connection con;
     try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DBConnection.getInstance().getConnection();
         
         String sql = "UPDATE `student_detail` SET `password`=? WHERE `ssid`=?;";
         PreparedStatement pstmt = con.prepareStatement(sql);
         pstmt.setString(2, ssid);
         pstmt.setString(1, passowrd);
         pstmt.execute();         
//         return true;
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
         return false;
     } catch (SQLException ex) {
         Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
         return false;
     } catch (Exception e) {
	return false;
	}
     return true;
 }
 
   public boolean student_update_name(String name,String ssid) { 
     Connection con;
     try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DBConnection.getInstance().getConnection();
         
         String sql = "UPDATE `student_detail` SET `student_name`=? WHERE `ssid`=?;";
         PreparedStatement pstmt = con.prepareStatement(sql);
         pstmt.setString(2, ssid);
         pstmt.setString(1, name);
         pstmt.execute();         
//         return true;
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
         return false;
     } catch (SQLException ex) {
         Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
         return false;
     } catch (Exception e) {
	return false;
	}
     return true;
 }
    
    public ArrayList<Student> getNotAssignedStudents(){
        Connection con;
        ArrayList<Student> students = new ArrayList<Student>();	    
        HttpSession httpSession = SessionResolver.getSession(); 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getInstance().getConnection();
            String sql = "select * from student_detail where student_type_id=1";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Student s=new Student();
                s.setSsid(rs.getString("ssid"));
                s.setStudent_name(rs.getString("student_name")); 
                System.out.println(s.getSsid()+" "+s.getStudent_name());
                students.add(s);
            }	            
        } catch (ClassNotFoundException ex) {
                Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
        }		 
        return students;	
    }
    
    public void assignRole(String ssid, String role_id){ //assign role
        Connection con;
        HttpSession httpSession = SessionResolver.getSession(); 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getInstance().getConnection();
            String sql = "update student_detail set student_type_id=? where ssid=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, role_id);
            pstmt.setString(2, ssid);
            pstmt.execute();
        } catch (ClassNotFoundException ex) {
                Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
        }		 
    }
    
    public void revokeRole(String ssid){ //revoke role
        Connection con;
        HttpSession httpSession = SessionResolver.getSession(); 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getInstance().getConnection();
            String sql = "update student_detail set student_type_id=1 where ssid=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ssid);
            pstmt.execute();
        } catch (ClassNotFoundException ex) {
                Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
        }		 
    }
    
    public ArrayList<Student> getAssignedStudents(){
        Connection con;
        ArrayList<Student> students = new ArrayList<Student>();	    
        HttpSession httpSession = SessionResolver.getSession(); 
        stu_types = stdao.getAllStudentTypes();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getInstance().getConnection();
            String sql = "select * from student_detail where student_type_id!=1";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Student s=new Student();
                s.setSsid(rs.getString("ssid"));
                s.setStudent_name(rs.getString("student_name")); 
                //s.setType_id(rs.getInt("student_type_id"));
                
                s.setStu_type(stu_types.get(rs.getInt("student_type_id")));
                System.out.println(s.getSsid()+" "+s.getStudent_name());
                students.add(s);
            }	            
        } catch (ClassNotFoundException ex) {
                Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
        }		 
        return students;	
    }

    public ArrayList<Student> getStudentCount(){
        Connection con;
        ArrayList<Student> students = new ArrayList<Student>();	    
        HttpSession httpSession = SessionResolver.getSession(); 
        stu_types = stdao.getAllStudentTypes();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getInstance().getConnection();
            String sql = "SELECT count(*) COUNT, SUBSTR(ssid, 1, 4) BATCH, program_name FROM `student_detail` sd join program p on p.program_id = sd.program_id group by BATCH, sd.program_id";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Student s=new Student();
                s.setSsid(rs.getString("BATCH"));
                s.setStudent_name(rs.getString("program_name")); 
                s.setPassword(rs.getString("COUNT"));
                students.add(s);
            }	            
        } catch (ClassNotFoundException ex) {
                Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
        }		 
        return students;	
    }
}