package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/registerurl")
public class RegisterServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	PrintWriter pw =null;
	
	String name=null;
	pw=res.getWriter();
	res.setContentType("text/html");
	
	name=req.getParameter("name");
	
	pw.println("<h1>Name is :</h1>"+name);

	pw.close();
}

 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 doGet(req, res);
 }
}
