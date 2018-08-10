package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s2url")
public class Servlet2 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw= null;
		String name=null,age=null,ms=null;
		String f2val1=null,f2val2=null;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		
		name=req.getParameter("name");
		age=req.getParameter("age");
		ms=req.getParameter("ms");
		f2val1=req.getParameter("f2t1");
		f2val2=req.getParameter("f2t2");
		
		pw.println("<br> form1/req1 data :"+name+"-----"+age+"------"+ms);
		pw.println("<br> form2/req2 data :"+f2val1+"-----"+f2val2);
		
		
		pw.println("<a href ='details.html'>Home</a>");
		pw.close();

		
		
	
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
