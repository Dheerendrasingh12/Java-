package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sumurl")
public class SumServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("SumServlet: doGet(-,-)");
		PrintWriter pw=null;
		int val1=0,val2=0;
		ServletContext sc=null;
		int sum=0;
		pw=res.getWriter();
		res.setContentType("text/html");
		
		val1=Integer.parseInt(req.getParameter("first"));
		val2=Integer.parseInt(req.getParameter("second"));
		
		sum=val1+val2;
		
		pw.println("<h1 style='color:red;text-align:center'>Result ::"+sum+"</h1>");
		pw.println("<a href=page.html>HOME PAGE</a>");
		sc=getServletContext();
		pw.println("<h6>"+sc.getAttribute("reqCount")+"</h6>");
		pw.close();
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
