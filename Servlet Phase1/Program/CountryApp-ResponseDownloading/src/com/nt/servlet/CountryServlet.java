package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet {
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 String capitals[]=null;
		 PrintWriter pw=null;
		 int countryCode=0;
		//general settings
		 capitals=new String[]{"delhi","islamabad","bejing","colombo"};
		 pw=res.getWriter();
/*		 res.setContentType("application/vnd.ms-excel");
		 res.addHeader("content-disposition","attachment;fileName=output.xls");
		 
*/
		 res.setContentType("text/html");
		 res.addHeader("content-disposition","attachment;fileName=output.html");

		 //read form data
		 countryCode=Integer.parseInt(req.getParameter("country"));
        //display capital
		  pw.println("<h1 style='color:red;text-align:center'>Capital name::"+capitals[countryCode]+"</h1>");
		  
		  //add hyperlink
		  pw.println("<a href='input.html'>home</a>");
		  //close stream
		  pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
}//class
