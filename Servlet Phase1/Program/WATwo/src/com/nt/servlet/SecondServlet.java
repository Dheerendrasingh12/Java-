package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 int val=0;
		 int cube=0;
		 //general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form data (becoz Source and Dest comps use same request,response objects)
		 val=Integer.parseInt(req.getParameter("t1"));
		 //calculate cube value
		 cube=val*val*val;
		 //display the cube value
		 pw.println("<h1 style='color:red'>SEcondServlet::Cube Value :::"+cube+"</h1>");
		 pw.println("<br> <a href='input.html'>home</a>");
		 
	}//doGet(-,-)
@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 doGet(req,res);
	}	
	
}//class
