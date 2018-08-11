package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class ConnPoolServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		String tabName=null;
		int colCount=0;
		PrintWriter pw=null;
		
		
		pw=res.getWriter();
		res.setContentType("text/html");
		
		tabName =req.getParameter("table");
		
		
		try {
			con=getConnection();
			
			ps=con.prepareStatement("SELECT * FROM "+tabName);
			
			rs=ps.executeQuery();
			rsmd=rs.getMetaData();
			colCount=rsmd.getColumnCount();
			pw.println("<table border='1' bgcolor='red'>");
		
			pw.println("<tr bgcolor:blue>");
			
			for(int i=1;	i<=colCount;	i++) {
				pw.println("<th>"+rsmd.getColumnLabel(i)+"</th>");
			}
			pw.println("</tr>");
			
			while (rs.next()) {
				pw.println("<tr>");
				for(int i=1;	i<=colCount;	i++) {
					pw.println("<td>"+rs.getString(i)+"</td>");
				}
				pw.println("</tr>");
				
			}
			pw.println("</table>");
			
			pw.println("<br><a href='index.html'>TryAgain</a>");
			
			rs.close();
			ps.close();
			con.close();
			
			
			
		}catch (SQLException se) {
		
			pw.println("Problem Occur");
			pw.println("<br><a href='index.html'>TryAgain</a>");
			se.printStackTrace();
		}catch (Exception e) {
			pw.println("Problem Occur");
			pw.println("<br><a href='index.html'>TryAgain</a>");
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

			doGet(req, res);
	}

	public Connection getConnection() throws Exception {

		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		ic = new InitialContext();
		ds = (DataSource) ic.lookup("java:/comp/env/DsJndi");
		con = ds.getConnection();
		return con;

	}
}
