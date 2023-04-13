package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bo.signupbo;

public class empdao {
	
	
	
	
	
	
	public static Connection getsignup() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		return con;
	}
	
	
	public static int insert(signupbo bo)
	{
		int story=0;
		Connection con=empdao.getsignup();
	try {
		PreparedStatement ps=con.prepareCall("insert into parksignup (name,email,pwd) values(?,?,?)");
		
		
		
		
		ps.setString(1,bo.getName());
		ps.setString(2, bo.getEmail());
		ps.setString(3,bo.getPwd());
		story=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
	System.out.println(e);
	}
		return story;
	}

}
