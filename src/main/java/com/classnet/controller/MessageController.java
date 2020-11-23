package com.classnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {
    
    @RequestMapping("/view-message")
    public String view_message(){
        return "view-message";
    }
    
    @RequestMapping("/post-message")
    public String post_message(){
        return "post-message";
    }
    
}
