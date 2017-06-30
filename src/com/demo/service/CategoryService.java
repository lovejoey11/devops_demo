package com.demo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Category;


public class CategoryService {
	Connection con;
	
	public CategoryService(){
		try{
			con = ConnectionProvider.getCon();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<Category> retriveAll(){
		ArrayList<Category> list = new ArrayList<Category>();
		try{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Store.Category");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Category cate = new Category(rs.getString("NameCategory"), 
						rs.getString("DescCategory"));
				//System.out.println(user);
				list.add(cate);
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;		
	}
}
