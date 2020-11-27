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

import com.classnet.model.Poll;
import com.classnet.model.Student;
import com.classnet.util.DBConnection;
import com.classnet.util.SessionResolver;

@Repository
public class PollDao {

	private Connection con;
	
	@Autowired
	StudentDao sdao;
	
	HashMap<String,Student> students ;
	
	
	public int addPoll(Poll poll) {
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getInstance().getConnection();
            //Statement st = con.createStatement();
            

            HttpSession httpSession = SessionResolver.getSession(); 
            
            // TODO keep check if session is NULL
            String id =(String) httpSession.getAttribute("ssid");
            System.out.println("id = " + id);
            
            String sql = "insert into poll values(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, poll.getPollid());
            pstmt.setString(2, poll.getPollTitle());
            pstmt.setString(3, new Date(poll.getPollDate()));
            pstmt.setDate(4,poll.getStatus());
            pstmt.setInt(5, new Date(poll.getStartDate()));
            pstmt.setInt(6, new Date(poll.getEndDate()));
            pstmt.setBoolean(7, poll.getPollSsid());
            pstmt.setString(8,poll.getBatch_id());
            int rows = pstmt.executeUpdate();
            
            return rows;
            
	
	 } catch (ClassNotFoundException ex) {
            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
     }
		
