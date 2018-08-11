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

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   PrintWriter pw=null;
	   int val=0;
	   int square=0;
	   ServletContext sc1=null,sc2=null;
	   RequestDispatcher rd=null;
		//general settings
	   pw=res.getWriter();
	   res.setContentType("text/html");
	   //read form data
	   val=Integer.parseInt(req.getParameter("t1"));
	   //calculate square value
	   square=val*val;
	   pw.println("FirstServlet::<h1 style='color:red'>Square ::"+square+"</h1>");
      //Go for CrossContext Communication..
	       //get Local ServletContext object (WAOne)
	     sc1=getServletContext();
	     // get Foreign SerVletcontext object (WATwo)
	     sc2=sc1.getContext("/WATwo-CC");
	     //create RequestDispatcher object..pointing to SecondServlet comp of WATwo
	     rd=sc2.getRequestDispatcher("/secondurl");
	     //include the response
	     rd.include(req,res);
	     //close stream
	     pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
}//class
