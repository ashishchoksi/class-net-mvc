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
        ArrayList<Poll> pRemaining;
        ArrayList<Poll> pFineshed;

        pRemaining = pService.getAllRemainingPoll();
        pFineshed = pService.getAllFinshedPoll();

        m.addAttribute("pRemaining" , pRemaining);
    	m.addAttribute("pFineshed" , pFineshed);

        return "view-poll";
    }

    @RequestMapping("/view-poll",method = RequestMethod.POST)
    public String view_poll(Model m,@RequestParam("poll_id") int poll_id,@RequestParam("poll_option_id") int poll_option_id){
        
        if(pService.addPollAns(poll_id,poll_option_id)==0)
            m.addAttribute('error',"error in add answer opertion");
        
        return "redirect:/view-poll";
    }
    
    @RequestMapping("/my-poll")
    public String my_poll(Model m){
        ArrayList<Poll> myPoll;

        myPoll = pService.getAllMyPoll();

        m.addAttribute("myPoll",myPoll);
        return "my-poll";
    }

    @RequestMapping("/my-poll",method = RequestMethod.POST)
    public String my_poll(Model m,@RequestParam("poll_id") int poll_id){
        
        if(pService.deletePoll(poll_id)==0)
            m.addAttribute('error',"error in delete poll");
        
        return "redirect:/my-poll";
    }

    
    @RequestMapping("/add-poll")
    public String add_poll(){
        return "add-poll";
    }

    @RequestMapping("/add-poll",method = RequestMethod.POST)
    public String add_poll(Model m, @RequestParam("poll_title") String poll_title, @RequestParam("start_date") Date start_date, @RequestParam("end_date") Date end_date, @RequestParam("options[]") ArrayList<String> poll_options){
        
        if(pService.addPoll(poll_title,start_date,end_date,poll_options)==0)
            m.addAttribute('error',"error in add poll");

        return "add-poll";
    }
    
}
