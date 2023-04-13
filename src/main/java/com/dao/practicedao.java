package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class practicedao {
	
	
	
	
	
	
	public static Connection getconnection()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project"
					+ ")
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

}
