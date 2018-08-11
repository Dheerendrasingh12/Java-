import javax.servlet.*;
import java.io.*;
public class FirstSevlet extends GenericServlet
{
	public FirstSevlet(int i)
	{
		System.out.println("public no-arg constrctor");
	}
	public void service(ServletRequest req, ServletResponse resp) throws ServletException,IOException
	{
		PrintWriter out = resp.getWriter();
		out.println("<h1>Writing servlet by extending GS is very easy</h1>");				
		
	}	
}
