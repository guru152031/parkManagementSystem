package com.contorller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.addempbo;
import com.dao.parkdao;

/**
 * Servlet implementation class editcontroller
 */
@WebServlet("/editcontroller")
public class editcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editcontroller() {
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
		pw.print("<link rel=\"stylesheet\" href=\"css/updateemp.css\">");
	 String s=request.getParameter("id");
	 int id=Integer.parseInt(s);
	 addempbo eb=parkdao.getempbyid(id);
	 pw.print("<center>");
	 pw.print("<form  action='updateservlet' method='get'> ");
	    
		pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
	   	pw.print("<tr><td>Email: </td> <td><input type='text' name='email' value='"+eb.getEmail()+"'/></td></tr>");
	   	pw.print("<tr><td>Phone:</td> <td><input type='text' name='phnno' value='"+eb.getPhnno()+"'/></td></tr>");
	   	pw.print("<tr><td>Designation : </td> <td><input type='text' name='desg' value='"+eb.getDesg()+"'/></td></tr>");
	   	pw.print("<tr><td>Address: </td> <td><input type='text' name='address' value='"+eb.getAddress()+"'/></td></tr>");
	   	pw.print("<tr><td>Date of Joining: </td> <td><input type='date' name='doj' value='"+eb.getDoj()+"'/></td></tr>");
	   	pw.print("<tr><td>Package </td> <td><input type='text' name='pkg' value='"+eb.getPkg()+"'/></td></tr>");
	    pw.print("<tr ><td ><input type='submit'  value='Update'/></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
		 pw.print("<center>");
	}

}
