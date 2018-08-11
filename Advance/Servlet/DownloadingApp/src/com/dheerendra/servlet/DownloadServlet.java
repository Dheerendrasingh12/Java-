package com.dheerendra.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downloadurl")
public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String fname = null;
		ServletContext sc=null;
		String filePath=null;
		InputStream is=null;
		OutputStream os=null;
		int bytesRead=0;
		byte[] buffer=null;
		
		fname=req.getParameter("fname");
		
		sc=getServletContext();
		filePath =sc.getRealPath(fname);
		
		res.setContentLengthLong(new File(filePath).length());
		
		res.setContentType(sc.getMimeType(fname));
		
		res.addHeader("Content-Disposition","attachment;fileName="+fname);
		
		is=new FileInputStream(filePath);
		os=res.getOutputStream();
		
		buffer=new byte[1024];
		
		while ((bytesRead=is.read(buffer))!=-1) {
			os.write(buffer, 0, bytesRead);
			
		}
		is.close();
		os.close();
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);

	}

}
