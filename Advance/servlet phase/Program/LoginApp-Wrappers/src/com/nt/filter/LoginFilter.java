package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.wrappers.MyRequest;
import com.nt.wrappers.MyResponse;

@WebFilter("/loginurl")
public class LoginFilter extends GenericFilter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		MyRequest mreq=null;
		MyResponse mres=null;
		String output=null;
		PrintWriter pw=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//Create Custom Request,Response objects
		mreq=new MyRequest(((HttpServletRequest)req));
		mres=new MyResponse(((HttpServletResponse)res));
		//delegate the request
		chain.doFilter(mreq, mres);
		//get Output from mres obj
		output=mres.toString();
		output=output+"<br><br> NIT, Ameerpet";
		pw.println(output);
		//close stream
		pw.close();
	}//doFilter(-,-)
}//class
