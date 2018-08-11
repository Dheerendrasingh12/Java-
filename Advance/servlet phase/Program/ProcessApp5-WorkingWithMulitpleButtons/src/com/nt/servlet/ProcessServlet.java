package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet{
	
	
	@Override
	public void init(ServletConfig cg) throws ServletException {
	    super.init(cg);
		System.out.println("init() method...");
		System.out.println("db user init param value::"+cg.getInitParameter("dbuser"));
		
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ProcessServlet::doGet(-,-)");
		 //PrintWriter pw=null;
		ServletOutputStream sos=null;
		 String pvalue=null;
		 int val1=0,val2=0;
		  //general settings
		 //pw=res.getWriter();
		 sos=res.getOutputStream();
		 res.setContentType("text/html");
		 //read "s1" additional req param value
		 pvalue=req.getParameter("s1");
		 //read form only when hyperlinks not clicked
		 if((!pvalue.equalsIgnoreCase("link1")) && (!pvalue.equalsIgnoreCase("link2"))){
			 val1=Integer.parseInt(req.getParameter("t1"));
			 val2=Integer.parseInt(req.getParameter("t2"));
		 }
		 //process the request
		  
		 if(pvalue.equalsIgnoreCase("add")){
			 sos.println("<h1>Add::"+(val1+val2)+"</h1>");
		 }
		 else if(pvalue.equalsIgnoreCase("sub")){
			 sos.println("<h1>Sub::"+(val1-val2)+"</h1>");
		 }
		 else if(pvalue.equalsIgnoreCase("mul")){
			 sos.println("<h1>Mul::"+(val1*val2)+"</h1>");
		 }
		 else if(pvalue.equalsIgnoreCase("link1")){
			 sos.println("<h1> System Date and Time::"+new java.util.Date()+"</h1>");
		 }
		 else{
			 sos.println("<h1> System Properties::"+System.getProperties()+"</h1>");
		 }
		sos.println("<br><a href='input.html'>home</a>");
		
		ServletConfig cg=getServletConfig();
		System.out.println("from service(-,-)db user init param value::"+cg.getInitParameter("dbuser"));
		
		
	}//doGet(-,-)
/*	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ProcessServlet:: doPost(-,-)");
		  doGet(req,res);
	}*/

}//class
