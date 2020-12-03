package com.classnet.model;

import org.springframework.stereotype.Component;

@Component
public class Program {

	
	private String program_id;
	private String program_name;
	private int duration;
        private int student_count;
	public String getProgram_id() {
		return program_id;
	}
	public void setProgram_id(String program_id) {
		this.program_id = program_id;
	}
	public String getProgram_name() {
		return program_name;
	}
	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
        public int getStudentCount() {
		return student_count;
	}
        public void setStudentCount(int student_count) {
		this.student_count = student_count;
	}

    @Override
    public String toString() {
        return "Program{" + "program_id=" + program_id + ", program_name=" + program_name + ", duration=" + duration + "student_count" +student_count + '}';
    }
	
	
}
