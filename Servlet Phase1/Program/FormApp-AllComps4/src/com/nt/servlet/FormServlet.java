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
		String name=null,addrs=null,ms=null,qlfy=null,gender=null;
		String[] hobies=null,courses=null;
		int age=0;
		//get PrintWriter 
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("name");
		addrs=req.getParameter("addrs");
		age=Integer.parseInt(req.getParameter("age"));
		ms=req.getParameter("ms");
		if(ms==null)
			ms="single";
		gender=req.getParameter("gender");
		qlfy=req.getParameter("qlfy");
		courses=req.getParameterValues("crs");
		if(courses==null){
			courses=new String[]{"not intrested in courses"};
		}
		hobies=req.getParameterValues("hb");
		if(hobies==null){
			hobies=new String[]{"No hobies--> I am robot"};
		}
		//write request processing logic..
		if(gender.equalsIgnoreCase("M")){
			if(age<=5)
				pw.println("Master::"+name+"  u r  baby boy");
			else if(age<=12)
				pw.println("Master::"+name+"  u r  small boy");
			else if(age<=19)
				pw.println("Mr::"+name+"  u  r  teenage  boy");
			else if(age<=35)
				pw.println("Mr::"+name+"  u  r  young man");
			else if(age<=50)
				pw.println("Mr::"+name+"  u  r  Middle-aged man");
			else 
				pw.println("Mr::"+name+"  u  r  Budda man");
		}//if
		else{
			if(age<=5)
				pw.println("Master::"+name+"  u r  baby girl");
			else if(age<=12)
				pw.println("Master::"+name+"  u r  small girl");
			else if(age<=19){
				 if(ms.equalsIgnoreCase("married"))
				    pw.println("Mrs::"+name+"  u  r  teenage girl");
				 else
					 pw.println("Miss::"+name+"  u  r  teenage girl");
			}
			else if(age<=35){
				 if(ms.equalsIgnoreCase("married"))
					    pw.println("Mrs::"+name+"  u  r  young woman");
					 else
						 pw.println("Miss::"+name+"  u r young woman");
			}
			else if(age<=50){
				 if(ms.equalsIgnoreCase("married"))
					    pw.println("Mrs::"+name+"  u  r  middle-aged woman");
					 else
						 pw.println("Miss::"+name+"  u r young woman");
			}
			else {
				 if(ms.equalsIgnoreCase("married"))
					    pw.println("Mrs::"+name+"  u  r old woman");
					 else
						 pw.println("Miss::"+name+"  u r old woman");
			}
		}//else
		//display form data...
		pw.println("<h1 style='text-align:center'>Form data is </h1>");
		pw.println(" name :::  "+name+"<br>");
		pw.println(" age :::  "+age+"<br>");
		pw.println(" addrs :::  "+addrs+"<br>");
		pw.println(" gender :::  "+gender+"<br>");
		pw.println(" marital status:::  "+ms+"<br>");
		pw.println(" Qualification:::  "+qlfy+"<br>");
		pw.println(" Courses:::  "+Arrays.toString(courses)+"<br>");
		pw.println(" Hobies:::  "+Arrays.toString(hobies)+"<br>");
		//add hyperlink
		pw.println("<br> <a href='form.html'>home</a>");
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);
	}

}
