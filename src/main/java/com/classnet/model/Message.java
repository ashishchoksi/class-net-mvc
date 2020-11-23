package com.classnet.model;

import java.util.Date;

public class Message {
	
	
	private String message_id;
	private Student posted_by;
	private String title;
	

	private String content;
	
	private Date message_date;
	private boolean is_document;
	
	private boolean status;
	
	private boolean priority;
	
	private String batch_id;

	private int msg_type;
	
	public int getMsg_type() {
		return msg_type;
	}
	public void setMsg_type(int msg_type) {
		this.msg_type = msg_type;
	}
	public Message() {}
	public Message(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	@Override
	public String toString() {
		return "Message [message_id=" + message_id + ", posted_by=" + posted_by + ", title=" + title + ", content="
				+ content + ", message_date=" + message_date + ", is_document=" + is_document + ", status=" + status
				+ ", priority=" + priority + ", batch_id=" + batch_id + "]";
	}

	public String getMessage_id() {
		return message_id;
	}

	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

	public Student getPosted_by() {
		return posted_by;
	}

	public void setPosted_by(Student posted_by) {
		this.posted_by = posted_by;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getMessage_date() {
		return message_date;
	}

	public void setMessage_date(Date message_date) {
		this.message_date = message_date;
	}

	public boolean isIs_document() {
		return is_document;
	}

	
	public void setIs_document(boolean is_document) {
		this.is_document = is_document;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isPriority() {
		return priority;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	public String getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(String batch_id) {
		this.batch_id = batch_id;
	}
	
	
	
}	
