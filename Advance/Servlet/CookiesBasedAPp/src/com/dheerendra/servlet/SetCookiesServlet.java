package com.dheerendra.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookiesServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Cookie cookie1,cookie2,cookie3,cookie4;
		
		cookie1=new Cookie("nsdl", "New Delhi");
		cookie2=new Cookie("indb", "Indore");
		cookie3=new Cookie("gwl","Gwalior");
		cookie4=new Cookie("kr", "Banglore");
		
		res.addCookie(cookie1);
		res.addCookie(cookie2);
		
		
	}

}

