package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test2")
public class SecondServlet extends HttpServlet {
       

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 Cookie ck[];
	    //general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read cookies
		 ck=req.getCookies();
		 //display cookie details
		 if(ck!=null){
		 pw.println("<h1> Cookie Details  are </h1>");
		 pw.println("<table border='1'>");
		 pw.println("<tr> <th> Cookie name </th> <th> Cookie Value </th><th> Comment </th><th> Max age</th></tr> ");
		 for(Cookie c:ck){
			 pw.println("<tr>");
			   pw.println("<td>"+c.getName()+"</td>");
			   pw.println("<td>"+c.getValue()+"</td>");
			   pw.println("<td>"+c.getComment()+"</td>");
			   pw.println("<td>"+c.getMaxAge()+"</td>");
			 pw.println("</tr>");
		 }//for
		 pw.println("</table>");
		 }
		 else{
			 pw.println("<h1> No cookies are present</h1>");
		 }
		 //close stream
		 pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}

}//class
