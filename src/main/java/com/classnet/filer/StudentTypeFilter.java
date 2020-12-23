package com.classnet.filer;

import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.classnet.model.Student;

public class StudentTypeFilter extends HandlerInterceptorAdapter {
	
	@Override
	 public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {
		
		String uri = req.getRequestURI();
		String[] page = uri.split("/");
		Student std=null;
		std = (Student) req.getSession().getAttribute("studobj");
		HashMap<Integer, HashSet<String>> pages = getPageSet();
		//System.out.println(uri + "---------------- stu filter" + std);
		
		if(uri.contains("login") || uri.contains("registration") || uri.contains("logout")) {
			
			return true;
		}
		if( page.length > 2 && page[2].equals("resources") ) {
            return true;
        }
		if(std == null) {
            res.sendRedirect("login");
            return true;
        }
		
		if(std.getStu_type().getStudent_type_id()==1) {
			
			for(String p : pages.get(1)) {
				
				if(uri.contains(p)) {
					return true;
				}
				
			}
			res.sendRedirect("view-message");
			return false;
			
			
		}
		else if(std.getStu_type().getStudent_type_id()==3) {
			return true;
		}
		else {
			for(String p : pages.get(2)) {
				if(uri.contains(p)) {
					return true;
				}
			}
			res.sendRedirect("view-message");
			return false;
		}
		
		
		
	 }
	
	
	public HashMap<Integer, HashSet<String>> getPageSet(){
		
		HashMap<Integer, HashSet<String>> pages = new HashMap<Integer, HashSet<String>>();
		
		HashSet<String> stu_pages = new HashSet<>();
		stu_pages.add("view-message");
		//stu_pages.add("index");
		stu_pages.add("view-poll");
		stu_pages.add("profile");
		stu_pages.add("forgot-password");
		pages.put(1,stu_pages);
		
		HashSet<String> cr_pages = (HashSet<String>) stu_pages.clone();
		cr_pages.add("add-poll");
		cr_pages.add("my-message");
		cr_pages.add("post-message");
		cr_pages.add("my-poll");
		
		pages.put(2, cr_pages);
		
		HashSet<String> ec_pages = (HashSet<String>) cr_pages.clone();
		ec_pages.add("revoke-permission");
		ec_pages.add("assign-permission");
		ec_pages.add("student-info");
		
		pages.put(3, ec_pages);
		
		return pages;
	}
	
}
