import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class FormDemoServlet extends HttpServlet 
{
  	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		PrintWriter out = resp.getWriter();
		String username=req.getParameter("uname");
		String usercontact=req.getParameter("ucontact");
		out.println("<h1>User Name:"+username+"<br>");
		out.println("User Contact:"+usercontact+"<br>");
		String[] s = req.getParameterValues("course");
		out.println("Your Selected Courses:<br/>");
		for(String s1 : s)
		{
			out.println(s1+"<br>");
		}
		out.println("</h1>");
	}

}
