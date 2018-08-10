package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ErrorServlet:doGet(-,-)");
		 PrintWriter pw=null;
		//general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //Write Error message
		 pw.println("form data"+req.getParameter("eno"));
		 pw.println("<br><h1 style='color:red;text-align:center'> Internal Problem </h1>");
		 pw.println("<br> <a href='input.html'>Try Again </a>");
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   doGet(req,res);
	}//doPost(-,-)
}//class
