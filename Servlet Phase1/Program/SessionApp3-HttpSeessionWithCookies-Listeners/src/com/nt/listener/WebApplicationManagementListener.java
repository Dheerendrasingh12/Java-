package com.nt.listener;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class WebApplicationManagementListener implements ServletContextListener {
	  private long start, end;
	  
	  @Override
	public void contextInitialized(ServletContextEvent sce) {
	  start=System.currentTimeMillis();
	  sce.getServletContext().log(sce.getServletContext().getContextPath()+" is deployed/reloaed at"+new Date());
	}
	  
	  @Override
	public void contextDestroyed(ServletContextEvent sce) {
		end=System.currentTimeMillis();
		sce.getServletContext().log(sce.getServletContext().getContextPath()+" is stopped/reloaded/undeployed at"+new Date());
		sce.getServletContext().log(sce.getServletContext().getContextPath()+" is in running mode for"+(end-start)+" ms");        		
	}
	  
	
}//class
