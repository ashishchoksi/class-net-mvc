package com.classnet.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classnet.dao.PollDao;
import com.classnet.model.Poll;
import com.classnet.model.Student;
import com.classnet.util.SessionResolver;

@Service
public class PollService {
	
	@Autowired
	PollDao pollDao;
	
	public ArrayList<Poll> getAllRemainingPoll(){
		ArrayList<Poll> p = pollDao.getAllRemainingPoll();
		return p;		
	}
	
    public ArrayList<Poll> getAllFinshedPoll(){
		ArrayList<Poll> p = pollDao.getAllFinshedPoll();
		return p;		
	}
        
	public ArrayList<Poll> getAllMyPoll(){
        System.out.println("my poll service in");
		ArrayList<Poll> p = pollDao.getAllMyPoll();
		return p;		
	}
	
    public int deletePoll(int poll_id) {
        if(pollDao.deletePoll(poll_id)==0)
        	return 0;
        return 1;
    }
    
    public Date StringToDate(String d){
    	Date date = new Date();
//    	String dformateString = d.substring(8,10) + "-" + d.substring(5,7) + "-" + d.substring(0,4) + "";
//    	System.out.println("dformate = "+ dformateString);
    	SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"); 
    	try {
    		date = dateFormate.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
//			System.out.println("eroor dformate = "+ dformateString);
			e.printStackTrace();
		}
//    	date.setHours(Integer.parseInt());
//    	date.setMinutes(Integer.parseInt(d.substring(14,16)));
    	return date;
    }

	public int addPoll(String title, String startDate, String endDate, ArrayList<String> options){
		
		Poll p = new Poll();
        int poll_id;
        HashMap<Integer,String> poll_option_data = new HashMap<>();
        
        HttpSession httpSession = SessionResolver.getSession();
        String id =(String) httpSession.getAttribute("ssid");
      
        p.setPollTitle(title);
        p.setStatus(1);
        p.setStartDate(StringToDate(startDate));
        p.setEndDate(StringToDate(endDate));
        p.setPollSsid(id);
        p.setPollBatchId(id.substring(0,6));

        poll_id=pollDao.addPoll(p);
        if(poll_id==0)
            return 0;
        
        System.out.println("Start date = "+ startDate );
        for(int i=0; i < options.size(); i++){
            poll_option_data.put(i,options.get(i));
        }

        p.setPollOptionData(poll_option_data);
        p.setPollid(poll_id);

        if(pollDao.addPollOption(p)==0){
        	
            pollDao.deletePoll(poll_id);
            return 0;
        }
        return 1;

    }
	
    public int addPollAns(int poll_id, int Poll_ans_id){
        Poll p = new Poll();
        HttpSession httpSession = SessionResolver.getSession();
        String id =(String) httpSession.getAttribute("ssid");

        p.setPollid(poll_id);
        p.setPollAns(Poll_ans_id);
        p.setPollSsid(id);

        if(pollDao.addPollAns(p) == 0)
            return 0;
        return 1;
    }        
}
