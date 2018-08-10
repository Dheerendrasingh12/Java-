package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      PrintWriter pw=null;
      String name=null,fname=null,ms=null;
      //general settings
      pw=res.getWriter();
      res.setContentType("text/html");
      //read form data
      name=req.getParameter("name");
      fname=req.getParameter("fname");
      ms=req.getParameter("ms");
      //handle not-selecting state of checkbox
      if(ms==null)
    	  ms="single";
      
      //Generate form2 dynamically form here based marital status..
      pw.println("<h1 style='color:blue;text-align:center'>Second Form page</h1>");
      if(ms.equalsIgnoreCase("married")){
    	  pw.println("<form action='secondurl' method='post'>");
    	  pw.println("<br> Spouse name ::<input type='text' name='f2t1'><br>");
    	  pw.println("<br> No.of kids ::<input type='text' name='f2t2'><br>");
    	  pw.println("<input type='submit' value='submit'>");
    	  pw.println("</form>");
      }
      else{
    	  pw.println("<form action='secondurl' method='post'>");
    	  pw.println("<br> when do u want to marry ::<input type='text' name='f2t1'><br>");
    	  pw.println("<br> Why do u want to marry ::<input type='text' name='f2t2'><br>");
    	  pw.println("<input type='submit' value='submit'>");
    	  pw.println("</form>"); 
      }//else
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
}//class
