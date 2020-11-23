package com.classnet.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classnet.dao.MessageDao;
import com.classnet.model.Message;

@Service
public class MessageService {
	
	@Autowired
	MessageDao msgDao;
	
	public ArrayList<Message> getAllMessages(){
		ArrayList<Message> msgs = msgDao.getAllMessages();
		return msgs;		
	}

        public void addComment(String comment, String message_id){
            msgDao.addComment(comment, message_id);
        }
        
}
