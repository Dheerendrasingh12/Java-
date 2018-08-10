package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 String name=null,pass=null;
		  //general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form data
		 name=req.getParameter("uname");
		 pass=req.getParameter("pwd");
		 pw.println("<b> form data:::"+name+"...."+pass+"<br>");
		 //write b.logic
		 if(name.equalsIgnoreCase("raja@gmail.com") && pass.equalsIgnoreCase("rani")){
			 pw.println("<h1 style='color:red;text-align:center'> Valid Credentials </h1>");
		 }
		 else{
			 pw.println("<h1 style='color:red;text-align:center'>InValid Credentials </h1>");
		 }
		 //add hyperlink
		 pw.println("<a href='login.html'>home </a>");
		 //close stream
		 pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)

}//class
