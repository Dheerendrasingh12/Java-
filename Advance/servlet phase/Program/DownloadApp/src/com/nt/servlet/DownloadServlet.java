package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 String fname=null;
		 ServletContext sc=null;
		 String filePath=null;
		 InputStream is=null;
		 OutputStream os=null;
		 int bytesRead=0;
		 byte[] buffer=null;
		 
		 //get File name to downlaoded
		 fname=req.getParameter("fname");
		 //get ServletContext obj
		 sc=getServletContext();
		 //get the Path of the file
		 filePath=sc.getRealPath(fname);
		 //get length of file and make it as response content lenght
		 res.setContentLengthLong(new File(filePath).length());
		 //get MIME type of the file and make it as reponse content type
		 res.setContentType(sc.getMimeType(fname));
		 //set content-disposition header to make file content through 
		 //response obj as downalodable file
		 res.addHeader("Content-Disposition","attachment;fileName="+fname);

		 //create Input stream pointing to file
		 is=new FileInputStream(filePath);
		//create Input stream pointing to response obj
		 os=res.getOutputStream();
		 //write buffer based logic to copy file content to response objs
		 buffer=new byte[1024];
		 while((bytesRead=is.read(buffer))!=-1){
			 os.write(buffer,0,bytesRead);
		 }
		 is.close();
		 os.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class
