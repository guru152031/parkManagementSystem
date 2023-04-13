package com.contorller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.parkbo;
import com.bo.signupbo;
import com.dao.empdao;
import com.dao.parkdao;

/**
 * Servlet implementation class parksignup
 */
@WebServlet("/parksignup")
public class parksignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public parksignup() {
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
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phnno=request.getParameter("phnno");
		String password=request.getParameter("password");
		String confirmpassword=request.getParameter("confirmpassword");
		
		
		
parkbo bo=new parkbo(name,email,phnno,password,confirmpassword);
		
		
		
		int status=parkdao.insert(bo);
		if(status>0==true)
		{
	 
	 pw.print("<script> alert('data inserted')</script>");
	  
	    RequestDispatcher rd=request.getRequestDispatcher("parklogin.html");
	    rd.forward(request, response);
	    
		}
		else
		{
			 
			pw.print("<script> alert('data not inserted properly')</script>");
		    RequestDispatcher rd=request.getRequestDispatcher("paksignup.html");
		    rd.include(request, response);
		}
	}

}
