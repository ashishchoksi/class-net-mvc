package com.classnet.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @RequestMapping(value="/post-message",method = RequestMethod.POST)
    public String post_message(@RequestParam("title") String title , @RequestParam("msgContent") String msg_content,Model model){
    	
    	if(msgService.postMessage(title,msg_content) > 0) {
    		
    		
    		ArrayList<Message> msgs;
        	
        	msgs = msgService.getAllMessages(); //wat abt specific types of messages
        
        	model.addAttribute("msgs" , msgs);
    		
    		
    		return "view-message";
    		
    	}
    	model.addAttribute("error","Error posting message");
    	
        return "post-message";
    }
    
    @RequestMapping(value="/post-message",method = RequestMethod.GET)
    public String postMessage() {
    	return "post-message";
    }
    
    
}
