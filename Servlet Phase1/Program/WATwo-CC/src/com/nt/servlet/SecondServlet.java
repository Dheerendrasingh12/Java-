package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 int val=0;
		 int cube=0;
        //general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form data
		 val=Integer.parseInt(req.getParameter("t1"));
		 //calculate cube value..
		 cube=val*val*val;
		 //dispaly Cube vlaue
		 pw.println("<h1> SecondServlet ::  Cube Value::"+cube+"</h1>");
		 //do not close stream
		 //pw.close();
	}//doGet(-,-)
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         doGet(req,res);	
	}

}
