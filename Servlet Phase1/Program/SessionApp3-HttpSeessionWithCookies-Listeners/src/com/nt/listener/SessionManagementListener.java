package com.nt.listener;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionManagementListener implements HttpSessionListener {
	  private long start, end;
	  
	  @Override
	public void sessionCreated(HttpSessionEvent se) {
	  start=System.currentTimeMillis();
	  se.getSession().getServletContext().log("Session started at::"+new Date());
	}
	  
	  @Override
	public void sessionDestroyed(HttpSessionEvent se) {
		  end=System.currentTimeMillis();
		  se.getSession().getServletContext().log("Session ended at::"+new Date());
		  se.getSession().getServletContext().log("session duration::"+(end-start));
	}
	  
	
}//class
