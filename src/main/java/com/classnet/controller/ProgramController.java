package com.classnet.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.classnet.model.Program;
import com.classnet.model.Student;
import com.classnet.service.ProgramService;
import javafx.util.Pair;

@Controller
public class ProgramController {
	
	@Autowired
    ProgramService programService;
	
	@RequestMapping(value="/view-program",params= {"progID","year"})
	public String getProgramBatches(@RequestParam("progID") String prog,@RequestParam("year") String year, Model model) {
		
		
		String progID = prog.substring(0,2);
		String program_name = prog.substring(3);
		ArrayList<Student> students = programService.getStudentsByProgram(progID,(Integer.parseInt(year)));
		
		ArrayList<Pair<String, Integer>> programYears = programService.getProgramYears(progID);
		
		model.addAttribute("students",students);
		model.addAttribute("progYears",programYears);
		model.addAttribute("prog_name",program_name);
		
		return "student-info";
	}

}
