package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/s2url")
public class ServletSecond extends HttpServlet {

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ServletContext sc=null;
		PrintWriter pw=null;
		HttpSession ses=null;
		RequestDispatcher rd=null;
		
		pw=res.getWriter();
		
		res.setContentType("text/html");
		
		pw.println("<br> Servlet2: attr1 attribute value "+req.getAttribute("attr1"));
		
		ses=req.getSession();
		pw.println("<br> Servlet2: attr2 attribute value "+ses.getAttribute("attr2"));
		
		sc=getServletContext();
		
		pw.println("<br> Servlet2: attr3 attribute value "+sc.getAttribute("attr3"));
		
		
		rd=req.getRequestDispatcher("/s3url");
		rd.forward(req, res);
		
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	doGet(req, res);
	}
}
