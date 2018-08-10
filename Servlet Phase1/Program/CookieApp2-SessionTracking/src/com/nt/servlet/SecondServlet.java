package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/secondurl")
public class SecondServlet extends HttpServlet {
	private static final String INSERT_TAX="INSERT INTO TAX_TAB VALUES(?,?,?,?)";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 int income=0,tax=0;
		 Cookie cks[]=null;
		 String name=null,fname=null;
		 int result=0;
		//general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form2/req2 data
		 income=Integer.parseInt(req.getParameter("income"));
		 tax=Integer.parseInt(req.getParameter("tax"));
		 //read form1/req1 data from Cookies (Session tracking)
		 cks=req.getCookies();
		 if(cks!=null){
			 name=cks[0].getValue();
			 fname=cks[1].getValue();
		 }
		 //write form1/req1 and form2/req2 data as record in DB table
		 try{
			 Class.forName("oracle.jdbc.driver.OracleDriver");
		 }
		 catch(ClassNotFoundException cnf){
			 cnf.printStackTrace();
		 }
		//Establish the connection
		 try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager")){
			  try(PreparedStatement ps=con.prepareStatement(INSERT_TAX)){
				  //set values to query
				  ps.setString(1,name);
				  ps.setString(2,fname);
				  ps.setInt(3,income);
				  ps.setInt(4,tax);
				  //execute the Query
				  result=ps.executeUpdate();
				  //proces the Result
				  if(result==0)
					  pw.println("<h1 style='color:red'>Registration not succeded</h1>");
				  else
					  pw.println("<h1 style='color:red'>Registration  succeded</h1>");
			  }//try
		 }//try
		 catch(SQLException se){
			 se.printStackTrace();
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 //Generate dynamic webpage showing both form1,form2 data
		 pw.println("<hr>");
		 pw.println("<br>form1/req1 data::"+name+"...."+fname);
		 pw.println("<br>form2/req1 data::"+income+"..."+tax);
		 //add hyperlink
		 pw.println("<br><a href='input.html'> home</a>");
		 
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
     doGet(req,res);
	}
	
}
