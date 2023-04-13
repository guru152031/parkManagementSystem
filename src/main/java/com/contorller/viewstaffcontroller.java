package com.contorller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.addempbo;
import com.bo.addstaff;
import com.dao.parkdao;

/**
 * Servlet implementation class viewstaffcontroller
 */
@WebServlet("/viewstaffcontroller")
public class viewstaffcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewstaffcontroller() {
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
		pw.print("<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>");
		List<addstaff>ll=parkdao.getstaff();
		pw.print("    <ul>\r\n"
				+ "        <img src=\"park2.jpg\" alt=\"jurrasicparklogo\" width=\"100px\" height=\"100px\"><br>\r\n"
				+ "        \r\n"
				+ "        <li><a href=\"parklogin.html\"><button>Logout</button></a></li>\r\n"
				+ "        \r\n"
				+ "        <li> <a href=\"addemployee.html\"><button>Add officer Details</button> </a> </li>\r\n"
				+ "        \r\n"
				+ "        \r\n"
				+ "        <li><a href=\"parkstaff.html\"><button>Add staff Details</button></a></li>\r\n"
				+ "         \r\n"
				+ "        \r\n"
				+ "        <li><a href=\"viewstaffcontroller\" method=\"get\"> <button>View staff Details</button></a></li>\r\n"
				+ "        \r\n"
				+ "       <li><a href=\"viewemployee\" method=\"get\"> <button>View officer Details</button></a></li>\r\n"
				+ "        \r\n"
				+ "        \r\n"
				+ "         \r\n"
				+ "         \r\n"
				+ "           \r\n"
				+ "    </ul>");
		pw.print("<link rel=\"stylesheet\" href=\"css/table.css\">");
	 
		pw.print("<table border='1px solid black'; width ='100%' >");
		pw.print("<tr><th>id</th> <th>name</th>   <th>phnno</th> <th>designation</th> "
				+ "<th>address</th> <th>doj</th><th>package</th><th> edit  </th> <th>delete</th></tr>");
		for(addstaff eb:ll)
		{
			
		 pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getName()+""
			  		 
			  		+ "</td><td>"+eb.getPhnno()+"</td><td>"+eb.getDesg()+"</td><td>"+eb.getAddress()+""
			  		+ "</td><td>"+eb.getDoj()+"</td><td>"+eb.getPkg()+
			  		
			  		
"</td><td> "+"<a href='editstaff?id="+eb.getId()+" '> <i style='font-size:24px' class='fas'>&#xf044;</i></a> </td><td>"+"<a href='deletestaff?id="+eb.getId()+"'><i class='far fa-trash-alt' style='font-size:20px;color:red'></i></a></td>");
		
	 
	
	 
		}
		pw.print("</table>");
	 
}
}