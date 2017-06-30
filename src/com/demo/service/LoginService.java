package com.demo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class LoginService {
	
	Connection con;
	
	public LoginService(){
		try{
			con = ConnectionProvider.getCon();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public boolean login(String uname, String pword)
	{
		try{
			PreparedStatement ps = con.prepareStatement("Select * from User.User where username=? and password=?");
			ps.setString(1, uname);
			ps.setString(2, pword);
			ResultSet rs = ps.executeQuery();
		
		if(!rs.next())
		{
			return false;
		}else{
			return true;
		}
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
		
	}
	
}
