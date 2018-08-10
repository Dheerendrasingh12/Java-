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
@WebServlet("/s3url")
public class ServletThird extends HttpServlet {

	combopoole
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
		HttpSession ses=null;
		RequestDispatcher rd=null;
		ServletContext sc=null;
		PrintWriter pw=null;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		
		pw.println("<br> Servle3: attr1 attribute value "+req.getAttribute("attr1"));
		ses=req.getSession();
		pw.println("<br> Servlet3: attr2 attribute value "+ses.getAttribute("attr2"));
		
		
		sc=getServletContext();
		
		pw.println("<br> Servlet2: attr3 attribute value "+sc.getAttribute("attr3"));
		
		
		
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doPost(req, res);
	
	}
}
