import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class BinaryStreamDemo1Servlet extends HttpServlet 
{
  	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		resp.setContentType("image/JPEG");
		ServletOutputStream os = resp.getOutputStream();
		//PrintWriter out= resp.getWriter();
		String path=getServletContext().getRealPath("sunny.jpg");
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		byte[] b = new byte[(int)f.length()];
		fis.read(b);//reading the image and placing into byte array
        os.write(b);//write byte array to the respose
		os.flush();
		os.close();
	}
}
