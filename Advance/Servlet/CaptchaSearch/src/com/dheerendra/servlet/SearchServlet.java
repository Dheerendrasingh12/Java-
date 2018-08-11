package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String ss=null;
		String engine=null;
		String answer=req.getParameter("answer");
		String url=null;
		HttpSession ses=req.getSession();
		Captcha captcha=(Captcha) ses.getAttribute(Captcha.NAME);
		
		if(captcha.isCorrect(answer)) {
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
		}
		else {
			PrintWriter pw=null;
			pw=res.getWriter();
			pw.println("<a href=input.html>Wrong Captcha Try Again</a>");
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
