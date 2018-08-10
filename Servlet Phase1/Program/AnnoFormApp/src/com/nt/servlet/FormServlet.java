package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
//@WebServlet(description = "test Servlet",name="form",urlPatterns = { "/formurl" },loadOnStartup=1)
//@WebServlet("/formurl")
@WebServlet(name="abc",urlPatterns={"/formurl"})
public class FormServlet extends HttpServlet {
	
	public FormServlet() {
		System.out.println("FormServlet:: 0-param constructor");
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 String name=null;
		//get PrintWriter
		 pw=res.getWriter();
		 //set content type
		 res.setContentType("text/html");
		 //read form data
		 name=req.getParameter("tname");
		 //write output content to response obj
		 pw.println("<h1>Hello, Mr/Miss/Mrs.."+name+"</h1>" );
		 //add hyperlink
		 pw.println("<a href='form.html'>home</a>");
		 //close stream
		 pw.close();
	}//doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
