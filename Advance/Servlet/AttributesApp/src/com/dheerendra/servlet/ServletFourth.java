package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/s4url")
public class ServletFourth extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	HttpSession ses=null;
	PrintWriter pw=null;
	ServletContext sc=null;
	
	pw=res.getWriter();
	res.setContentType("text/html");
	
	pw.println("<br>Servlet 4 : attr1 attribute value"+req.getAttribute("attr1"));
	
	ses=req.getSession();
	
	pw.println("<br>Servlet 4 : attr2 atribute value"+ses.getAttribute("attr2"));
	
	sc=getServletContext();
	
	pw.println("<br> Servlet4: attr3 attribute value "+sc.getAttribute("attr3"));
	
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}
}
