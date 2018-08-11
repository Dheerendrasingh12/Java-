package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		String name=null;
		String tage=null;
		int age=0;
		pw=res.getWriter();
		res.setContentType("text/html");
		
		name=req.getParameter("name");
		tage=req.getParameter("age");
		age=Integer.parseInt(tage);
		
		if(age>=18)
			pw.println("<h1 style='color:red'>"+name+" you are Eligible for Vote</h1>");
		else
			pw.print("<h1 style='color:red'>"+name+" you are Eligible for Vote</h1>");
		
		pw.println("<a href='input.html'>Home</a>");
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doGet(req, res);
	}

}
