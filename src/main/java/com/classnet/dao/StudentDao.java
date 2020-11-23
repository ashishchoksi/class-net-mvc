package com.classnet.dao;

import com.classnet.model.Program;
import com.classnet.model.Student;
import com.classnet.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
   
    public Student getStudentById(String ssid){
        Student student = new Student();
        Program program = new Program();
        
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getInstance().getConnection();
            
            String sql = "select ssid, student_name, email_id, password, status, registration_date, student_type_id, p.program_id, program_name, duration from student_detail sd join program p on p.program_id = sd.program_id where sd.ssid = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ssid);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                program.setProgram_id( rs.getString("program_id") );
                program.setProgram_name( rs.getString("program_name") );
                program.setDuration( rs.getInt("duration") );
                student.setSsid( ssid );
                student.setEmail( rs.getString("email_id") );
                student.setStudent_name( rs.getString("student_name") );
                student.setPassword( rs.getString("password") );
                student.setStatus( rs.getInt("status") );
                student.setType_id( rs.getInt("student_type_id") );
                student.setProgram(program);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return student;
    }
   
}
