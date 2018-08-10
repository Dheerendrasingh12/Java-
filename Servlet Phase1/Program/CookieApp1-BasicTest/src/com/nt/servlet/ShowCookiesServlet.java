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
public class ShowCookiesServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		Cookie cks[]=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read and display the cookies
		cks=req.getCookies();
		if(cks!=null){
			pw.println("<table border='1'>");
			pw.println("<tr><th>Cookie name</th><th>Cookie value</th></tr>");
			for(Cookie ck:cks){
				pw.println("<tr>");
				 pw.println("<td>"+ck.getName()+"</td>");
				 pw.println("<td>"+ck.getValue()+"</td>");
				pw.println("</tr>");
			}//for
			pw.println("</table>");
		}//if
		else{
			pw.println("<b>No cookies present</b>");
		}//else
		//close stream
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}

}//class
