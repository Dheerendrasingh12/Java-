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
@WebFilter("/*")
public class RequestCountFilter implements Filter {

	int counter=0;
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("RequestCountFilter:init()");
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("RequestCountFilter:doFilter(-,-)");
		PrintWriter pw=res.getWriter();
		counter++;
		
		ServletContext sc=null;
		sc=req.getServletContext();
		
		sc.setAttribute("reqCount",counter);
		System.out.println("RequestCountFilter:before doFilter(-,-)");
		chain.doFilter(req, res);
		pw.println("<h6>"+sc.getAttribute("reqCount")+"</h6>");
		System.out.println("RequestCountFilter:before doFilter(-,-)");
		
	}
	@Override
	public void destroy() {
		System.out.println("requestCountFilter:destroy()");
	
	}

}
