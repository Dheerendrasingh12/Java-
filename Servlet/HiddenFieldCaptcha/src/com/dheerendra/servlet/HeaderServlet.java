package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HeaderServlet
 */
@WebServlet("/headurl")
public class HeaderServlet extends HttpServlet {
	public HeaderServlet() {
    }

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw =null;
		
		res.setContentType("text/html");
		
		pw=res.getWriter();
		
		pw.println("<marquee><h1>Singh Technologies</h1></marquee>");
	}
	

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
		
	}

}
