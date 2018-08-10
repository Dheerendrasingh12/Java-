package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1")
public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		Cookie ck1=null,ck2=null,ck3=null,ck4=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//create cookies
		ck1=new Cookie("TS","HYD");
		ck1.setComment("TS capital");
		
		ck2=new Cookie("AP","Amaravathi");
		ck2.setComment("AP capital");
		
		ck3=new Cookie("OD","BBSR");
		ck3.setComment("Odisha capital");
		
		ck4=new Cookie("MH","Mumbai");
		ck4.setComment("capital of MH");
		//Add cookies to repsonse
		res.addCookie(ck1); res.addCookie(ck2); //InMemory Cookies
		
		ck3.setMaxAge(120); ck4.setMaxAge(120);  
		res.addCookie(ck3); res.addCookie(ck4); //Persistnece cookies
		
		//display message
		pw.println("<h1> Cookies are added Successfully to browser </h1>");
		System.out.println("Cookies are added Successfully to browser");
   //close stream
		pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
           doGet(req,res);
	}//doPost(-,-)
}//class
