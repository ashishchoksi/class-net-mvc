package com.classnet.util;

import com.classnet.model.Student;
import javax.servlet.http.HttpSession;

public class ViewManager {
    
    public static boolean isAuth(){
        HttpSession session = SessionResolver.getSession();
        Student std = (Student)session.getAttribute("studobj");
        return std != null;
    }
    
    public static int getMyID() {
        HttpSession session = SessionResolver.getSession();
        Student std = (Student)session.getAttribute("studobj");
        int type = std.getStu_type().getStudent_type_id();
        return type;
    }
        
    public static String getSideBar() {
        HttpSession session = SessionResolver.getSession();
        Student std = (Student)session.getAttribute("studobj");
        int type = std.getStu_type().getStudent_type_id();
        
        switch (type) {
            case 1:
                return "student_index";
            case 3:
                return "ec_index";
            default:
                return "representative_index";
        }
        
    }
    
    
}
