package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/furl")
public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 String name=null;
		 int age=0;
		 String ms=null;
		 
		//general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form1 data/request1 data
		 name=req.getParameter("name");
		 age=Integer.parseInt(req.getParameter("age"));
		 ms=req.getParameter("ms");
		 //Generate form2 dynamic ally based on form1/req1 data..
		 if(ms.equalsIgnoreCase("married")){
			 pw.println("<h1 style='color:red;text-align:center'>Form2 page-for Married life </h1>");
			 pw.println("<form action='surl' method='post'>");
			 pw.println(" Spouse name:: <input type='text' name='f2t1'><br> ");
			 pw.println(" No.of chidren:: <input type='text' name='f2t2'><br> ");
			 pw.println("<input type='submit' value='submit'>");
			 pw.println("<input type='hidden' name='hname' value='"+name+"'>");
			 pw.println("<input type='hidden' name='hage' value='"+age+"'>");
			 pw.println("<input type='hidden' name='hms' value='"+ms+"'>");
			 pw.println("</form>");
		 }
		 else{
			 pw.println("<h1 style='color:red;text-align:center'>Form2 page--for Happy Life </h1>");
			 pw.println("<form action='surl' method='post'>");
			 pw.println(" when do want to marry? :: <input type='text' name='f2t1'><br> ");
			 pw.println(" why do want to marry?:: <input type='text' name='f2t2'><br> ");
			 pw.println("<input type='submit' value='submit'>");
			 pw.println("<input type='hidden' name='hname' value='"+name+"'>");
			 pw.println("<input type='hidden' name='hage' value='"+age+"'>");
			 pw.println("<input type='hidden' name='hms' value='"+ms+"'>");
			 pw.println("</form>");
		 }
		 //close streams
		 pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
