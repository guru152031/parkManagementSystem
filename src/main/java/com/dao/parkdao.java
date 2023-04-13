package com.dao;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.bo.addempbo;
import com.bo.addstaff;
import com.bo.parkbo;
import com.bo.signupbo;

public class parkdao {
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
	
	
	public static int insert(parkbo bo)
	{
		int status=0;
		Connection con=parkdao.getsignup();
	try {
		PreparedStatement ps=con.prepareStatement("insert into park(name,email,phnno,password,confirmpassword) values(?,?,?,?,?)");
		
		
		
		
		ps.setString(1,bo.getName());
		ps.setString(2, bo.getEmail());
		ps.setString(3, bo.getPhnno());
		ps.setString(4,bo.getPassword());
		ps.setString(5, bo.getConfirmpassword());
		status=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
	System.out.println(e);
	}
		return status;
	}
	public static boolean loginValidate(String email,String password,String confirmpassword)
	{
		boolean status=false;
		Connection con=parkdao.getsignup();
		 String query="select * from park where email=? and password=? and confirmpassword=?";
		 try {
			PreparedStatement ps=con.prepareStatement(query);
			 ps.setString(1, email);
			 ps.setString(2, password);
			 ps.setString(3, confirmpassword);
			 
			 ResultSet rs=ps.executeQuery();
			 status=rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	public static int addemp(addempbo bo)
	{
		int status=0;
		try
		{
			
			Connection con=parkdao.getsignup();
			String sql="insert into addemployee(name, email, phnno, designation, address, doj, package)values(?,?,?,?,?,?,?)";
			
					 
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,bo.getName());
			ps.setString(2,bo.getEmail());
			ps.setString(3,bo.getPhnno());
			ps.setString(4,bo.getDesg());
			ps.setString(5,bo.getAddress());
			ps.setString(6, bo.getDoj());
			ps.setString(7,bo.getPkg());
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
		System.out.println(e);	
		}
		return status;
	}
	public static  List getemp()
	{
		List<addempbo>ll=new ArrayList<>();
		 
		try {
			Connection con=parkdao.getsignup();
			PreparedStatement ps=con.prepareStatement("select * from addemployee");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				addempbo eb=new addempbo();
				eb.setId(rs.getInt(1));
				eb.setName(rs.getString(2));
				eb.setEmail(rs.getString(3));
				eb.setPhone(rs.getString(4));
				eb.setDesg(rs.getString(5));
				eb.setAddress(rs.getString(6));
				eb.setDoj(rs.getString(7));
				eb.setPkg(rs.getString(8));
				ll.add(eb);
			}
		 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	return ll;
	}
	public static addempbo getempbyid(int id)
	{
		addempbo eb=new addempbo();
		try {
			Connection con=parkdao.getsignup();
			
			PreparedStatement ps= con.prepareStatement("select * from  addemployee where id=? ");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			 
			if(rs.next())
			{
				eb=new addempbo();
			
			 eb.setId(id);
			 eb.setName(rs.getString(2));
			 eb.setEmail(rs.getString(3));
			 eb.setPhone(rs.getString(4));
			 eb.setDesg(rs.getString(5));
			 eb.setAddress(rs.getString(6));
			 eb.setDoj(rs.getString(7));
			 eb.setPkg(rs.getString(8));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return eb;
	}
	public static int editemp(addempbo bo)
	{
		 int status=0;
		try{
			Connection con=parkdao.getsignup();
	PreparedStatement ps=con.prepareStatement("update addemployee set name=?, email=?,phnno=?,designation=?,address=?,doj=?,package=? where id=?");
			ps.setString(1,bo.getName());
			ps.setString(2,bo.getEmail());
			ps.setString(3,bo.getPhnno());
			ps.setString(4,bo.getDesg());
			ps.setString(5,bo.getAddress());
			ps.setString(6, bo.getDoj());
			ps.setString(7,bo.getPkg());
			ps.setInt(8, bo.getId());
			status=ps.executeUpdate();
			
			
		}
		catch(Exception e) {
		System.out.println(e);
		}
		return status;
	}
	public static int  delete(int id)
	{
		int status=0;
		try
		{
			Connection con=parkdao.getsignup();
			PreparedStatement ps=con.prepareStatement("delete from addemployee where id=?");
			ps.setInt(1, id);
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	public  static int addstaffdatails(addstaff  bo)
	{
		int status=0;
		try
		{
			
			Connection con=parkdao.getsignup();
	String sql="insert into addstaff(name,  phnno, designation, address, doj, package)values(?,?,?,?,?,?)";
			
					 
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,bo.getName());
			 
			ps.setString(2,bo.getPhnno());
			ps.setString(3,bo.getDesg());
			ps.setString(4,bo.getAddress());
			ps.setString(5, bo.getDoj());
			ps.setString(6,bo.getPkg());
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
		System.out.println(e);	
		}
		return status;
	}
	public static  List getstaff()
	{
		List<addstaff>ll=new ArrayList<>();
		 
		try {
			Connection con=parkdao.getsignup();
			PreparedStatement ps=con.prepareStatement("select * from addstaff");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				addstaff eb=new addstaff();
				eb.setId(rs.getInt(1));
				eb.setName(rs.getString(2));
				 
				eb.setPhnno(rs.getString(3));
				eb.setDesg(rs.getString(4));
				eb.setAddress(rs.getString(5));
				eb.setDoj(rs.getString(6));
				eb.setPkg(rs.getString(7 ));
				ll.add(eb);
			}
		 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	return ll;
	}
	public static addstaff getstaffbyid(int id)
	{
		addstaff eb=new addstaff();
		try {
			Connection con=parkdao.getsignup();
			
			PreparedStatement ps= con.prepareStatement("select * from  addstaff where id=? ");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			 
			if(rs.next())
			{
				eb=new addstaff();
			
			 eb.setId(id);
			 eb.setName(rs.getString(2));
		 
			 eb.setPhnno(rs.getString(3));
			 eb.setDesg(rs.getString(4));
			 eb.setAddress(rs.getString(5));
			 eb.setDoj(rs.getString(6));
			 eb.setPkg(rs.getString(7));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return eb;
	}
	public static int updatestaff(addstaff bo)
	{
		 int status=0;
		try{
			Connection con=parkdao.getsignup();
	PreparedStatement ps=con.prepareStatement("update addstaff set name=?, phnno=?,designation=?,address=?,doj=?,package=? where id=?");
			ps.setString(1,bo.getName());
			 
			ps.setString(2,bo.getPhnno());
			ps.setString(3,bo.getDesg());
			ps.setString(4,bo.getAddress());
			ps.setString(5, bo.getDoj());
			ps.setString(6,bo.getPkg());
			ps.setInt(7, bo.getId());
			status=ps.executeUpdate();
			
			
		}
		catch(Exception e) {
		System.out.println(e);
		}
		return status;
	}
	public static int  deletestaff(int id)
	{
		int status=0;
		try
		{
			Connection con=parkdao.getsignup();
			PreparedStatement ps=con.prepareStatement("delete from addstaff where id=?");
			ps.setInt(1, id);
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	}
				 