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
		ServletConfig cg=null;
		ServletContext sc=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//access ServletConfig object
		cg=getServletConfig();
		sc=getServletContext();
		//access SErvletContext obj
		pw.println("<br> dbuser context param value ::"+sc.getInitParameter("dbuser"));
		pw.println("<br> dbuser init param value ::"+cg.getInitParameter("dbuser"));
		pw.println("<br> Servletconfig obj class name::"+cg.getClass());
		pw.println("<br> Servletcontext obj class name::"+sc.getClass());
		pw.println("<br> logical name  of servlet::"+cg.getServletName());
		
		pw.println("<br><br> server info::"+sc.getServerInfo());
		pw.println("<br> Servlet api Version::"+sc.getMajorVersion()+" ."+sc.getMinorVersion());
		pw.println("<br> context path of web application::"+sc.getContextPath());
		pw.println("<br> Path of input.html ::"+sc.getRealPath("/input.html"));
		pw.println("<br> Path of web root folder ::"+sc.getRealPath("/"));
		pw.println("<br> MIME type of input.html ::"+sc.getMimeType("input.html"));
		//writing log message..
		sc.log("hell date is"+new Date());
		
		
		//close stream
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}

}
