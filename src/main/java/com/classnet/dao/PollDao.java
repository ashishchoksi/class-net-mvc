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
		System.out.println("add Dao in");
        int poll_id =0;
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
            pstmt.setTimestamp(3, new java.sql.Timestamp(poll.getStartDate().getTime()));
            pstmt.setTimestamp(4, new java.sql.Timestamp(poll.getEndDate().getTime()));
            pstmt.setString(5, poll.getPollSsid());
            pstmt.setString(6,poll.getPollBatchId());
            int rows = pstmt.executeUpdate();
            
            String sql2 = "SELECT poll_id FROM `poll` ORDER BY poll_date DESC LIMIT 1";
            PreparedStatement pstmt2 = con.prepareStatement(sql2);
            ResultSet rs2 = pstmt2.executeQuery();
	            
	        while(rs2.next()) {
                poll_id = rs2.getInt(1);
            }
            System.out.println("created poll id = "+poll_id);
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
            
            changeStatus();
            
            String sql2 = "SELECT * FROM `poll` WHERE poll_id = ? and status=1";
            PreparedStatement pstmt2 = con.prepareStatement(sql2);
            pstmt2.setInt(1, poll.getPollid());
            ResultSet rs2 = pstmt2.executeQuery();
            
            if(rs2.next()) {
            	String sql = "insert into poll_answer values(?,?,?)";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, poll.getPollid());
                pstmt.setInt(2, poll.getPollAns());
                pstmt.setString(3, id);
                int rows = pstmt.executeUpdate();
           
            return rows;
            }
            
	
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
	            
                String sql = "SELECT * FROM `poll` WHERE batch_id = ? and status = 1 and start_date < CURRENT_TIMESTAMP and poll_id NOT IN (SELECT poll_id FROM poll_answer WHERE ssid=?)";
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, id.substring(0,6));
	            pstmt.setString(2, id);
	            ResultSet rs = pstmt.executeQuery();
	            
	            while(rs.next()) {

	            	Poll p = new Poll();
	            	
                    p.setPollid(rs.getInt(1));
                    p.setPollTitle(rs.getString(2));
                    p.setPollDate(rs.getTimestamp(3));
                    p.setStatus(rs.getInt(4));
                    p.setStartDate(rs.getTimestamp(5));
                    p.setEndDate(rs.getTimestamp(6));
                    p.setPollSsid(rs.getString(7));
                    p.setPollRemainingTime(p.getEndDate());
                    
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

                    String sql3 = "select student_name from student_detail where ssid = ? ;";
	                PreparedStatement pstmt3 = con.prepareStatement(sql3);
	                pstmt3.setString(1,p.getPollSsid());
	                ResultSet rs3 = pstmt3.executeQuery();
                    if(rs3.next()){
                        p.setPollStuName(rs3.getString(1));
                    }

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
	            
                String sql = "select * from poll where batch_id = ? and  status = 0 OR poll_id IN (SELECT poll_id FROM poll_answer WHERE ssid=? and status <> 2)";
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, id.substring(0,6));
	            pstmt.setString(2, id);
	            ResultSet rs = pstmt.executeQuery();
//	            System.out.println("polldao in");
	            while(rs.next()) {
//	            	System.out.println("while in");
	            	Poll p = new Poll();
	            	
                    p.setPollid(rs.getInt(1));
                    p.setPollTitle(rs.getString(2));
                    p.setPollDate(rs.getTimestamp(3));
                    p.setStatus(rs.getInt(4));
                    p.setStartDate(rs.getTimestamp(5));
                    p.setEndDate(rs.getTimestamp(6));
                    p.setPollSsid(rs.getString(7));
                    p.setPollRemainingTime(p.getEndDate());
	            	//get option data of particular poll;
                    String sql2 = "select * from poll_option where poll_id = ?";
	                PreparedStatement pstmt2 = con.prepareStatement(sql2);
	                pstmt2.setInt(1, p.getPollid());
	                ResultSet rs2 = pstmt2.executeQuery();
                
                    HashMap<Integer,String> poll_option_data = new HashMap<>();
//                    System.out.println("while in 1");
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
                        poll_ans_count.put(rs3.getInt(1),rs3.getInt(2));    
                    }
//                    System.out.println("while in 2");
                    p.setPollAnsCount(poll_ans_count);
                    
                    String sql4 = "SELECT po.poll_option_data FROM poll_option as po JOIN poll_answer as pa ON (po.poll_option_id = pa.poll_option_id) WHERE pa.poll_id=? and pa.ssid=? ;";
	                PreparedStatement pstmt4 = con.prepareStatement(sql4);
	                pstmt4.setInt(1, p.getPollid());
	                pstmt4.setString(2, id);
	                ResultSet rs4 = pstmt4.executeQuery();
	                if(rs4.next())
	                	p.setPollMyAns(rs4.getString(1));
	                else
	                	p.setPollMyAns("Not Given");
	                
	                String sql5 = "select student_name from student_detail where ssid = ? ;";
	                PreparedStatement pstmt5 = con.prepareStatement(sql5);
	                pstmt5.setString(1,p.getPollSsid());
	                ResultSet rs5 = pstmt5.executeQuery();
                    if(rs5.next()){
                        p.setPollStuName(rs5.getString(1));
                    }
	                    
	            	poll.add(p);
	            }       
		
		 } catch (ClassNotFoundException ex) {
	            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, "NullClass", ex);
	     } catch (SQLException ex) {
	            Logger.getLogger(VisitorDao.class.getName()).log(Level.SEVERE, "nullSQL", ex);
	     }
		 
		 return poll;
	
	}

    public ArrayList<Poll> getAllMyPoll(){
            ArrayList<Poll> poll = new ArrayList<Poll>();
            System.out.println("my poll DAo in");
	    
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
                    p.setPollDate(rs.getTimestamp(3));
                    p.setStatus(rs.getInt(4));
                    p.setStartDate(rs.getTimestamp(5));
                    p.setEndDate(rs.getTimestamp(6));
                    p.setPollSsid(rs.getString(7));
                    p.setPollRemainingTime(p.getEndDate());
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
