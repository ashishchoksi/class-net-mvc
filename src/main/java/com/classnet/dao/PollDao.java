package com.classnet.dao;

import com.classnet.model.Comment;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
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
        int poll_id;
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getInstance().getConnection();
            //Statement st = con.createStatement();
            

            HttpSession httpSession = SessionResolver.getSession(); 
            
            // TODO keep check if session is NULL
            String id =(String) httpSession.getAttribute("ssid");
            System.out.println("id = " + id);
            
            String sql = "INSERT INTO `poll`(`poll_title`, `poll_date`, `status`, `start_date`, `end_date`, `ssid`, `batch_id`) VALUES (?,CURRENT_TIMESTAMP,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, poll.getPollTitle());
            pstmt.setInt(2,poll.getStatus());
            pstmt.setDate(3,new Date(poll.getStartDate().getTime()));
            pstmt.setDate(4,new Date(poll.getEndDate().getTime()));
            pstmt.setString(5, poll.getPollSsid());
            pstmt.setString(6,poll.getPollBatchId());
            int rows = pstmt.executeUpdate();
            
            String sql2 = "SELECT poll_id FROM `poll` ORDER BY poll_date DESC LIMIT 1"
            PreparedStatement pstmt2 = con.prepareStatement(sql2);
            ResultSet rs2 = pstmt2.executeQuery();
	            
	        while(rs2.next()) {
                poll_id = rs2.getInt(1);
            }
            System.out.println('created poll id = '+poll_id);
            return poll_id;
            
	
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
            
            HashMap<Integer,String> poll_option_data = new HashMap<>();

            poll_option_data = poll.getPollOptionData();
            int rows=0;
            for (Entry<Integer,String> e : poll_option_data.entrySet()){
    
                String sql = "INSERT INTO `poll_option`(`poll_id`, `poll_option_data`) VALUES (?,?)";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, poll.getPollid());
                pstmt.setString(2, e.getValue());
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
        
            String sql = "insert into poll_answer values(?,?,?)";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, poll.getPollid());
                pstmt.setInt(2, poll.getPollAns());
                pstmt.setString(3, id);
                int rows = pstmt.executeUpdate();
            }
            return rows;
            
	
	 } catch (ClassNotFoundException ex) {
            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, null, ex);
     }
		
		return 0;
	}

    public int deletePoll(int poll_id) {
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DBConnection.getInstance().getConnection();
            //Statement st = con.createStatement();
            

            HttpSession httpSession = SessionResolver.getSession(); 
            
            // TODO keep check if session is NULL
            String id =(String) httpSession.getAttribute("ssid");
            System.out.println("id = " + id);
            String sql = "UPDATE poll SET status = 2 WHERE poll_id  = ? ;";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, poll_id);
            int rows = pstmt.executeUpdate();
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
                    p.setPollTitle(rs.getString(2));
                    p.setPollDate(rs.getDate(3));
                    p.setStatus(rs.getInt(4));
                    p.setStartDate(rs.getDate(5));
                    p.setEndDate(rs.getDate(6));
                    p.setPollSsid(rs.getString(7));

	            	//get option data of particular poll;
                    String sql2 = "select * from poll_option where poll_id = ?";
	                PreparedStatement pstmt2 = con.prepareStatement(sql2);
	                pstmt2.setInt(1, p.getPollid());
	                ResultSet rs2 = pstmt2.executeQuery();
                
                    HashMap<Integer,String> poll_option_data = new HashMap<>();

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
                    p.setPollTitle(rs.getString(2));
                    p.setPollDate(rs.getDate(3));
                    p.setStatus(rs.getInt(4));
                    p.setStartDate(rs.getDate(5));
                    p.setEndDate(rs.getDate(6));
                    p.setPollSsid(rs.getString(7));

	            	//get option data of particular poll;
                    String sql2 = "select * from poll_option where poll_id = ?";
	                PreparedStatement pstmt2 = con.prepareStatement(sql2);
	                pstmt2.setInt(1, p.getPollid());
	                ResultSet rs2 = pstmt2.executeQuery();
                
                    HashMap<Integer,String> poll_option_data = new HashMap<>();

                    while(rs2.next()){
                        poll_option_data.put(rs2.getInt(1),rs2.getString(3));    
                    }
                    
                    p.setPollOptionData(poll_option_data);

                    //get total count of submited ans option of particular poll;
                    String sql3 = "select poll_option_id, count(poll_option_id) from poll_answer where poll_id = ? group by poll_option_id";
	                PreparedStatement pstmt3 = con.prepareStatement(sql3);
	                pstmt3.setInt(1, p.getPollid());
	                ResultSet rs3 = pstmt3.executeQuery();
                
                    HashMap<Integer,Integer> poll_ans_count = new HashMap<>();

                    while(rs3.next()){
                        poll_ans_count.put(rs2.getInt(1),rs2.getInt(2));    
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
	            
                String sql = "select * from poll where batch_id = ? and ssid = ? and status <> 2";
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, id.substring(0,6));
                pstmt.setString(2, id);

	            ResultSet rs = pstmt.executeQuery();
	            
	            while(rs.next()) {

	            	Poll p = new Poll();
	            	
                    p.setPollid(rs.getInt(1));
                    p.setPollTitle(rs.getString(2));
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

} 
