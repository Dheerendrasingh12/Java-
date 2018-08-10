package com.nt.wrappers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {
   HttpServletRequest request;
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
	}
	
	@Override
		public String getParameter(String name) {
		    String pval=null;
		    pval=request.getParameter(name);
		    if(name.equalsIgnoreCase("uname")){
		        if(pval.indexOf("@gmail.com")==-1){
		        	pval=pval+"@gmail.com";
		        }
		    }
		    return pval;
		}

}
