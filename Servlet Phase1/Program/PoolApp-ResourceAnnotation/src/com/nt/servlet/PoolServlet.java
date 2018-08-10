package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class PoolServlet extends HttpServlet {
	 @Resource(name="DsJndi")
	  private DataSource ds;
	 
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
       //get Pooled jdbc con objeect
		con=ds.getConnection();
		//create Statement object
		st=con.createStatement();
		//send and execute SQL Query in DB s/w
		rs=st.executeQuery("SELECT * FROM   "+table);
		//process the ResultSet
		rsmd=rs.getMetaData();
		//get column count
		colCount=rsmd.getColumnCount();
		//Display Db table records in Html table
		pw.println("<b>Records of DB table</b>"+table);
		pw.println("<table border='1'>");
		pw.println("<tr>");
		for(int i=1;i<=colCount;++i){
			pw.println("<th>"+rsmd.getColumnLabel(i)+"</th>");
		}
		pw.println("</tr>");
		
		while(rs.next()){
			pw.println("<tr>");
			 for(int i=1;i<=colCount;++i){
				 pw.println("<td>"+rs.getString(i)+"</td>");
			 }
			pw.println("</tr>");
		}//while
		pw.println("</table>");
		 pw.println("<a href='form.html'>home</a>");
	
       }//try
       catch(SQLException se){
    	   pw.println("<h1 style='color:red'>Table not found /Wrong Query </h1>");
    	   se.printStackTrace();
       }
        catch(Exception e){
     	   pw.println("<h1 style='color:red'>Unknow DB problem </h1>");
     	   e.printStackTrace();
        }
        finally{
          try{	
        	  if(rs!=null){
        		 rs.close();
        	 }
          }
         catch(SQLException se){
          	 se.printStackTrace();
          }
          try{	
        	  if(st!=null){
        		 st.close();
        	 }
          }
         catch(SQLException se){
          	 se.printStackTrace();
          }
          try{	
        	  if(con!=null){
        		 con.close();
        	 }
          }
         catch(SQLException se){
          	 se.printStackTrace();
          }
          try{	
        	  if(pw!=null){
        		 pw.close();
        	 }
          }
         catch(Exception e){
          	 e.printStackTrace();
          }
        }//finally
       
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}
	
	
	
}//class
