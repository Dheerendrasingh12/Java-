package com.dheerendra.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
@WebFilter("/sumurl")
public class PerformanceTest implements Filter {

	ServletContext sc=null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		sc=filterConfig.getServletContext();
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

			long start=0,end=0;
			start=System.currentTimeMillis();
			chain.doFilter(req, res);
			
			end=System.currentTimeMillis();
			
			System.out.println(((HttpServletRequest) req).getRequestURI()+"  has taken"+(end-start)+"ms");
		
			sc.log(((HttpServletRequest) req).getRequestURI()+" has taken "+(end-start)+"ms");
	}

	@Override
	public void destroy() {
		sc=null;
	}
}
