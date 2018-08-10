package com.dheerendra.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
/*@WebFilter("/sumurl")
*/public class CheckBrowserFileter implements Filter {

	
		@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			System.out.println("Filter Init(-)");
			
			
		}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		PrintWriter pw=null;
		
		String browser=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		
		browser=((HttpServletRequest)req).getHeader("user-agent");
		
		if(browser.indexOf("chrome")==-1) {
			pw.println("Request Must be given from mozila Firefox");
			return;
		}
		else {
			chain.doFilter(req, res);
		}
		
	
	}
	@Override
	public void destroy() {
	}

}
