package com.rv.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchSrv  extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String search=null;
		String engine=null;
		String searchurl=null;
		
		search=req.getParameter("search");
		engine=req.getParameter("engine");
		
		if(engine.equals("google"))
		{
			searchurl="https://www.google.co.in/search?q="+search;
		}
		else if(engine.equals("bing"))
		{
			searchurl="http://www.bing.com/search?q="+search;
		}
		if(engine.equals("yahoo"))
		{
			searchurl="https://in.search.yahoo.com/search?p="+search;
		}
		System.out.println("Before SearchServ: sendRedirect()");
		res.sendRedirect(searchurl);
		RequestDispatcher rd=req.getRequestDispatcher("Search.html");
		rd.include(req,res);
		System.out.println("After SearchServ: sendRedirect()");
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		doGet(req, res);
	}
}
