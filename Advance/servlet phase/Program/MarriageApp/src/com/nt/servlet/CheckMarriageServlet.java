package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckMarriageServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 String name=null,gender=null;
		 int age=0;
	   //get PrintWriter
		 pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 //res.addHeader("Content-Disposition","attachment;fileName=abc.txt");
		 //read form data (req parameter values)
		 name=req.getParameter("pname");
		 age=Integer.parseInt(req.getParameter("page"));
		 gender=req.getParameter("gender");
		 
		 //write request processing logic..
		 if(gender.equalsIgnoreCase("m")){
			 if(age>=21)
				 pw.println("<h1 style='color:cyan;text-align:center'>Mr."+name+" u r elgible to marry a girl,but think twice </h1>");
			 else
				 pw.println("<h1 style='color:orange;text-align:center'>Mr."+name+" u r not elgible to marry a girl, Enjoy life </h1>");
			 }
		 else {  //for Female Gender
			 if(age>=18)
				 pw.println("<h1 style='color:green;text-align:center'>Miss."+name+" u r elgible to marry a boy-->First settele life ,do not be depedent </h1>");
			 else
				 pw.println("<h1 style='color:blue;text-align:center'>Miss."+name+" u r not elgible to marry a boy --> Be happy </h1>");
		 }
		 
		
		//add hyperlink
	    pw.println("<a href='input.html'><img src='james.png'></a>");
	    //close stream 
	    pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}
}
