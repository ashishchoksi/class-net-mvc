/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classnet.service;

/**
 *
 * @author dell
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
 
@Service("emailService")
public class EmailService 
{
    @Autowired
    private JavaMailSender mailSender;
      
    @Autowired
    private SimpleMailMessage preConfiguredMessage;
  
    /**
     * This method will send compose and send the message 
     * */
    public void sendMail(String to, String subject, String body) 
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
  
    /**
     * This method will send a pre-configured message
     * */
//    public void sendPreConfiguredMail(String message) 
//    {
//        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
//        mailMessage.setText(message);
//        mailSender.send(mailMessage);
//    }
}
