package com.demo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Product;

public class ProductService {
	Connection con;
	
	public ProductService(){
		try{
			con = ConnectionProvider.getCon();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<Product> retriveAll(){
		ArrayList<Product> list = new ArrayList<Product>();
		try{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Store.Product");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Product prod = new Product(rs.getString("nameProduct"), 
						rs.getString("descProduct"), rs.getDouble("pPrice"));
				list.add(prod);
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;		
	}
}
