import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class WordServlet extends HttpServlet 
{
  	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/msword");
		out.println("<h1><table border=1>");
		out.println("<tr><th>NAME</th><th>RANK</th></tr>");
		out.println("<tr><td>SUNNY</td><td>1</td></tr>");
		out.println("<tr><td>MALLIKA</td><td>2</td></tr>");
		out.println("<tr><td>VEENA</td><td>3</td></tr>");
		out.println("<tr><td>MALLIKA ARORA</td><td>4</td></tr></h1>");
	}
}
