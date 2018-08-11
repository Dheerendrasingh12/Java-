package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		ServletContext sc=null;
		ServletConfig cg=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//get ServletConfig obj
		sc=getServletContext();
		pw.println("<b>user context  param value:::"+sc.getInitParameter("user"));
		pw.println("<br>ServletContext obj class name:::"+sc.getClass());
		cg=getServletConfig();
		pw.println("<br> user init param vlaue::"+cg.getInitParameter("user")+"</b>");
		
		pw.println("<br>............................................................................");
		pw.println("<br> Server info :::"+sc.getServerInfo());
		pw.println("<br> Servlet api version :::"+sc.getMajorVersion()+"."+sc.getMinorVersion());
		pw.println("<br> Context path:::"+sc.getContextPath());
		pw.println("<br> MIME type of input.html::"+sc.getMimeType("input.html"));
		pw.println("<br> Absolute path of input.html"+sc.getRealPath("input.html"));
		pw.println("<br> Absolute path of Web Root folder"+sc.getRealPath("/"));
		//write message file
		sc.log("Sys date::"+new Date());
		
		
		
		//close stream
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   doGet(req,res);
	}
}//class
