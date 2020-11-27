package com.classnet.service;

import com.classnet.dao.VisitorDao;
import java.util.UUID;
import javax.mail.SendFailedException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


@Service
public class VisitorService {

    @Autowired
    VisitorDao visdao;

    @Autowired
    ApplicationContext context;
    
    public boolean login(String email, String pass) {
        boolean result = false;
        result = visdao.login(email, pass);
        return result;
    }

    public boolean registration_check(String email) {
        boolean result = false;
        boolean result2 = false;
        result = visdao.registration(email);
        return result;
    }

    public boolean registration(String email, String name, String program_id, int student_type_id, String ssid) {
        boolean result = false;
        String password = UUID.randomUUID().toString().replaceAll("-", "");
        result = visdao.registration(email, name, program_id, student_type_id, ssid,password);
        if(result) {
            try{
                EmailService mailer = (EmailService) context.getBean("emailService");
            mailer.sendMail(email, "ClassNet Password", "Your ClassNet password is : "+password+"\nUse this password to login.");
            }
            catch(BeansException e){
                System.out.println("Email Failed!");
                boolean check_del = visdao.registration_delete_user(email, password);
                return false;
            }
            catch(Exception e){
                System.out.println("Email Failed!");
                boolean check_del = visdao.registration_delete_user(email, password);
                return false;
            }
            return true;
        } else {
            return false;
        }
//        return result;
    }
    
    
    public boolean forgotPass(String email, String ssid) {
        boolean result = false;
        String password = UUID.randomUUID().toString().replaceAll("-", "");
        result = visdao.forgotPassUpdatePass(email, ssid,password);
        if(result) {
            try{
                EmailService mailer = (EmailService) context.getBean("emailService");
                mailer.sendMail(email, "ClassNet Forgot Password", "Your New ClassNet password is : "+password+"\nUse this password to login.");
            }
            catch(BeansException e){
                System.out.println("Email Failed!");
//                boolean check_del = visdao.registration_delete_user(email, password);
                return false;
            }
            catch(Exception e){
                System.out.println("Email Failed!");
//                boolean check_del = visdao.registration_delete_user(email, password);
                return false;
            }
            return true;
        } else {
            return false;
        }
//        return result;
    }
}
