//DBServlet.java  (Servlet to DB communication using Approach1)
package com.dheerendra.servlet;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

@WebServlet(value="/dburl",loadOnStartup=1)
public class DBServlet extends HttpServlet
{
	private static final String GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	Connection con;
	PreparedStatement ps;

	public void init(){
		System.out.println("DBServlet::init()");
		//create con , PrpearedStatement objects
		try{
			//register driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//create Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","root");
			//create PrepraedStatement object
			ps=con.prepareStatement(GET_EMP_DETAILS_BY_NO);
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//init()

	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
     	System.out.println("DBServlet::doGet(-,-)");
           PrintWriter pw=null;
		   int no=0;
		   String num=null;
		   ResultSet rs=null;
		  //General settings
		  pw=res.getWriter();
		  res.setContentType("text/html");
		  try{
		  //read form data
			  num=req.getParameter("eno");
		  no=Integer.parseInt(num);
		  //set value to req parameter
		  ps.setInt(1,no);
		  //execute the  Query
		  rs=ps.executeQuery();
		  //process the ResultSet
		  if(rs.next()){
			  pw.println("<table border='1' align='center'>");
			  pw.println("<tr><th>Emp No</th><th>Emp name</th><th>Emp Job</th><th>Emp Salary</th></tr>");
			  pw.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getInt(4)+"</td></tr>");
			  pw.println("</table>");
		    }//if
			else{
               pw.println("<h1 style='color:red'> records not found </h1>");
			}
			//close ResultSet
			if(rs!=null)
    			rs.close();
		  }//try
		  catch(SQLException se){
			  se.printStackTrace();
		  }
		  catch(Exception e){
			   e.printStackTrace();
		  }
			//add hyperlink
			pw.println("<a href='input.html'>home</a>");
			//close stream
			pw.close();
		  }//doGet(-,-)

		  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
			  	System.out.println("DBServlet::doPost(-,-)");
			     doGet(req,res);
		  }

          public void destroy(){
			  	System.out.println("DBServlet::destroy()");
			  try{
                 if(ps!=null)
					 ps.close();
			  }
			  catch(Exception e){
				  e.printStackTrace();
			  }
			  try{
				  if(con!=null)
					  con.close();
			  }
			  catch(Exception e){
				  e.printStackTrace();
			  }
		  }//destroy()
	}//class
