package com.classnet.model;

import java.util.Date;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class Poll{
	
    private int poll_id;
    private String poll_title;
    private Date poll_date;
    private Date start_date;
    private Date end_date;
    private int status;
    private ArrayList<int> poll_option_id;
    private ArrayList<String> poll_option_data;
    
 
    public Poll() {    }

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
    public ArrayList<String> getPollOptionData() {
        return poll_option_data;
    }
    public void setPollOptionData(ArrayList<String> poll_option_data) {
        this.poll_option_data = poll_option_data;
    }
    public ArrayList<int> getPollOptionId() {
        return poll_option_id;
    }
    public void setPollOptionId(ArrayList<int> poll_option_id) {
        this.poll_option_id = poll_option_id;
    }


    @Override
    public String toString() {
        return "Poll{" + "poll_id=" + poll_id + ", poll_title=" + poll_title + ", poll_date=" + poll_date + ", start_date=" + start_date + ", end_date=" + end_date + ", status=" + status + '}';
    }
		
	
}
