package com.classnet.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionResolver {
    
    public static void create( HttpServletRequest request, String key, Object obj){
        HttpSession session = request.getSession();  
        session.setAttribute(key, obj);
    }
    
    public static HttpSession getSession() {
    	RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
	    
		ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
	    
	    HttpServletRequest request = attributes.getRequest();
	    
	    return request.getSession(true);
    }
    
}
