package com.classnet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddMethod {

	@RequestMapping("/add")
	public ModelAndView add( @RequestParam("t1") int i ) {
                //int i=10;
//		int i = Integer.parseInt(req.getParameter("t1"));		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("i",i);
		
                return mv;
	}
}
