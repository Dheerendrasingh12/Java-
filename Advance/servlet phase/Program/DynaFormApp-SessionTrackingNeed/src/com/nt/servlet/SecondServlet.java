package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/surl")
public class SecondServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  PrintWriter  pw=null;
	  String name=null,ms=null,age=null;
	    String  f2val1=null,f2val2=null;
		//general settings
	  pw=res.getWriter();
	  res.setContentType("text/html");
	  //read form1/req1 data
	  name=req.getParameter("name");
	  age=req.getParameter("age");
	  ms=req.getParameter("ms");
	  //read form2/req2 data
	  f2val1=req.getParameter("f2t1");
	  f2val2=req.getParameter("f2t2");
	  //display form1/req1 data and form2/req2 data to DB table
	  pw.println("<b> form1/req1 data ::"+name+"...."+age+"...."+ms+"</b><br>");
	  pw.println("<b> form2/req2 data ::"+f2val1+"..."+f2val2);
	  //add hyperlink
	  pw.println("<br><a href='form.html'>home</a>");
	  //close stream
	  pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}//doPost(-,-)
}//class
