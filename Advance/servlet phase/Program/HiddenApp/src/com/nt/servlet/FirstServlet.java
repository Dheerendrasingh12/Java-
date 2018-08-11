package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,fname=null,ms=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("pname");
		fname=req.getParameter("fname");
		ms=req.getParameter("ms");
		//Generate form2 dyamically based on marital status and also place form1/req1 data as hidden Box values
		if(ms.equalsIgnoreCase("single")){
			pw.println("<h1 style='color:red;text-align:center'> Provide Bachelor Life Details </h1>");
			pw.println("<form action='secondurl' method='post'>");
			pw.println("When do u want to marry ::<input type='text' name='f2val1'><br>");
			pw.println("Why do u want to marry ::<input type='text' name='f2val2'><br>");
			  //add form1/req1 data in form2 as hidden box values
			pw.println("<input type='hidden' name='hname' value='"+name+"'><br>");
			pw.println("<input type='hidden' name='hfname' value='"+fname+"'><br>");
			pw.println("<input type='hidden' name='hms' value='"+ms+"'><br>");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");
		}//if
		else{
			pw.println("<h1 style='color:red;text-align:center'> Provide Married Life Details </h1>");
			pw.println("<form action='secondurl' method='post'>");
			pw.println("Spouse name ::<input type='text' name='f2val1'><br>");
			pw.println("No.of kids ::<input type='text' name='f2val2'><br>");
			  //add form1/req1 data in form2 as hidden box values
			pw.println("<input type='hidden' name='hname' value='"+name+"'><br>");
			pw.println("<input type='hidden' name='hfname' value='"+fname+"'><br>");
			pw.println("<input type='hidden' name='hms' value='"+ms+"'><br>");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");
		}
		
		//close stream 
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}

}//class
