package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet({ "/s1url" })
public class Servlet1 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,ms=null,age=null;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		name=req.getParameter("name");
		age=req.getParameter("age");
		ms=req.getParameter("ms");
		
		if(ms==null)
			ms="single";
		
		pw.println("<h1 style='color:red;text-align:center'>Second Form page</h1>");
		if(ms.equalsIgnoreCase("married")) {
			pw.println("<form action='s2url' method='POST'>");
			pw.println("<br>Spouse Name::<input type='text' name='f2t1'><br>");
			pw.println("<br>No. of Children :: <input type='text' name='f2t2'><br>");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");

		}
		else {
			pw.println("<form action='s2url' method='POST'>");
			pw.println("<br> when do you want to marry:: <input type='text' name='f2t1'><br>");
			pw.println("<br> Why do want to marry :: <input type='text' name='f2t2'><br>");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");
		}
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
