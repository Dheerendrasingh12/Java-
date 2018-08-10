package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	private static final String  INSERT_HIDDEN_PERSON="INSERT INTO HIDDEN_PERSON VALUES(?,?,?,?,?)";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String f2val1=null,f2val2=null;
		String name=null,fname=null,ms=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form2/req2 data
		f2val1=req.getParameter("f2val1");
		f2val2=req.getParameter("f2val2");
		//read form1/req1 data from Hidden Boxes (session tracking)
		name=req.getParameter("hname");
		fname=req.getParameter("hfname");
		ms=req.getParameter("hms");
		//write form1/req1 and form2/req2 data to Db table as record
		try{
			//register  Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
            //create PreparedStatement object			
			ps=con.prepareStatement(INSERT_HIDDEN_PERSON);
			//set values Query param values
			ps.setString(1,name);
			ps.setString(2,fname);
			ps.setString(3,ms);
			ps.setString(4,f2val1);
			ps.setString(5,f2val2);
			//execute the Query
			result=ps.executeUpdate();
			//process the result
			if(result==0)
				pw.println("<h1> Registration Failed </h1>");
			else
				pw.println("<h1> Registration Succeded </h1>");
		}//try
		catch (ClassNotFoundException cnf) {
             cnf.printStackTrace();
		}
		catch(SQLException se){
			se.printStackTrace();
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
		}//finallt
		pw.println("<hr>");
		pw.println("<b> form1 /req1 data:::"+name+"...."+fname+"....."+ms+"<br>");
		pw.println("<b> form2 /req2 data:::"+f2val1+"...."+f2val2);
		//add hyperelink
		pw.println("<a href='input.html'>home </a>");
			//close stream
			pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}

}
