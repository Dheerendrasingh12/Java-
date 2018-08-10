package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int no=0;
		int square=0;
		ServletContext sc1=null,sc2=null;
		RequestDispatcher rd=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		no=Integer.parseInt(req.getParameter("t1"));
		//calculate SQUARE Value
		square=no*no;
		pw.println("<h1 style='color:red'>FirstServlet:: Square value::"+square+"</h1>");
		//get ServletContext obj of current web application
		sc1=getServletContext();
		//get ServletContext obj of Destination application (WATwo)
		sc2=sc1.getContext("/WATwo");
		//create RequestDispatcher object pointing SecondServlet comp of WATWo
		rd=sc2.getRequestDispatcher("/secondurl");
		//include the response
		rd.include(req, res);
		//close stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       doGet(req,res);
	}

}
