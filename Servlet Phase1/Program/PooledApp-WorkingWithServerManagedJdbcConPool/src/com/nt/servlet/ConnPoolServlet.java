package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class ConnPoolServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String table=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		int colCount=0;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		table=req.getParameter("table");
		try{
		//get JDBC con obj from jdbc con pool
		con=makeConnection();
		//create Staement object
		st=con.createStatement();
		//send and execute SQL Query in DB s/w
		rs=st.executeQuery("select * from  "+table);
		//create  ResultSetMetaData
		rsmd=rs.getMetaData();
		//get Column count
		colCount=rsmd.getColumnCount();
		//print Column labels...
		pw.println("<table border='1'>");
		pw.println("<tr>");
		for(int i=1;i<=colCount;++i){
			pw.println("<th>"+rsmd.getColumnLabel(i)+"</th>");
		}
		pw.println("</tr>");
		//print col values
		while(rs.next()){
			pw.println("<tr>");
			for(int i=1;i<=colCount;++i){
				pw.println("<td>"+rs.getString(i)+"</td>");
			}
			pw.println("</tr>");
		}//while
		//close table
		pw.println("</table>");
		//add hyperlink
		pw.println("<a href='index.html'>home</a>");
		}//try
		catch(SQLException se){
			pw.println("<h2 style='color:red'>Table does not exist </h2>");
		}
		catch(NamingException ne){
			pw.println("<h2 style='color:red'>Given Jndi based DataSource not found </h2>");
		}
		catch(Exception e){
			pw.println("<h2 style='color:red'>Unknown problem</h2>");
		}
		finally{
			try{
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			
			try{
				if(st!=null)
					st.close();
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
			
			try{
				if(pw!=null)
					pw.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}//finally
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);
	}//doPost(-)
	
	//gives jdbc con obj from jdbc con pool
	public  Connection makeConnection()throws Exception{
          Connection con=null;
          DataSource ds=null;
          InitialContext ic=null;
          //create connection with Jndi regisry
          ic=new InitialContext();
          //get DataSource obj through jndi lookup operation
          ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
          // get Connection obj from jdbc con pool
          con=ds.getConnection();
          return con;
	}//makeConnection()
}//class
