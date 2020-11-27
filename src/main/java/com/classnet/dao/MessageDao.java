package com.classnet.dao;

import com.classnet.model.Comment;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.classnet.model.Message;
import com.classnet.model.Student;
import com.classnet.util.DBConnection;
import com.classnet.util.SessionResolver;

@Repository
public class MessageDao {

	private Connection con;
	
	@Autowired
	StudentDao sdao;
	
	HashMap<String,Student> students ;
	
	
	public int postMessage(Message msg) {
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getInstance().getConnection();
            //Statement st = con.createStatement();
            
            
            String sql = "insert into message values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, msg.getMessage_id());
            pstmt.setString(2, msg.getPosted_by().getSsid());
            pstmt.setString(3, msg.getContent());
            pstmt.setDate(4,new Date(msg.getMessage_date().getTime()));
            pstmt.setInt(5, msg.isIs_document()==false ? 0 : 1);
            pstmt.setInt(6, msg.isStatus()==false ? 0 : 1);
            pstmt.setBoolean(7, msg.isPriority());
            pstmt.setString(8,msg.getBatch_id());
            pstmt.setString(9,msg.getTitle());
            pstmt.setInt(10, msg.getMsg_type());
            int rows = pstmt.executeUpdate();
            
            ArrayList<String> file_names = msg.getDocuments();
            
            if(file_names.size() > 0) {
                for(String file : file_names ){
                    String sqlQ = "insert into message_document( message_id, document_url ) values(?, ?)";
                    PreparedStatement pstmtQ = con.prepareStatement(sqlQ);
                    pstmtQ.setString(1, msg.getMessage_id());
                    pstmtQ.setString(2, file);
                    pstmtQ.executeUpdate();
                }
            }
            
            return rows;
            
	
	 } catch (ClassNotFoundException ex) {
            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
     }
		
		
		return 0;
	}
	
	public ArrayList<Message> getAllMessages(){
            ArrayList<Message> msgs = new ArrayList<Message>();
	    
	    HttpSession httpSession = SessionResolver.getSession(); 
	    
	    // TODO keep check if session is NULL
	    String id =(String) httpSession.getAttribute("ssid");
	    System.out.println("id = " + id);
	    
	    students = new HashMap<String,Student>();
	    
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
	            	Student s1;
	            	m.setMessage_id(rs.getString(1));
	            	
	            	String ssid = rs.getString(2);
	            	//m.setPosted_by(new Student(rs.getString(2)));
	            	if(!students.containsKey(ssid)) {
	            		s1 = sdao.getStudentById(ssid);	            		
	            	}
	            	else {
	            		s1 = students.get(ssid);
	            	}
	            	
	            	m.setPosted_by(s1);	            	
	            	m.setContent(rs.getString(3));
	            	m.setMessage_date(rs.getDate(4));
	            	m.setIs_document(rs.getBoolean(5));
	            	m.setStatus(rs.getBoolean(6));
	            	m.setPriority(rs.getBoolean(7));
	            	m.setBatch_id(rs.getString(8));
	            	m.setTitle(rs.getString(9));	            	
                        m.setComments( getCommentByMessageId(rs.getString(1)) );
                        m.setDocuments( getDocumentByMessage(rs.getString(1)) );
	            	msgs.add(m);
	            	
	            }
	            
	            
	            
		
		 } catch (ClassNotFoundException ex) {
	            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
	     } catch (SQLException ex) {
	            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
	     }
		 
		 return msgs;
	
		
	}
        public void addComment(String comment, String message_id){
            
            Connection con;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DBConnection.getInstance().getConnection();
                
                String ssid = (String) SessionResolver.getSession().getAttribute("ssid");
                String sql = "insert into comment(message_id, ssid, comment_content) values(?,?,?)";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, message_id);
                pstmt.setString(2, ssid);
                pstmt.setString(3, comment);
                int row=pstmt.executeUpdate();  
                System.out.println("row inserted : " + row);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
        public ArrayList<Comment> getCommentByMessageId(String message_id){
            ArrayList<Comment> comments = new ArrayList<Comment>();
            
            Connection con;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DBConnection.getInstance().getConnection();
                
                String ssid = (String) SessionResolver.getSession().getAttribute("ssid");
                String sql = "select * from comment where message_id = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, message_id);
	        ResultSet rs = pstmt.executeQuery();
	        
                while(rs.next()) {
                    Comment comment = new Comment();
                    comment.setComment_id( rs.getInt(1) );
                    comment.setMessage_id( rs.getString(2) );
                    comment.setSsid( ssid );
                    comment.setComment_content( rs.getString(4) );
                    comments.add(comment);
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return comments;
        }
        
        
        public ArrayList<String> getDocumentByMessage(String message_id){
            ArrayList<String> docs = new ArrayList<String>();
            
            Connection con;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DBConnection.getInstance().getConnection();
                
                String sql = "select * from message_document where message_id = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, message_id);
	        ResultSet rs = pstmt.executeQuery();
	        
                while(rs.next()) {
                    docs.add(rs.getString(3));                    
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return docs;
        }
        
        // --------------- GET MSG BY TYPE ------------------
        
        public ArrayList<Message> getMsgsByType(String msgID){
            ArrayList<Message> msgs = new ArrayList<Message>();
	    
	    HttpSession httpSession = SessionResolver.getSession(); 
	    
	    // TODO keep check if session is NULL
	    String id =(String) httpSession.getAttribute("ssid");
	    //System.out.println("id = " + id);
	    
	    students = new HashMap<String,Student>();
	    
	    int msg_id = Integer.parseInt(msgID);
	    
		try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DBConnection.getInstance().getConnection();
	            //Statement st = con.createStatement();
	            
	            
	            String sql = "select * from message where batch_id = ? and message_type = ?";
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, id.substring(0,6));
	            pstmt.setInt(2, msg_id);
	            ResultSet rs = pstmt.executeQuery();
	            
	            while(rs.next()) {
	            	Message m = new Message();
	            	Student s1;
	            	m.setMessage_id(rs.getString(1));
	            	
	            	
	            	String ssid = rs.getString(2);
	            	//m.setPosted_by(new Student(rs.getString(2)));
	            	if(!students.containsKey(ssid)) {
	            		
	            		s1 = sdao.getStudentById(ssid);
	            		
	            	}
	            	else {
	            		s1 = students.get(ssid);
	            	}
	            	
	            	m.setPosted_by(s1);
	            	
	            	m.setContent(rs.getString(3));
	            	m.setMessage_date(rs.getDate(4));
	            	m.setIs_document(rs.getBoolean(5));
	            	m.setStatus(rs.getBoolean(6));
	            	m.setPriority(rs.getBoolean(7));
	            	m.setBatch_id(rs.getString(8));
	            	m.setTitle(rs.getString(9));
	            	
                        m.setComments( getCommentByMessageId(rs.getString(1)) );
                       
                        m.setDocuments( getDocumentByMessage(rs.getString(1)) );
	            	msgs.add(m);
	            	
	            }
	            
	            
	            
		
		 } catch (ClassNotFoundException ex) {
	            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
	     } catch (SQLException ex) {
	            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
	     }
		 
		 return msgs;
	
		
	}
        
        //----------------------- ADD PIN ------------------------
        
        public int addPin(String msgID, String ssid) {
        	int row = 0;
        	try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DBConnection.getInstance().getConnection();
	            
	            String sql = "insert into pins values(?,?)";
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, msgID);
	            pstmt.setString(2, ssid);
	            
	             row = pstmt.executeUpdate();
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        	
        	return row;
        }
        
        
        //---------------------- GET PINNED MSGS-------------------
        public ArrayList<Message> getPinnedMessages(String uid){
            ArrayList<Message> msgs = new ArrayList<Message>();
	    
	    //HttpSession httpSession = SessionResolver.getSession(); 
	    
	    // TODO keep check if session is NULL
	    //String id =(String) httpSession.getAttribute("ssid");
	    //System.out.println("id = " + id);
	    String id = uid;
	    students = new HashMap<String,Student>();
	    
	    //int msg_id = Integer.parseInt(msgID);
	    
		try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DBConnection.getInstance().getConnection();
	            //Statement st = con.createStatement();
	            
	            
	            String sql = "select * from message where batch_id = ? and message_id in (select message_id from pins where student_id = ?)";
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, id.substring(0,6));
	            pstmt.setString(2, id);
	            ResultSet rs = pstmt.executeQuery();
	            
	            while(rs.next()) {
	            	Message m = new Message();
	            	Student s1;
	            	m.setMessage_id(rs.getString(1));
	            	
	            	
	            	String ssid = rs.getString(2);
	            	//m.setPosted_by(new Student(rs.getString(2)));
	            	if(!students.containsKey(ssid)) {
	            		
	            		s1 = sdao.getStudentById(ssid);
	            		
	            	}
	            	else {
	            		s1 = students.get(ssid);
	            	}
	            	
	            	m.setPosted_by(s1);
	            	
	            	m.setContent(rs.getString(3));
	            	m.setMessage_date(rs.getDate(4));
	            	m.setIs_document(rs.getBoolean(5));
	            	m.setStatus(rs.getBoolean(6));
	            	m.setPriority(rs.getBoolean(7));
	            	m.setBatch_id(rs.getString(8));
	            	m.setTitle(rs.getString(9));
	            	
                        m.setComments( getCommentByMessageId(rs.getString(1)) );
                       
                        m.setDocuments( getDocumentByMessage(rs.getString(1)) );
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
