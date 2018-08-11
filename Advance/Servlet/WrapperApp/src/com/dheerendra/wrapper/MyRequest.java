package com.dheerendra.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {

	
	private HttpServletRequest request;
	public MyRequest(HttpServletRequest request) {
		
		super(request);
		
		this.request=request;
		
	}
	public String getParameter(String name) {
		String value=request.getParameter(name);
		if(name.equals("uname")) {
			if(!value.endsWith("@gmail.com")) {
				return value+"@gmail.com";
			}
		}
		return value;
	
	}

}
