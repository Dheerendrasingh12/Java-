package com.dheerendra.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dheerendra.wrapper.MyRequest;
import com.dheerendra.wrapper.MyRespone;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		System.out.println(" filter init()");
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		MyRequest mreq=null;
		
		MyRespone mres=null;
		
		
		String output=null;
		PrintWriter pw=null;
		
		mreq=new MyRequest((HttpServletRequest)req);
		
		mres=new MyRespone((HttpServletResponse)res);
		
		chain.doFilter(mreq, mres);
		output =mres.toString();
		
		output=output+"Singh Ameerpet";
		pw=res.getWriter();
		
		pw.println(output);
		

	}
		@Override
		public void destroy() {
			System.out.println("filter :: destroy()");
		}
}
