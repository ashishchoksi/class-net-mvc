package com.classnet.service;

import java.util.ArrayList;
import java.util.Date;

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
		ArrayList<Poll> p = pollDao.getAllMyPoll();
		return p;		
	}
	
    public void deletePoll(int poll_id) {
        pollDao.deletePoll(poll_id);
    }

	public int addPoll(String title, Date startDate, Date endDate, ArrayList<String> options){
        Poll p = new Poll();
        int poll_id;
        HashMap<Integer,String> poll_option_data = new HashMap<>();

        HttpSession httpSession = SessionResolver.getSession();
        String id =(String) httpSession.getAttribute("ssid");

        p.setPollTitle(title);
        p.setStatus(1);
        p.setStartDate(startDate);
        p.setEndDate(endDate);
        p.setPollSsid(id);
        p.setBatchId(id.substring(0,6));

        poll_id=pollDao.addPoll(p);
        if(poll_id==0)
            return 0;

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

        if(PollDao.addPollAns(p) == 0)
            return 0;
        return 1;
    }        
}
