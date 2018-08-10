package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		//general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //add hyperlink for sendRedirection
		 pw.println("<a href='https://google.co.in/search?q="+req.getParameter("tsearch")+"'>Go to Goole </a>");
		//close stream
		 pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}
}
