package com.classnet.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.classnet.model.Poll;
import com.classnet.service.PollService;
import com.classnet.util.SessionResolver;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PollController {

    @Autowired
    PollService pService;
    
    
    @RequestMapping("/view-poll")
    public String view_poll(Model m){
        ArrayList<Poll> pRemaining = null;
        ArrayList<Poll> pFineshed = null;

        pRemaining = pService.getAllRemainingPoll();
        pFineshed = pService.getAllFinshedPoll();

        m.addAttribute("pRemaining" , pRemaining);
    	m.addAttribute("pFineshed" , pFineshed);

        return "view-poll";
    }

    @RequestMapping(value="/view-poll",method = RequestMethod.POST)
    public String view_poll(Model m,@RequestParam("poll_id") int poll_id,@RequestParam("poll_option_id") int poll_option_id){
    	ArrayList<Poll> pRemaining = null;
        ArrayList<Poll> pFineshed = null;
        
        
        if(pService.addPollAns(poll_id,poll_option_id)==0) {
        	m.addAttribute("notCompleteTransction","Your Transction is failed..! May be Poll Time Was Up OR Try Again..");
        	pRemaining = pService.getAllRemainingPoll();
            pFineshed = pService.getAllFinshedPoll();

            m.addAttribute("pRemaining" , pRemaining);
        	m.addAttribute("pFineshed" , pFineshed);

        	return "view-poll";
        }
           
        m.addAttribute("completeTransction","Your Answer Is Successfully Saved...!");
        pRemaining = pService.getAllRemainingPoll();
        pFineshed = pService.getAllFinshedPoll();

        m.addAttribute("pRemaining" , pRemaining);
    	m.addAttribute("pFineshed" , pFineshed);

        return "view-poll";
    }
    
    @RequestMapping("/my-poll")
    public String my_poll(Model m){
        ArrayList<Poll> myPoll=null;
        myPoll = pService.getAllMyPoll();
        m.addAttribute("myPoll",myPoll);
        return "my-poll";
    }

    @RequestMapping(value="/my-poll",method = RequestMethod.POST)
    public String my_poll(Model m,@RequestParam("poll_id") int poll_id){
    	ArrayList<Poll> myPoll=null;
        
        if(pService.deletePoll(poll_id) == 0) {
        	m.addAttribute("notCompleteTransction","Your Transction is failed.! Try Again...!");
        	myPoll = pService.getAllMyPoll();
            m.addAttribute("myPoll",myPoll);
        	
        	return "my-poll";
        }
        	
        myPoll = pService.getAllMyPoll();
        m.addAttribute("myPoll",myPoll);
    	
        m.addAttribute("completeTransction","Your Poll Delete Transction is Successfull...!");
        return "my-poll";
    }

    
    @RequestMapping("/add-poll")
    
    public String add_poll(){
    	
    	return "add-poll";
    }

    @RequestMapping(value="/add-poll",method = RequestMethod.POST)
    public String add_poll(Model m, @RequestParam("poll_title") String poll_title, @RequestParam("start_date") String start_date, @RequestParam("end_date") String end_date, @RequestParam("title[]") ArrayList<String> poll_options){
    	if((poll_title.length()<1) || (start_date.length()<1) || (end_date.length()<1)) {
    		m.addAttribute("notCompleteTransction","Please fill all the Data");
    		return "add-poll";
    	}
    	for(String option : poll_options) {
    		if(option.length()<1) {
    			m.addAttribute("notCompleteTransction","Please fill all the Data");
        		return "add-poll";
    		}
    	}
    		
        if(pService.addPoll(poll_title,start_date,end_date,poll_options)==0)
            m.addAttribute("completeTransction","Your Transction is failed.! Try Again..");
        
        m.addAttribute("completeTransction","Your Poll Record Is Successfully Saved...!");
        return "add-poll";
    }
    
}
