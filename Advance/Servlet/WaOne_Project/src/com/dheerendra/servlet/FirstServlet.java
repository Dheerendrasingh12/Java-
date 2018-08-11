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


public class FirstServlet extends HttpServlet {


	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw=null;
		int val=0;
		int square=0;
		ServletContext sc1=null,sc2=null;
		RequestDispatcher rd=null;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		
		val=Integer.parseInt(req.getParameter("t1"));
		
		square=val*val;
		
		
		pw.println("<br>FirstServlet :Square :"+square+"<br>");
		sc1=getServletContext();
		
		sc2=sc1.getContext("/WaTwoProj");
		
		rd=sc2.getRequestDispatcher("/secondurl");
		
		rd.include(req, res);
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
