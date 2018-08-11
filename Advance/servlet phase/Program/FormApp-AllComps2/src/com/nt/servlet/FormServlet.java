package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   PrintWriter pw=null;
		   String name=null,ms=null,gender=null,addrs=null,qlfy=null;
		   String  hobies[]=null;
		String courses[]=null;
		   int age=0;
       //general settings		   
		   pw=res.getWriter();
		   res.setContentType("text/html");
		   //read form data
		   name=req.getParameter("name");
		   age=Integer.parseInt(req.getParameter("age"));
		   addrs=req.getParameter("addrs");
		   gender=req.getParameter("gender");
		   qlfy=req.getParameter("qlfy");
		   ms=req.getParameter("ms");
		   if(ms==null)
			   ms="single";
		   courses=req.getParameterValues("courses");
		   if(courses==null){
			   courses=new String[1];
			   courses[0]="Not joined in courses";
		   }
		   hobies=req.getParameterValues("hb");
		   if(hobies==null){
			   hobies=new String[1];
			   hobies[0]="stoick person";
		   }

		   //write b.logic (request processing logic)
		   if(gender.equalsIgnoreCase("M")){
			   if(age<=5)
				   pw.println("Master."+name+" u  r baby boy");
			   else if(age<=12)
				   pw.println("Master."+name+" u  r small boy");
			   else if(age<=19)
				   pw.println("Mr."+name+" u  r teenage boy");
			   else if(age<=35)
				   pw.println("Mr."+name+" u  r young man");
			   else if(age<=50)
				   pw.println("Mr."+name+" u  r middle-aged man");
			   else 
				   pw.println("Mr."+name+" u  r budda ");
		   }
		   else {
			   if(age<=5)
				   pw.println("Master."+name+" u r baby girl");
			   else if(age<=12)
				   pw.println("Master."+name+" u r small girl");
			   else if(age<=19){
				     if(ms.equals("married"))
				         pw.println("Mrs."+name+" u r  teenage girl");
				     else
				    	 pw.println("Miss."+name+" u r  teenage girl");
			   }
			   else if(age<=37){
				    if(ms.equals("married"))
				         pw.println("Mrs."+name+" u r  young woman");
				     else
				    	 pw.println("Miss."+name+" u r young woman");
			   }
			   else if(age<=50){
				   if(ms.equals("married"))
				         pw.println("Mrs."+name+" u r  middle-aged woman");
				     else
				    	 pw.println("Miss."+name+" u r middle-aged woman");
			   }
			   else{
				   if(ms.equals("married"))
				         pw.println("Mrs."+name+" u r  old woman");
				     else
				    	 pw.println("Miss."+name+" u r old woman"); 
			   }
				   
		   }//else
		   
		   pw.println("<br><h1> All Form comps data <br></h1>");
		   pw.println("<br> name::"+name);
		   pw.println("<br> age::"+age);
		   pw.println("<br> Gender::"+gender);
		   pw.println("<br> Address::"+addrs);
		   pw.println("<br> Marital Status::"+ms);
		   pw.println("<br> Qualification::"+qlfy);
		   pw.println("<br> Courses::"+Arrays.toString(courses));
		   pw.println("<br> Hobies::"+Arrays.toString(hobies));
		   //add hyperlink
		   pw.println("<br><a href='input.html'>home</a>");
		   //close stream
		   pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)

}//class
