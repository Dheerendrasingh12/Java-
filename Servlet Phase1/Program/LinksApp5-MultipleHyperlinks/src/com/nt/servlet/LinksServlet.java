package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		ServletOutputStream sos=null;
		String paramVal=null;
		Locale locales[]=null;
		//get PrintWriter
		sos=res.getOutputStream();
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read the additional req parameter (s1) value..
		paramVal=req.getParameter("s1");
		//Differentiate logic for each hyperlink
		if(paramVal.equalsIgnoreCase("link1")){
			locales=Locale.getAvailableLocales();
			sos.println("<h1> All Countries </h1>");
			for(Locale locale:locales){
				sos.println(locale.getDisplayCountry()+",");
			}
		}
		else if(paramVal.equalsIgnoreCase("link2")){
			locales=Locale.getAvailableLocales();
			sos.println("<h1> All Languages </h1>");
			for(Locale locale:locales){
				sos.println(locale.getDisplayLanguage()+",");
			}
		}
		else{
			sos.println("<h1> System Date and Time ::</h1>"+new java.util.Date());
		}
		//add hyperlink
		sos.println("<br> <a href='links.html'>home</a>");
		//close stream
		sos.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  doGet(req,resp);
	}
	
	

}
