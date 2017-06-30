package com.demo.service;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.demo.model.User;

public class UserService {
	Connection con;
	
	public UserService(){
		try{
			con = ConnectionProvider.getCon();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int register(User user){
		int result= 0;
		try{
			PreparedStatement ps=con.prepareStatement("insert into User.User "
					+ "(firstname,lastname,usergroup,username,password) "
					+ "values (?,?,?,?,?)");
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getUsergroup());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPasswd());
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
		
	}
	
	public List<User> retriveAll(){
		ArrayList<User> list = new ArrayList<User>();
		try{
			PreparedStatement ps = con.prepareStatement("Select * from User.User");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				User user = new User(rs.getString("firstname"), rs.getString("lastname"), rs.getString("usergroup"), rs.getString("username"),rs.getString("password"));
				//System.out.println(user);
				list.add(user);
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;		
	}
	
	public int delete(int userID){
		int num = 0;
		try{
			PreparedStatement ps =con.prepareStatement("delete from User.User where userid=?");
			ps.setInt(1, userID);
			num = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return num;
	}
	
	public int editUser(User user, int id){
		int result = 0;
		try{
			PreparedStatement ps = con.prepareStatement("update User.User set firstname=?,"
				+ "lastname=?, usergroup=?, username=?, password=? where userid=? ");
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getUsergroup());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPasswd());
			ps.setInt(6, id);
			result = ps.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();}	
		return result;
		
	}
}
