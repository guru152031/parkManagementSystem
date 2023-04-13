package com.contorller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.addempbo;
import com.bo.addstaff;
import com.dao.parkdao;

/**
 * Servlet implementation class updatestaff
 */
@WebServlet("/updatestaff")
public class updatestaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatestaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		
		
		
		 response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		 String s=request.getParameter("id");
		 int id=Integer.parseInt(s);
		 String name=request.getParameter("name");
		  
		 String phnno=request.getParameter("phnno");
		 String desg=request.getParameter("desg");
		 
		 String address=request.getParameter("address");
		 String doj=request.getParameter("doj");
		 String pkg=request.getParameter("pkg");
		 addstaff bo=new addstaff(id,name,  phnno, desg, address, doj, pkg);
		 int status=parkdao.updatestaff(bo);
		 if(status>0)
		 {
			 pw.print("<script> alert('datainserted')</script>");
			    RequestDispatcher rd=request.getRequestDispatcher("viewstaffcontroller");
			    rd.include(request, response);
		 }
		 else
		 {
			 pw.print("<script> alert('data not inserted')</script>");
			    RequestDispatcher rd=request.getRequestDispatcher("viewstaffcontroller");
			    rd.include(request, response);
		 }
	}
	}


