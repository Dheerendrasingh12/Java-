import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class FirstServlet extends HttpServlet 
{
  	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		PrintWriter out = resp.getWriter();
		out.println("<h1>Client  IP Address:" +req.getRemoteAddr()+"</h1>");
		out.println("<h1>Client Host:" +req.getRemoteHost()+"</h1>");
		out.println("<h1>Client Port" +req.getRemotePort()+"</h1>");
		out.println("<h1>Server Name:" +req.getServerName()+"</h1>");
		out.println("<h1>Server Port:" +req.getServerPort()+"</h1>");
	}
}
