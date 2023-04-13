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
 * Servlet implementation class deletestaff
 */
@WebServlet("/deletestaff")
public class deletestaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletestaff() {
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
		int status=parkdao.deletestaff(id);
		if(status>0)
		{
			 pw.print("<script> alert('data deleted successfully')</script>");
			 RequestDispatcher rd=request.getRequestDispatcher("viewstaffcontroller");
			    rd.forward(request, response);
		}
		else {
			 pw.print("<script> alert('something is wrong')</script>");
	    RequestDispatcher rd=request.getRequestDispatcher("viewstaffcontroller");
	    rd.include(request, response);
		}
	}
		
	}


