package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 String paramVal=null;
		 int val1=0,val2=0;
		//Get PrintWriter
		 pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 //read the additional "s1" req param value
		 paramVal=req.getParameter("s1");
		 
		 //read form data when submitt buttons are clicked..
		 if(paramVal.equalsIgnoreCase("add") ||paramVal.equalsIgnoreCase("sub") || paramVal.equalsIgnoreCase("mul") ){
			 val1=Integer.parseInt(req.getParameter("t1"));
			 val2=Integer.parseInt(req.getParameter("t2"));
		 }
		 //Differentiate the logics for buttons and hyperlinks..
		 if(paramVal.equalsIgnoreCase("add")){
			 pw.println("<h1> Sum ::"+(val1+val2)+"</h1>");
		 }
		 else if(paramVal.equalsIgnoreCase("sub")){
			 pw.println("<h1> Sub ::"+(val1-val2)+"</h1>");
		 }
		 else if(paramVal.equalsIgnoreCase("mul")){
			 pw.println("<h1> Mul ::"+(val1*val2)+"</h1>");
		 }
		 else if(paramVal.equalsIgnoreCase("link1")){
			 pw.println("<h1> System Properites ::</h1>"+System.getProperties());
		 }
		 else{
			 pw.println("<h1> System Date ::"+new Date()+"</h1>");
		 }
		 //add hyperlink
		 pw.println("<a href='input.html'>home</a>");		 
		 //close stream
		 pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}
}//class
