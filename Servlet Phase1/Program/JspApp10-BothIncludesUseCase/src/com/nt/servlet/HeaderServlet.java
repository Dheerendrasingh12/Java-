package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headurl")
public class HeaderServlet extends HttpServlet {
       

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 //general settings
		pw=res.getWriter(); 
		res.setContentType("text/html");
		//writer header logic
		pw.println("<marquee width='600' direction='right' ><h1 style='color:red;text-align:center'> T H E  H I N D U </h1></marquee>");
		//do not close stream
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}//doPost(-,-)
}//class
