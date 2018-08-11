package com.dheerendra.filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class DoublePostingPreventingFilter
 */
@WebFilter(value="/*")
public class DoublePostingPreventingFilter implements Filter {

	@Override
	public void init(FilterConfig fg) throws ServletException {
		System.out.println("DoublePosting init(-)");

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession ses = null;
		int serverToken = 0;
		int clientToken = 0;
		
		HttpServletRequest hreq=null;
		
		hreq=(HttpServletRequest)req;
		if(hreq.getMethod().equals("GET"))	{
			
			ses=hreq.getSession(true);
			
			ses.setAttribute("stoken",new Random().nextInt(121212));
			
			chain.doFilter(req, res);
			
			
		}
		else {
			
			serverToken= (Integer) ses.getAttribute("stoken");
			
			clientToken=Integer.parseInt(req.getParameter("ctoken"));
			
			System.out.println(clientToken+"--------"+serverToken);
			
			
			if(serverToken==clientToken) {
				ses.setAttribute("stoken", new Random().nextInt(100000));
				chain.doFilter(req, res);
			}
			else {
				RequestDispatcher rd=req.getRequestDispatcher("/double_post_err.jsp");
				rd.forward(req, res);
			}
			
		}
	}
	
	@Override
	public void destroy() {
		
		System.out.println("destroy");
	
	}
}
