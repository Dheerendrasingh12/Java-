package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,addrs=null;
		int age=0;
		HttpSession ses=null;
		
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
	   name=req.getParameter("name");
	   addrs=req.getParameter("addrs");
	   age=Integer.parseInt(req.getParameter("age"));
	   //create/Locate HttpSession object
	   ses=req.getSession();
	   //place form1/req1 data in HttpSession obj as session attribute values
	   ses.setAttribute("name",name);
	   ses.setAttribute("age", age);
	   ses.setAttribute("addrs",addrs);
	   //set idletimeout period
	   //ses.setMaxInactiveInterval(60);
	   //Generate form2 dynamically from here..
	   pw.println("<h1 style='color:red;text-align:center'> Enter Skill and Experience </h1>");
	   pw.println("<form action="+res.encodeURL("secondurl")+" method='POST'>");
	    pw.println("SkillSet :: <select name='skill' >");
	    pw.println(" <option value='java'>Java PKG</option>");
	    pw.println(" <option value='.net'>.NET PKG</option>");
	    pw.println(" <option value='php'>PHP PKG</option>");
	    pw.println(" <option value='ui'>UI PKG</option>");
	   pw.println("</select><br>");
	   pw.println("Experience :: <input type='text' name='exp'> <br>");
	   pw.println("<input type='submit' value='continue'>");
	   pw.println("</form>");
	   pw.println("<br> sesssion id ::"+ses.getId());
		//close stream
	   pw.close();
	  	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}//doPost(-,-)
}//class
