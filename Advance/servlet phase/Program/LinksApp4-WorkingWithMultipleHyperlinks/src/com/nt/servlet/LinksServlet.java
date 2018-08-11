package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       PrintWriter pw=null;
       String pval=null;
       Locale locales[]=null;
		//general settings
       pw=res.getWriter();
       res.setContentType("text/html");
       //read the addtional p1 req param value
       pval=req.getParameter("p1");
       //get all Locales
       locales=Locale.getAvailableLocales();
       //write logic for hyperlinks
       if(pval.equalsIgnoreCase("link1")){
    	   pw.println("<h1> All countries are </h1>");
    	 /*  for(Locale lc:locales){
    		   pw.println("<br>"+lc.getDisplayCountry());
    	   }*/
    	   
          }
       else if(pval.equalsIgnoreCase("link2")){
     	   pw.println("<h1> All Languages are </h1>");
    	   for(Locale lc:locales){
    		   pw.println("<br>"+lc.getDisplayLanguage());
    	   }
       }
       else{
     	   pw.println("<h1> Date and Time:: </h1>"+new  Date());
       }
       
       //add hyperlink
       pw.println("<br><a href='links.html'><img src='giphy.gif' width='300' height='300'></a>");
       //close stream 
       pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}//doPost(-,-)
}//class
