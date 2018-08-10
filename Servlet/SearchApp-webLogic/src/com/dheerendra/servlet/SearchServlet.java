package com.dheerendra.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchingurl")
public class SearchServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String ss=null;
		String engine=null;
		
		String url=null;
		
		ss=req.getParameter("ss");
		engine=req.getParameter("engine");
		
		if(engine.equals("google")) {
			url="https://www.google.co.in/search?q="+ss;
		}
		else if(engine.equals("bing")) {
			url="https://www.bing.com/search?q="+ss;
		}
		
		else if(engine.equals("yahoo")) {
			url="https://in.search.yahoo.com/search?p"+ss;
		}
		
		System.out.println("Before SearchServlet :sendRedirect(-)");
		
		res.sendRedirect(url);
		
		
		RequestDispatcher rd=req.getRequestDispatcher("input.html");
		
		rd.include(req, res);
		System.out.println("After SearchServlet:sendRedirect(-)");
		
	
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
		
	}

}
