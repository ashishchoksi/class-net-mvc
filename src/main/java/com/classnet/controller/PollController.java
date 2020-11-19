package com.classnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PollController {
    
    @RequestMapping("/view-poll")
    public String view_poll(){
        return "view-poll";
    }
    
    @RequestMapping("/my-poll")
    public String my_poll(){
        return "my-poll";
    }
    
    @RequestMapping("/add-poll")
    public String add_poll(){
        return "add-poll";
    }
    
}
