package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 String name=null,addrs=null;
		 int age=0;
		 HttpSession ses=null;
		 
		//general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form1/req1 data
		 name=req.getParameter("name");
		 addrs=req.getParameter("addrs");
		 age=Integer.parseInt(req.getParameter("age"));
		 //create HttpSession object..
		 ses=req.getSession(true);
		 //place form1/req1  in Session object
		 ses.setAttribute("name",name);
		 ses.setAttribute("age",age);
		 ses.setAttribute("addrs",addrs);
		 //Generate form2 dynamically
		 pw.println("<body bgcolor='cyan'>");
		 pw.println("<h1 style='color:red'> Provide Experience and SkillSet </h1>");
		 pw.println("<form action='secondurl' method='post'>");
		 pw.println("Experience :: <input type='text' name='exp'><br>");
		 pw.println("SkillSet :: ");
		 pw.println("<select name='skill'>");
		 pw.println("<option value='java'>Java </option>");
		 pw.println("<option value='.net'>.Net </option>");
		 pw.println("<option value='php'> PHP</option>");
		 pw.println("</select> <br>");
		 pw.println("<input type='submit' value='continue'>");
		 pw.println("</form>");
		 pw.println("<br> Session Id::"+ses.getId());
		 pw.println("</body>");
		 //close stream
		 pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       doGet(req,res);
	}//doPost(-,-)
}//class
