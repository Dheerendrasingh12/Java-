package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchEngineServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 String ss=null,engine=null;
		 String url=null;
		 PrintWriter pw=null;
		 //general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		//read form data
		 ss=req.getParameter("ss");
		 engine=req.getParameter("engine");
		 //prepare url with query string for send Redirection
		 if(engine.equalsIgnoreCase("google"))
			 url="https://www.google.co.in/search?q="+ss;
		 else if(engine.equalsIgnoreCase("bing"))
			url="http://www.bing.com/search?q="+ss;
		 else 
			 url="https://in.search.yahoo.com/search?p="+ss;
		 //perform sendRedirection
		 System.out.println("before res.sendRedirct(-)");
		 pw.println("<b> before res.sendRedirect(-)");
		 //res.sendRedirect("/home.html");
		 RequestDispatcher rd=req.getRequestDispatcher("/home.html");
		 rd.include(req,res);
	
		 res.sendRedirect(url);
			 System.out.println("after res.sendRedirct(-)");
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)

}//class
