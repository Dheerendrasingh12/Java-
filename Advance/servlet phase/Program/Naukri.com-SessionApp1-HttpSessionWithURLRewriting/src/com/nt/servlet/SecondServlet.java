package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	   
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      PrintWriter pw=null;
		HttpSession ses=null;
		String skill=null;
		float exp=0.0f;
		
		
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form2/req2 data
		skill=req.getParameter("skill");
		exp=Float.parseFloat(req.getParameter("exp"));
		//Locate/Access the SEssion
		ses=req.getSession(false);
		//keep form2/req2 data In HttpSession obj as session attribute values
		ses.setAttribute("skill",skill);
		ses.setAttribute("exp",exp);
		   //Generate form3 dynamically from here..
		   pw.println("<h1 style='color:red;text-align:center'> Enter Preffered Location and Expected Salary </h1>");
		   pw.println("<form action="+res.encodeURL("thirdurl")+" method='POST'>");
		    pw.println("Preffered Location ::<input type='text' name='city'><br>");
		   pw.println("Expected  Salary:: <input type='text' name='sal'> <br>");
		   pw.println("<input type='submit' value='submit'>");
		   pw.println("</form>");
		   pw.println("<br> sesssion id ::"+ses.getId());
			//close stream
		   pw.close();
		
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
