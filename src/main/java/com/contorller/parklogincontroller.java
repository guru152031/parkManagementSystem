package com.contorller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.parkdao;

/**
 * Servlet implementation class parklogincontroller
 */
@WebServlet("/parklogincontroller")
public class parklogincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public parklogincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	      response.setContentType("text/html");
	      PrintWriter pw=response.getWriter();
	      
	    String email=request.getParameter("email");
	    String password=request.getParameter("password");  
	    String confirmpassword=request.getParameter("confirmpassword");  
	   
	    boolean status=false;
	    
	   status=parkdao.loginValidate(email, password,confirmpassword);
	   
	   if(status) {
		     
		    RequestDispatcher rd=request.getRequestDispatcher("about.html");
		    rd.forward(request, response);
	   }else {
		    pw.print("<script> alert('username or password invalid!!')</script>");
		    RequestDispatcher rd=request.getRequestDispatcher("parklogin.html");
		    rd.include(request, response);
	   }
	    
	   
	
}

	}


