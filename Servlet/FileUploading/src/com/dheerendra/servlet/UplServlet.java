package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;

public class UplServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  PrintWriter pw=null;
		  MultipartFormDataRequest nreq=null;
		  UploadBean upb=null;
		  Hashtable<String,UploadFile> ht=null;
		  Enumeration e=null;
		  UploadFile file=null;
		   //general settings
		  pw=res.getWriter();
		  res.setContentType("text/html");
		 // res.addHeader("Content-Disposition","attachment;fileName=abc.txt");
		  
		  try{
		  //prepare Special Request object...
		  nreq=new MultipartFormDataRequest(req);
		  //create File Uploading settings
		  upb=new UploadBean();
		  upb.setFolderstore("e:/store");
		  upb.setOverwrite(false);
		  upb.setMaxfiles(4);
		  upb.setFilesizelimit(10240);
		  //upload files
		  upb.store(nreq);
		  //Display the names of the uploaded files....
		  ht=nreq.getFiles();
		  //Display the content of Hashtable
		  pw.println("<h1>File Uploading is Completed </h1>");
		  pw.println("<h1>The uploaded files are </h1>");
		  e=ht.elements();
		  while(e.hasMoreElements()){
			  file=(UploadFile)e.nextElement();
			  pw.println("<br> <b>"+file.getFileName()+"--> "+file.getFileSize()+"</b>");
		  }//while
		  }//try
		  catch(UploadException upe){
			  upe.printStackTrace();
		  }
		  catch(Exception ex){
			  ex.printStackTrace();
		  }
		  //add hyperlink
		  pw.println("<br><a href='file.html'>home</a>");
		  //close stream
		  pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)

}//class
