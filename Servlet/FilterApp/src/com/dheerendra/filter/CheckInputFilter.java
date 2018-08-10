package com.dheerendra.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/sumurl")
public class CheckInputFilter implements Filter {

	public CheckInputFilter() {
		System.out.println("CheckInputsFilter: 0-paramconstructor");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

		System.out.println("CheckInputFilter:inint(-)");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("CheckInputFilter:doFilter");
		ServletContext sc=null;
		PrintWriter pw=null;
		int val1=0;
		int val2=0;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		val1=Integer.parseInt(req.getParameter("first"));
		val2=Integer.parseInt(req.getParameter("second"));
		
		if(val1<0 || val2<0) {
			pw.println("<h3 style=color:blue;text-align:center>Input Must be Positive</h4>");
			pw.println("<a href=page.html>HOME PAGE</a>");
		}
		else {
			System.out.println("checkInputFilter:before chain.doFilter(-,-)");
			chain.doFilter(req, res);
			
			System.out.println("checkInputFilter:after chain.doFilter(-,-)");
		}
			
		
		
	}
	@Override
	public void destroy() {
		System.out.println("checkInputFilter:destroy()");
	}

}
