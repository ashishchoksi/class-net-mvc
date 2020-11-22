package com.classnet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    private Connection con = null;
    private static DBConnection instance = null;
    static final String db_url = "jdbc:mysql://localhost/classnet";
    static final String user = "root";
    static final String pass = "";
    
    private DBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(db_url, user, pass);
    }
    
    public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        if(instance == null)
            instance = new DBConnection();
        return instance;
    }
    
    public Connection getConnection() throws SQLException{ 
        return con;
    }
    
    public void close() throws SQLException {
        instance=null;
        con.close();
    }
    
    @Override
    protected void finalize() throws Throwable{
        con.close();
    }
    
}
