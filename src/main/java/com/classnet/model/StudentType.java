package com.classnet.model;

public class StudentType {
	
	
	private int student_type_id;
	private String student_type_name;
	public int getStudent_type_id() {
		return student_type_id;
	}
	public void setStudent_type_id(int student_type_id) {
		this.student_type_id = student_type_id;
	}
	public String getStudent_type_name() {
		return student_type_name;
	}
	public void setStudent_type_name(String student_type_name) {
		this.student_type_name = student_type_name;
	}
	@Override
	public String toString() {
		return "StudentType [student_type_id=" + student_type_id + ", student_type_name=" + student_type_name + "]";
	}
	
}
