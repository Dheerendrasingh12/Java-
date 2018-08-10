package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchEngineServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  PrintWriter pw=null;
		  String ss=null;
		  String engine=null;
		  String url=null;
		  //general setfings  
		  pw=res.getWriter();
		  res.setContentType("text/html");
		  pw.println("<b>hello</b>");
		  //read formd data
		  ss=req.getParameter("ss");
		  //prepare url 
		  engine=req.getParameter("engine");
		  //prepare urls form send Redirection
		  if(engine.equalsIgnoreCase("google"))
			  url="https://www.google.co.in/search?q="+ss;
		  else if(engine.equalsIgnoreCase("yahoo"))
			  url="https://in.search.yahoo.com/search?p="+ss;
		  else
			  url="http://www.bing.com/search?q="+ss;
		  //perform sendRedirect
		  System.out.println("Before res.sendRedirect(-) method");
		  res.sendRedirect(url);
		  //res.sendRedirect("my_page.html");
		  RequestDispatcher rd=req.getRequestDispatcher("/my_page.html");
		  rd.include(req,res);
		  System.out.println("After res.sendRedirect(-) method");
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
	
}
