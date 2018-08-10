package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/furl")
public class FirstServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw =null;
		String pname=null,page=null,pms=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		pname =req.getParameter("tname");
		page=req.getParameter("tage");
		pms=req.getParameter("ms");
		
		if(pms.equals("single")) {
			pw.println("<h1 style='color:red;text-align:center'>Dheerendra Second page</h1>");
			pw.println("<form action='surl' method='POST'>");
			pw.println("why do u want to marry <input type='text' name='f2t1'><br>");
			pw.println("when do u marry <input type='text' name='f2t2'><br>");
			pw.println("<input type='hidden' name='hname' value='"+pname+"'>");
			pw.println("<input type='hidden' name='hage' value='"+page+"'>");
			pw.println("<input type='hidden' name='hms' value='"+pms+"'>");
			pw.println("<input type='submit' value='submit'>");	
			pw.println("</form>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'>Dheerendra Second page</h1>");
			pw.println("<form action='surl' method='POST'>");
			pw.println("spouse name <input type='text' name='f2t1'><br>");
			pw.println("No. of kids <input type='text' name='f2t2'><br>");
			pw.println("<input type='hidden' name='hname' value='"+pname+"'>");
			pw.println("<input type='hidden' name='hage' value='"+page+"'>");
			pw.println("<input type='hidden' name='hms' value='"+pms+"'>");
			pw.println("<input type='submit' value='submit'>");	
			pw.println("</form>");
		
		}
	
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
