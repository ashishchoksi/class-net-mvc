package com.classnet.model;

import java.util.Date;
import java.util.HashMap;
//import java.lang.ref.Cleaner.Cleanable;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class Poll{
	
    private int poll_id;
    private String poll_title;
    private Date poll_date;
    private Date start_date;
    private Date end_date;
    private Calendar cal_start_date;
    private Calendar cal_end_date;
    private int status;
    private String batch_id;
    private String ssid;
    private String stuName;
    private String myAns;
    private int ans_option_id;
    private String remainingTime;
    private HashMap<Integer,String> poll_option_data;
    private HashMap<Integer,Integer> poll_ans_count;
    
    public Poll() {}
    
    public int getPollid() {
            return poll_id;
    }
    public void setPollid(int pollid) {
            this.poll_id = pollid;
    }
    public String getPollTitle() {
            return poll_title;
    }
    public void setPollTitle(String poll_title) {
            this.poll_title = poll_title;
    }
    public Date getStartDate() {
            return start_date;
    }
    public void setStartDate(Date start_date) {
            this.start_date = start_date;
    }
    public Date getEndDate() {
            return end_date;
    }
    public void setEndDate(Date end_date) {
            this.end_date = end_date;
    }
    public void setCalStartDate(Calendar cal_start_date) {
    	this.cal_start_date = cal_start_date;
    }
    public void setCalEndtDate(Calendar cal_end_date) {
    	this.cal_end_date = cal_end_date;
    }
    public Calendar getCalStartDate() {
    	return cal_start_date;
    }
    public Calendar getCalEndtDate() {
    	return cal_end_date ;
    }
    public int getStatus() {
            return status;
    }
    public void setStatus(int status) {
            this.status = status;
    }
    public Date getPollDate() {
            return poll_date;
    }
    public void setPollDate(Date poll_date) {
            this.poll_date = poll_date;
    }
    public String getPollSsid() {
            return ssid;
    }
    public void setPollSsid(String ssid) {
            this.ssid = ssid;
    }
    
    public String getPollStuName() {
            return stuName;
    }
    public void setPollStuName(String stuName) {
            this.stuName = stuName;
    }
    public String getPollBatchId() {
            return batch_id;
    }
    public void setPollBatchId(String batch_id) {
            this.batch_id = batch_id;
    }
    public String getPollMyAns() {
        return myAns;
    }
    public void setPollMyAns(String myAns) {
        this.myAns = myAns;
    }
        public int getPollAns() {
            return ans_option_id;
    }
    public void setPollAns(int ans_option_id) {
            this.ans_option_id = ans_option_id;
    }

    public HashMap<Integer,String> getPollOptionData() {
        return poll_option_data;
    }
    public void setPollOptionData(HashMap<Integer,String> poll_option_data) {
        this.poll_option_data = poll_option_data;
    }
    public HashMap<Integer,Integer> getPollAnsCount() {
        return poll_ans_count;
    }
    public void setPollAnsCount(HashMap<Integer,Integer> poll_ans_count) {
        this.poll_ans_count = poll_ans_count;
    }

    public String getPollRemainingTime() {
        return remainingTime;
    }
    public void setPollRemainingTime(Date d) {
    	Date current = new Date();
    	if((current.getYear()-d.getYear())>0)
    		this.remainingTime = current.getYear()-d.getYear() + " Years";
    	else if((current.getMonth() -d.getMonth())>0)
    		this.remainingTime = current.getMonth()-d.getMonth() + " Months";
    	else if((current.getDay() -d.getDay())>0)
    		this.remainingTime = current.getDay()-d.getDay() + " Days";
    	else if((current.getHours() -d.getHours())>0)
    		this.remainingTime = current.getHours()-d.getHours() + " Hours";
    	else if((current.getMinutes() -d.getMinutes())>0)
    		this.remainingTime = current.getMinutes()-d.getMinutes() + " Minutes";
    	else if((current.getSeconds()-d.getSeconds())>0)
    		this.remainingTime = current.getSeconds()-d.getSeconds() + " Seconds";
    }
    @Override
    public String toString() {
        return "Poll{" + "poll_id=" + poll_id + ", poll_title=" + poll_title + ", poll_date=" + poll_date + ", start_date=" + start_date + ", end_date=" + end_date + ", status=" + status + '}';
    }
		
	
}
