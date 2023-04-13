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
import com.dao.parkdao;

/**
 * Servlet implementation class addempcontroller
 */
@WebServlet("/addempcontroller")
public class addempcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addempcontroller() {
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
		 String desg=request.getParameter("desg");
		 
		 String address=request.getParameter("address");
		 String doj=request.getParameter("doj");
		 String pkg=request.getParameter("pkg");
		 addempbo bo=new addempbo(name, email, phnno, desg, address, doj, pkg);
		 int status=parkdao.addemp(bo);
		 if(status>0)
		 {
			 pw.print("<script> alert('employee datails added successfully ')</script>");
			 RequestDispatcher rd=request.getRequestDispatcher("about.html");
			    rd.include(request, response);
		 }
		 
		 else
		 {
			 pw.print("<script> alert('something went wrong')</script>");
			 RequestDispatcher rd=request.getRequestDispatcher("about.html");
			    rd.include(request, response);
		 }
		 
		   
		 
		 
	}

}
