package com.nt.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestTimeAnalyzerListener implements ServletRequestListener {
	  private long start, end;
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
	  start=System.currentTimeMillis();
	}//method
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
	    end=System.currentTimeMillis();
	    //write to log file
	    sre.getServletContext().log(((HttpServletRequest)sre.getServletRequest()).getRequestURI()+" has taken "+(end-start)+" ms to process the request");
	}//method
}//class
