import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class FirstSevlet extends HttpServlet 
{	
    public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		PrintWriter out = resp.getWriter();
		out.println("<h1>This is common response for both GET and Post methods...</h1>");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		doGet(req,resp);		
	}
	
}