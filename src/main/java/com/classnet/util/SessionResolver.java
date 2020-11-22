package com.classnet.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionResolver {
    
    public static void create( HttpServletRequest request, String key, Object obj){
        HttpSession session = request.getSession();  
        session.setAttribute(key, obj);
    }
    
}
