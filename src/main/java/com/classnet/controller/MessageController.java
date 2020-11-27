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
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    	model.addAttribute("msg_type" , 1);
        return "view-message";
    }
    
    @RequestMapping("/delete-message")
    public String delete_message(@RequestParam("msgId") String message_id){
        System.out.println("delete " + message_id);
        msgService.delete_message(message_id);
        return "redirect:/my-message";
    }
    
    @RequestMapping("/my-message")
    public String my_message(Model model){
    	ArrayList<Message> msgs;
    	msgs = msgService.getMyMessages(); //wat abt specific types of messages
    	model.addAttribute("msgs" , msgs);
    	model.addAttribute("msg_type" , 1);
        return "my-message";
    }
    
    @RequestMapping(value="/view-message",params= {"msgID"})
    public String view_message(Model model, @RequestParam("msgID") String msgID) {
    	
    	ArrayList<Message> msgs;
    	
    	msgs = msgService.getMsgsByType(msgID);
    	
    	model.addAttribute("msgs" , msgs);
    	model.addAttribute("msg_type",Integer.parseInt(msgID));
    	return "view-message";
    }
    
    @RequestMapping(value="/post-message",method = RequestMethod.POST)
    public String post_message(@RequestParam("title") String title , @RequestParam("msgContent") String msg_content, @RequestParam(value = "isdoc", required = false) String isdoc, @RequestParam("title[]") MultipartFile[] files , Model model, HttpSession s){
    	
        boolean issuccess = false;
        ArrayList<String> file_names = new ArrayList<String>();
        // getting document array from form
        if( isdoc == null ) {
            System.out.println("not checked");
            issuccess = true;
        }
        else {
            System.out.println("length : " + files.length);
            
            for (int i = 0; i < files.length; i++) {
                    MultipartFile file = files[i];
                    if(file.getSize() == 0)
                        continue;
                    String file_name = new Date().getTime() + "_" +file.getOriginalFilename();
                    file_names.add(file_name);
                    
                    String path = s.getServletContext().getRealPath("/WEB-INF/resources/student_docs/") + file_name;           
                    
                    try {
                            System.out.println("path : " + path);
                            byte[] data = file.getBytes();
                            FileOutputStream fos = new FileOutputStream(path);
                            fos.write(data);
                            fos.close();
                            System.out.println("uploaded success !");
                    } catch (Exception e) {
                            System.out.println("Error ! " + e.getMessage());
                            issuccess = false;
                    }
            }
            issuccess = true;
        }
        
        
        // if issuccess = true go on
        // 
    	if(issuccess && msgService.postMessage(file_names, title, msg_content) > 0) {
    		    		
    		ArrayList<Message> msgs;
        	
        	msgs = msgService.getAllMessages(); //wat abt specific types of messages
        
        	model.addAttribute("msgs" , msgs);
    		
                System.out.println("just before view-message");
    		return "redirect:/view-message";
    		
    	}
    	model.addAttribute("error","Error posting message");
    	
        return "post-message";
    }
    
    @RequestMapping(value="/post-message",method = RequestMethod.GET)
    public String postMessage() {
    	return "post-message";
    }
    
    @RequestMapping(path="/comment", method = RequestMethod.POST)
    public String doComment(@RequestParam("comment") String comment, @RequestParam("mid") String message_id){
        System.out.println("comment done " + comment + " " + message_id);
        msgService.addComment(comment, message_id);
        return "redirect:/view-message";
    }
    
}
