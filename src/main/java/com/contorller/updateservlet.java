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
 * Servlet implementation class updateservlet
 */
@WebServlet("/updateservlet")
public class updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		 String s=request.getParameter("id");
		 int id=Integer.parseInt(s);
		 String name=request.getParameter("name");
		 String email=request.getParameter("email");
		 String phnno=request.getParameter("phnno");
		 String desg=request.getParameter("desg");
		 
		 String address=request.getParameter("address");
		 String doj=request.getParameter("doj");
		 String pkg=request.getParameter("pkg");
		 addempbo bo=new addempbo(id,name, email, phnno, desg, address, doj, pkg);
		 int status=parkdao.editemp(bo);
		 if(status>0)
		 {
			 pw.print("<script> alert('datainserted')</script>");
			    RequestDispatcher rd=request.getRequestDispatcher("viewemployee");
			    rd.include(request, response);
		 }
		 else
		 {
			 pw.print("<script> alert('data not inserted')</script>");
			    RequestDispatcher rd=request.getRequestDispatcher("viewemployee");
			    rd.include(request, response);
		 }
	}

}
