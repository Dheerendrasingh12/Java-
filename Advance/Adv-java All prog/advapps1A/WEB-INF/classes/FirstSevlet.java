import javax.servlet.*;
import java.io.*;
import java.util.*;
public class FirstSevlet implements Servlet 
{
	static
	{
		System.out.println("servlet class loading..");
	}
	public FirstSevlet()
	{
		System.out.println("Servlet class Instantiation...");
	}
	public void init(ServletConfig conf) throws ServletException 
	{
		System.out.println("Init Method called");
	}
	public void service(ServletRequest req , ServletResponse resp) throws ServletException,IOException
	{
		System.out.println("Service Method called");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html><body bgcolor=green text=white><h1>Welcome Innocent Adv.Java Students<br/>");
		out.println("The Server Time is :"+new Date()+"</h1></body></html>");
	}	
	public void destroy()
	{
		System.out.println("Destroy Method called");
	}
	public ServletConfig getServletConfig()
	{
		return null;
	}
	public String getServletInfo()
	{
		return "written by durga";
	}


}
