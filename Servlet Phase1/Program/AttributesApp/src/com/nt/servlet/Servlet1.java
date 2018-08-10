package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s1")
public class Servlet1 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      RequestDispatcher rd=null;
      HttpSession ses=null;
      ServletContext sc=null;
		//create request attributes
		req.setAttribute("attr1","Val1");
		//create Session attribute
		ses=req.getSession();
		ses.setAttribute("attr2","val2");
		//create ServletContext attribute
		 sc=getServletContext();
		 sc.setAttribute("attr3","val3");
		//froward request Servlet2
		rd=req.getRequestDispatcher("/s2");
		rd.forward(req,res);
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)

}//class
