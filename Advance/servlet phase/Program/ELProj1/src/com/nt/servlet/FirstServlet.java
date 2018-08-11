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
import javax.servlet.http.HttpSession;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		HttpSession ses=null;
		ServletContext sc=null;
		RequestDispatcher rd=null;
		//general settings
		pw=res.getWriter();
		
		//create diff scopes of attributes
		req.setAttribute("attr1","val1");
		ses=req.getSession(true);
		ses.setAttribute("attr2","val2");
		sc=getServletContext();
		sc.setAttribute("attr3","val3");
	
		 //create RequestDispatcher object
		rd=req.getRequestDispatcher("/el2.jsp");
		rd.forward(req,res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}

}
