package com.nt.servlet;

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

@WebServlet("/s4")
public class Servlet4 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      RequestDispatcher rd=null;
      PrintWriter pw=null;
      HttpSession ses=null;
      ServletContext sc=null;
      //general settings
      pw=res.getWriter();
      res.setContentType("text/html");
      //read  and display request attrbutes
      pw.println("Servlet4:attr1 (request) attribute vlaue:::"+req.getAttribute("attr1"));
      
      //read and display session attribute value
      ses=req.getSession();
      pw.println("<br>Servlet4:attr4 (ses) attribute vlaue:::"+ses.getAttribute("attr2"));
      
      //read and display ServletContext attribute value
      sc=getServletContext();
      pw.println("<br>Servlet4:attr3 (sc) attribute vlaue:::"+sc.getAttribute("attr3"));

      
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   doGet(req,res);
	}

}
