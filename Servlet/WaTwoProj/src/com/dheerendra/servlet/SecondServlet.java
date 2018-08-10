package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/Secondurl")
public class SecondServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		int val=0;
		int cube=0;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		
		val=Integer.parseInt(req.getParameter("t1"));
		
		cube=val*val*val;
		
		pw.print("<h1 style='color;text-align:center'>SecondServlet:: Cube Value:: "+cube+"</h1>");
		pw.println("<a href=form.html>Home</a>");
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doPost(req, res);
	}
}
