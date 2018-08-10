package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String skill=null;
		int exp=0;
		HttpSession ses=null;
		//General settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form2/req2 data
		skill=req.getParameter("skill");
		exp=Integer.parseInt(req.getParameter("exp"));
		//get Access to Session
		ses=req.getSession(false);
		//add form2/req1 data as Session attribute values
		ses.setAttribute("skill",skill);
		ses.setAttribute("exp",exp);
		//generate form3/req3 Dynamically
		pw.println("<body bgcolor='cyan'>");
		pw.println("<h1 style='color:red;text-align:center'> Provide Job Location and Expected Salary </h1>");
		pw.println("<form action='"+res.encodeURL("thirdurl")+"' method='post'>");
		pw.println(" Preffered Location:: <input type='text' name='city'><br>");
		pw.println(" Expected Salary:: <input type='text' name='sal'><br>");
		pw.println("<input type='submit' value='submit'>");
		pw.println("</form>");
		pw.println("<br> Session Id::"+ses.getId());
		pw.println("</body>");
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)

}//class
