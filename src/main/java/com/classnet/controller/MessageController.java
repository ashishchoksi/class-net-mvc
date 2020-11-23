package com.classnet.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.classnet.model.Message;
import com.classnet.service.MessageService;

@Controller
public class MessageController {
    
	@Autowired
	MessageService msgService;
	
    @RequestMapping("/view-message")
    public String view_message(Model model){
    	
    	
    	ArrayList<Message> msgs;
    	
    	msgs = msgService.getAllMessages(); //wat abt specific types of messages
    	
    	
    	/*for(Message m : msgs) {
    		System.out.println(m);
    	}*/
    	
    	//ModelAndView mav = new ModelAndView("view-message");
    	//mav.add

    	model.addAttribute("msgs" , msgs);
    	
        return "view-message";
    }
    
}
