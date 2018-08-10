package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,fname=null;
		Cookie ck1=null, ck2=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form1/req1 data
		name=req.getParameter("pname");
		fname=req.getParameter("fname");
		//add form1/req1 data  to cookies (InMemory cookies
		ck1=new Cookie("cname",name);
		ck2=new Cookie("fname",fname);
		//add cookies to response
		res.addCookie(ck1); res.addCookie(ck2);
		//Generate Form2 dynamically from here....
		pw.println("<h1 style='color:red;text-align:center'>Provide Income and Tax Details </h1>");
		pw.println("<form action='secondurl'  method='POST'>");
		pw.println(" Income of this year:: <input type='text' name='income'><br> ");
		pw.println(" Tax of this year:: <input type='text' name='tax'><br> ");
		pw.println("<input type='submit'  value='submit'>");
		pw.println("</form>");
		
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}
}
