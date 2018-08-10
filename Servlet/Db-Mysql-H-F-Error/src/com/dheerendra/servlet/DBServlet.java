package com.dheerendra.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBServlet
 */
@WebServlet("/dburl")
public class DBServlet extends HttpServlet {

//	private static  final String  GET_EMP_DETAILS="SELECT ENO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
     Connection con;
	Statement st;
	 
	public void init(){
		try{
			//register driver class(type4 oracle thin driver)
			Class.forName("com.mysql.jdbc.Driver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
           //create PrpearedStatement object
			st=con.createStatement();
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//init()

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		
		int no=0;
		ResultSet rs=null;
		
		RequestDispatcher rd=null,rd1=null,rd2=null;
		try {
		rd1=req.getRequestDispatcher("/headurl");
		rd1.include(req, res);
		//rd1.forward(req, res);
		pw=res.getWriter();
		
		res.setContentType("text/html");
		
		pw.println("<b>Before Raising Exception</b>");
		
		no=Integer.parseInt(req.getParameter("teno"));
		
		
		rs=st.executeQuery("SELECT ENO,ENAME,JOB,SAL FROM EMP WHERE ENO="+no);
		
		pw.println("<h1>Employee Details Are</h1>");
		if(rs.next()!=false) {
		pw.println("<h3>emp number ::"+rs.getInt(1)+"</h3>");
		pw.println("<h3>emp name ::"+rs.getString(2)+"</h3>");
		pw.println("<h3>emp job ::"+rs.getString(3)+"</h3>");
		pw.println("<h3>emp salary ::"+rs.getFloat(4)+"</h3>");
		
		
		}else {
			pw.println("<h1 style='color:red;text-align:center'>Employee not found</h1>");
			
		}
		pw.println("<a href='input.html'>HOME</a>");
		
		rd2=req.getRequestDispatcher("/footer.html");
		rd2.include(req, res);
		//rd2.forward(req, res);
		
		}catch (Exception e) {
			System.out.println("before rd.forward()");
			pw.println("<b>before rd.forward(-,-)</b>");
			
			rd=req.getRequestDispatcher("/eurl");
			
			rd.forward(req, res);
	
//			rd.include(req, res);
			System.out.println("after rd.forward()");
			pw.println("<b>after rd.forward</b>");
			e.printStackTrace();
			
			
		
		}finally {
			try {
				if(rs!=null)
					rs.close();
			}catch (SQLException se) {
				se.printStackTrace();
				// TODO: handle exception
			}
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);
	}

	@Override
	public void destroy() {
		try {
			if(st!=null)
				st.close();
		}catch (SQLException se) {
			se.printStackTrace();
			// TODO: handle exception
		}
		try {
			if(con!=null)
				con.close();
		}catch (SQLException se) {
			se.printStackTrace();
			// TODO: handle exception
		}
	}
}
