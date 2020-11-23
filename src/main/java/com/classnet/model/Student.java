package com.classnet.model;

import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class Student {
	

	
		private String ssid;
		private String student_name;
		private String email;
		private String password;
		private int type_id;
		private int status;
		private Date reg_date;
		private Program program;
		
		public Student(String ssid) {
			this.ssid = ssid;
			
		}
		public String getSsid() {
			return ssid;
		}
		public void setSsid(String ssid) {
			this.ssid = ssid;
		}
		public String getStudent_name() {
			return student_name;
		}
		public void setStudent_name(String student_name) {
			this.student_name = student_name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getType_id() {
			return type_id;
		}
		public void setType_id(int type_id) {
			this.type_id = type_id;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public Date getReg_date() {
			return reg_date;
		}
		public void setReg_date(Date reg_date) {
			this.reg_date = reg_date;
		}
		public Program getProgram() {
			return program;
		}
		public void setProgram(Program program) {
			this.program = program;
		}

       

    @Override
    public String toString() {
        return "Student{" + "ssid=" + ssid + ", student_name=" + student_name + ", email=" + email + ", password=" + password + ", type_id=" + type_id + ", status=" + status + ", reg_date=" + reg_date + ", program=" + program + '}';
    }
		
	
}
