package com.classnet.filer;

import com.classnet.model.Student;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthFilter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {
        
        String str = req.getRequestURI();
        String[] page = str.split("/");
        String cur = page[page.length-1];
        
        Student std = null;
        std = (Student) req.getSession().getAttribute("studobj");
        
//        res.getWriter().println(str);
//        
//        for(String p : page)
//            res.getWriter().println(p);
        
//        // allow page without login
        if(cur.equals("login") || cur.equals("registration") || cur.equals("forgot-password")) {
            if(std != null) {
            	//System.out.println(cur);
                res.sendRedirect("/classnet/");
               
            }
            return true;
        }
        
        if( page.length > 2 && page[2].equals("resources") ) {
            return true;
        }
        
        if(std == null) {
            res.sendRedirect("login");
            return false;
        }
        
        return true;
    }
    
    
    
}
