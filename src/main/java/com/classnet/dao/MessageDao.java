package com.classnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.classnet.model.Message;
import com.classnet.model.Student;
import com.classnet.util.DBConnection;

@Repository
public class MessageDao {

	private Connection con;
	public ArrayList<Message> getAllMessages(){
		ArrayList<Message> msgs = new ArrayList<Message>();
		//String id = (String)req.getSession().getAttribute("ssid");
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
	    ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
	    HttpServletRequest request = attributes.getRequest();
	    HttpSession httpSession = request.getSession(true); 
	    
	    // TODO keep check if session is NULL
	    String id =(String) httpSession.getAttribute("ssid");
	    System.out.println("id = " + id);
	    
	    
	    
		try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DBConnection.getInstance().getConnection();
	            //Statement st = con.createStatement();
	            
	            
	            String sql = "select * from message where batch_id = ?";
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, id.substring(0,6));
	            
	            ResultSet rs = pstmt.executeQuery();
	            
	            while(rs.next()) {
	            	Message m = new Message();
	            	
	            	m.setMessage_id(rs.getString(1));
	            	m.setPosted_by(new Student(rs.getString(2)));
	            	m.setContent(rs.getString(3));
	            	m.setMessage_date(rs.getDate(4));
	            	m.setIs_document(rs.getBoolean(5));
	            	m.setStatus(rs.getBoolean(6));
	            	m.setPriority(rs.getBoolean(7));
	            	m.setBatch_id(rs.getString(8));
	            	m.setTitle(rs.getString(9));
	            	
	            	msgs.add(m);
	            	
	            }
	            
	            
	            
		
		 } catch (ClassNotFoundException ex) {
	            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
	     } catch (SQLException ex) {
	            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
	     }
		 
		 return msgs;
	
		
	}
}
