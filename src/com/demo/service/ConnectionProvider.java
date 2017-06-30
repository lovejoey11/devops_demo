package com.demo.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;



public class ConnectionProvider{
	private static Connection con = null;
	private static String Connection_URL = null;
	private static String Username = null;
	private static String Password = null;
	private static InputStream input = null;
	
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			getCredentials();
			con = DriverManager.getConnection(Connection_URL,Username,Password);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getCon(){
		return con;
	}
	
	private static void getCredentials() {
		try {
			Properties prop = new Properties();
			String filename="config.properties";
			input = ConnectionProvider.class.getClassLoader().getResourceAsStream(filename);
    		if(input==null){
    	            System.out.println("Sorry, unable to find " + filename);
    		    return;
    		}
    		prop.load(input);
			Connection_URL = prop.getProperty("DB_URL");
			Username = prop.getProperty("Username");
			Password = prop.getProperty("Passwd");
			
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
