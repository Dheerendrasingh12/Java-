package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/testurl")
public class TestServlet extends HttpServlet {
	
    
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		Enumeration <String> e;
		Map<String,String[]> map=null;
	   //general settings
		
		res.setContentType("text/html");
		//Reading and displaying all req param names and values
		pw.println("<h1> All request parameter names  are </h1>");
		e=req.getParameterNames();
		while(e.hasMoreElements()){
			String name=e.nextElement();
			String value=req.getParameter(name);
			pw.println("<br>"+name+"===> "+value);
		}
		
		//Reading and displaying all req param names and values
		pw.println("<br><h1> All request parameter names  are </h1>");
		map=req.getParameterMap();
		map.forEach( (name,values)->{
			pw.println("<br>req param name::"+name);
			pw.println("<br>req param values ::"+Arrays.toString(values));
		});
		
		//Reading and displaying all req header name and values
		pw.println("<br><h1> All request header names and values  are </h1>");
		e=req.getHeaderNames();
		while(e.hasMoreElements()){
			String name=e.nextElement();
			String value=req.getHeader(name);
			pw.println("<br> "+name+"....."+value);
		}
		//Gathering misc Info using req object
		//Using javax.servlet.ServletRequest(I)
		pw.println("<br> protocol::"+req.getProtocol());
		pw.println("<br> scheme::"+req.getScheme());
		pw.println("<br> Server::"+req.getServerName());
		pw.println("<br> Server Port::"+req.getServerPort());
		pw.println("<br> req  content length::"+req.getContentLength());
		pw.println("<br> req  content type::"+req.getContentType());
		pw.println("<br> req data Character encoding::"+req.getCharacterEncoding());
		pw.println("<br> Client machine ID addrs::"+req.getRemoteAddr());
		pw.println("<br> Client machine Host name::"+req.getRemoteHost());
		pw.println("<br> client(browser port no::"+req.getRemotePort());
		pw.println("<br>---------------------------------------------------------------");
		//Using javax.servlet.HttpServletRequest(I)
		pw.println("<br> query string::"+req.getQueryString());
		pw.println("<br> Context path name :: "+req.getContextPath());
		pw.println("<br> req mode::"+req.getMethod());
		pw.println("<br> req URI"+req.getRequestURI());
		pw.println("<br> req URL"+req.getRequestURL());
		pw.println("<br> req Serlvet path(url pattern)"+req.getServletPath());
		
		 pw.println("<br> date and time ::"+new java.util.Date());
		 //res.setHeader("refresh","10");
		 res.setIntHeader("refresh",10);
		 
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);
	}

}
