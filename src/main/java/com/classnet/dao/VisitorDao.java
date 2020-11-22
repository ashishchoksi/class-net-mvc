package com.classnet.dao;

import com.classnet.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorDao {
    
    public boolean login(String email, String pass) {
        
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getInstance().getConnection();
            //Statement st = con.createStatement();
            
            String sql = "select count(*) from student_detail where email_id = ? and password = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
//            rs.last();
//            int count = rs.getRow();            
            return (count > 0);
//            return false;
            
//            String sql = "select * from student_detail where email_id = '"+email+"' and password = '"+pass+"'";
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql);
            
//            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public void abc(){
        System.out.println("in dao");
    }
    
}
