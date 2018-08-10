package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/surl")
public class SecondServlet extends HttpServlet {
	private static final String  INSERT_FORM_DATA="INSERT INTO PERSON_TAB1 VALUES(?,?,?,?,?)";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  PrintWriter  pw=null;
	  String name=null,ms=null;
	    String  f2val1=null,f2val2=null;
	    int age=0;
	    Connection con=null;
	    PreparedStatement ps=null;
	    int result=0;
		//general settings
	  pw=res.getWriter();
	  res.setContentType("text/html");
	  //read form1/req1 data form hidden boxes (session tracking)
	  name=req.getParameter("hname");
	  age=Integer.parseInt(req.getParameter("hage"));
	  ms=req.getParameter("hms");
	  //read form2/req2 data
	  f2val1=req.getParameter("f2t1");
	  f2val2=req.getParameter("f2t2");
	  //write form1/req1 and form2/req2 data to Db table as record
	  try{
		  //register JDBC driver
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  //establish the connection
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		  //create Statement object
		  ps=con.prepareStatement(INSERT_FORM_DATA);
		  //set values to Query params
		  ps.setString(1,name);
		  ps.setInt(2,age);
		  ps.setString(3,ms);
		  ps.setString(4, f2val1);
		  ps.setString(5, f2val2);
		  //execute Query
		  result=ps.executeUpdate();
		  //process the result
		  if(result==0)
			  pw.println("<h1> Registration failed </h1>");
		  else
			  pw.println("<h1> Registration succeded </h1>");
	  }//try
	  catch(SQLException se){
		  se.printStackTrace();
	  }
	  catch(ClassNotFoundException cnf){
		  cnf.printStackTrace();
	  }
	  catch(Exception e){
		  e.printStackTrace();
	  }
	  finally{
		  //close jdbc objs
		  try{
			  if(ps!=null)
				  ps.close();
		  }
		  catch(SQLException se){
			  se.printStackTrace();
		  }
		  try{
			  if(con!=null)
				  con.close();
		  }
		  catch(SQLException se){
			  se.printStackTrace();
		  }
	  }//finally
	  //display form1/req1 data and form2/req2 data to DB table
	  pw.println("<br><b> form1/req1 data ::"+name+"...."+age+"...."+ms+"</b><br>");
	  pw.println("<br><b> form2/req2 data ::"+f2val1+"..."+f2val2);
	  //add hyperlink
	  pw.println("<br><a href='input.html'>home</a>");
	  //close stream
	  pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}//doPost(-,-)
}//class
