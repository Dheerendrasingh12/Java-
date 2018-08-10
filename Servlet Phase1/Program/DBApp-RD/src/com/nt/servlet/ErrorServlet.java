package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/errorurl",name="error")
public class ErrorServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ErrorServlet :doGet(-,-)");
		PrintWriter pw=null;
		RequestDispatcher rd1=null,rd2=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//include hedaer content
		rd1=req.getRequestDispatcher("/headurl");
		//rd1.include(req,res);
		//Dispaly Error messages as non-technical guiding messages
		pw.println("<h1 style='color:red'>Internal problem </h1>");
		pw.println("<br> <a href='input.html'> Try Again </a>");
        //include footer
		rd2=req.getRequestDispatcher("/footer.html");
		//rd2.include(req,res);

		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ErrorServlet:: doPost(-,-)");
		doGet(req,res);
	}//doPost(-,-)

}//class