		return 0;
	}

    public int addPollOption(Poll poll) {
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getInstance().getConnection();
            //Statement st = con.createStatement();
            

            HttpSession httpSession = SessionResolver.getSession(); 
            
            // TODO keep check if session is NULL
            String id =(String) httpSession.getAttribute("ssid");
            System.out.println("id = " + id);
            
            HashMap<int,String> poll_option_data = new HashMap<>();

            poll_option_data = getPollOptionData();
            int rows=0;
            for (poll_option_data.Entry<int, String> e : poll_option_data.entrySet()){
            
                String sql = "insert into poll_option values(?,?,?)";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(2, poll.getPollid());
                pstmt.setString(1, e.getKey());
                pstmt.setString(3, e.getValue());
                rows += pstmt.executeUpdate();
            }
            return rows;
            
	
	 } catch (ClassNotFoundException ex) {
            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
     }
		
		return 0;
	}

    public int addPollAns(Poll poll) {
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getInstance().getConnection();
            //Statement st = con.createStatement();
            

            HttpSession httpSession = SessionResolver.getSession(); 
            
            // TODO keep check if session is NULL
            String id =(String) httpSession.getAttribute("ssid");
            System.out.println("id = " + id);
            
            HashMap<int,String> poll_ans_data = new HashMap<>();

            poll_ans_data = getPollAnsCount();
            int rows=0;
            for (poll_ans_data.Entry<int, String> e : poll_ans_data.entrySet()){
            
                String sql = "insert into poll_answer values(?,?,?)";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, poll.getPollid());
                pstmt.setString(2, e.getKey());
                pstmt.setString(3, e.getPollSsid());
                rows += pstmt.executeUpdate();
            }
            return rows;
            
	
	 } catch (ClassNotFoundException ex) {
            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
     }
		
		return 0;
	}

    public void changeStatus(){
        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DBConnection.getInstance().getConnection();
                String sql = "UPDATE poll SET status = 0 WHERE CURRENT_TIMESTAMP > end_date;";
                PreparedStatement pstmt = con.prepareStatement(sql);
	            int rows = pstmt.executeUpdate();

        }
        catch (ClassNotFoundException ex) {
	            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (SQLException ex) {
	            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
	    }

    }
	
	public ArrayList<Poll> getAllRemainingPoll(){
            ArrayList<Poll> poll = new ArrayList<Poll>();
	    
	    HttpSession httpSession = SessionResolver.getSession(); 
	    
	    // TODO keep check if session is NULL
	    String id =(String) httpSession.getAttribute("ssid");
	    System.out.println("id = " + id);
	    
	    //students = new HashMap<String,Student>();
	    
		try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DBConnection.getInstance().getConnection();
	            //Statement st = con.createStatement();
	            
	            changeStatus();
	            
                String sql = "select * from poll where batch_id = ? and status = 1";
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, id.substring(0,6));
	            ResultSet rs = pstmt.executeQuery();
	            
	            while(rs.next()) {

	            	Poll p = new Poll();
	            	
                    p.setPollid(rs.getInt(1));
                    p.setPollTitles(rs.getString(2));
                    p.setPollDate(rs.getDate(3));
                    p.setStatus(rs.getInt(4));
                    p.setStartDate(rs.getDate(5));
                    p.setEndDate(rs.getDate(6));
                    p.setPollSsid(rs.getString(7));

	            	//get option data of particular poll;
                    String sql2 = "select * from poll_option where poll_id = ?";
	                PreparedStatement pstmt2 = con.prepareStatement(sql2);
	                pstmt2.setString(1, p.getPollid());
	                ResultSet rs2 = pstmt2.executeQuery();
                
                    HashMap<int,String> poll_option_data = new HashMap<>();

                    while(rs2.next()){
                        poll_option_data.put(rs2.getInt(1),rs2.getString(3));    
                    }
                    
                    p.setPollOptionData(poll_option_data);

	            	poll.add(p);
	            }       
		
		 } catch (ClassNotFoundException ex) {
	            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
	     } catch (SQLException ex) {
	            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
	     }
		 
		 return poll;
	
	}

    public ArrayList<Poll> getAllFinshedPoll(){
            ArrayList<Poll> poll = new ArrayList<Poll>();
	    
	    HttpSession httpSession = SessionResolver.getSession(); 
	    
	    // TODO keep check if session is NULL
	    String id =(String) httpSession.getAttribute("ssid");
	    System.out.println("id = " + id);
	    
	    //students = new HashMap<String,Student>();
	    
		try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DBConnection.getInstance().getConnection();
	            //Statement st = con.createStatement();
	            
                String sql = "select * from poll where batch_id = ? and status = 0";
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, id.substring(0,6));
	            ResultSet rs = pstmt.executeQuery();
	            
	            while(rs.next()) {

	            	Poll p = new Poll();
	            	
                    p.setPollid(rs.getInt(1));
                    p.setPollTitles(rs.getString(2));
                    p.setPollDate(rs.getDate(3));
                    p.setStatus(rs.getInt(4));
                    p.setStartDate(rs.getDate(5));
                    p.setEndDate(rs.getDate(6));
                    p.setPollSsid(rs.getString(7));

	            	//get option data of particular poll;
                    String sql2 = "select * from poll_option where poll_id = ?";
	                PreparedStatement pstmt2 = con.prepareStatement(sql2);
	                pstmt2.setString(1, p.getPollid());
	                ResultSet rs2 = pstmt2.executeQuery();
                
                    HashMap<int,String> poll_option_data = new HashMap<>();

                    while(rs2.next()){
                        poll_option_data.put(rs2.getInt(1),rs2.getString(3));    
                    }
                    
                    p.setPollOptionData(poll_option_data);

                    //get total count of submited ans option of particular poll;
                    String sql3 = "select poll_option_id, count(poll_option_id) from poll_answer where poll_id = ? group by poll_option_id";
	                PreparedStatement pstmt3 = con.prepareStatement(sql3);
	                pstmt3.setString(1, p.getPollid());
	                ResultSet rs3 = pstmt3.executeQuery();
                
                    HashMap<int,String> poll_ans_count = new HashMap<>();

                    while(rs3.next()){
                        poll_ans_count.put(rs2.getInt(1),rs2.getString(2));    
                    }
                    
                    p.setPollAnsCount(poll_ans_count);

	            	poll.add(p);
	            }       
		
		 } catch (ClassNotFoundException ex) {
	            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
	     } catch (SQLException ex) {
	            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
	     }
		 
		 return poll;
	
	}

    public ArrayList<Poll> getAllMyPoll(){
            ArrayList<Poll> poll = new ArrayList<Poll>();
	    
	    HttpSession httpSession = SessionResolver.getSession(); 
	    
	    // TODO keep check if session is NULL
	    String id =(String) httpSession.getAttribute("ssid");
	    System.out.println("id = " + id);
	    
	    //students = new HashMap<String,Student>();
	    
		try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DBConnection.getInstance().getConnection();
	            //Statement st = con.createStatement();
	            
                String sql = "select * from poll where batch_id = ? and ssid = ?";
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, id.substring(0,6));
                pstmt.setString(2, id);

	            ResultSet rs = pstmt.executeQuery();
	            
	            while(rs.next()) {

	            	Poll p = new Poll();
	            	
                    p.setPollid(rs.getInt(1));
                    p.setPollTitles(rs.getString(2));
                    p.setPollDate(rs.getDate(3));
                    p.setStatus(rs.getInt(4));
                    p.setStartDate(rs.getDate(5));
                    p.setEndDate(rs.getDate(6));
                    p.setPollSsid(rs.getString(7));

	            	poll.add(p);
	            }       
		
		 } catch (ClassNotFoundException ex) {
	            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
	     } catch (SQLException ex) {
	            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
	     }
		 
		 return poll;
	}

    