package com.classnet.service;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classnet.dao.MessageDao;
import com.classnet.model.Message;
import com.classnet.model.Student;
import com.classnet.util.SessionResolver;

@Service
public class MessageService {
	
	@Autowired
	MessageDao msgDao;
	
	public ArrayList<Message> getAllMessages(){
		ArrayList<Message> msgs = msgDao.getAllMessages();
		return msgs;		
	}
	
        public ArrayList<Message> getMyMessages(){
		ArrayList<Message> msgs = msgDao.getMyMessages();
		return msgs;		
	}
        
	public ArrayList<Message> getMsgsByType(String msgID){
		ArrayList<Message> msgs = msgDao.getMsgsByType(msgID);
		return msgs;		
	}
	
        public void delete_message(String msgid) {
            msgDao.delete_message(msgid);
        }
        
	public void addComment(String comment, String message_id){
            msgDao.addComment(comment, message_id);
        }
	
	public int postMessage( ArrayList<String> file_names, String title, String msg_content) {
		
		Date date = new Date();
		
		Message msg = new Message(title,msg_content);
		
		msg.setMessage_date(date);
		
		HttpSession sess = SessionResolver.getSession();
		
		Student student = (Student)sess.getAttribute("studobj");
		System.out.println("Student is " +student);
		msg.setPosted_by(student);
		
		msg.setMessage_id("msg"+date.getTime()); //returns milliseconds time
		msg.setIs_document(false);
		msg.setStatus(true);
		msg.setPriority(true);
		msg.setBatch_id(student.getSsid().substring(0,6));
		msg.setMsg_type(student.getType_id());
		msg.setDocuments(file_names);
                
		if(msgDao.postMessage(msg) > 0) return 1;
			
		return 0;
	}
        
}
