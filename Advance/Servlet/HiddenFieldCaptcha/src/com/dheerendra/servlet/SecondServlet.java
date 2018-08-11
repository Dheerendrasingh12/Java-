package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/surl")
public class SecondServlet extends HttpServlet {

	private static final String INSERT_INTO_PERMANET = "INSERT INTO PERSON_TAB VALUES(?,?,?,?,?)";

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		String name = null;
		String age = null;
		String ms = null;
		String f2val1 = null;
		String f2val2 = null;
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		RequestDispatcher rd1=null,rd=null;
		
		rd=req.getRequestDispatcher("/headurl");
		
		rd.include(req, res);
		pw = res.getWriter();
		res.setContentType("text/html");

		name = req.getParameter("hname");
		age = req.getParameter("hage");
		ms = req.getParameter("hms");

		f2val1 = req.getParameter("f2t1");
		f2val2 = req.getParameter("f2t2");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "root");
		
			/*
			Class.forName("com.mysql.Jdbc.Driver");
			con=DriverManager.getConnection("JDBC:mysql://mysql104095-Dheerendrasingh.j.layershift.co.uk:3306/DSDB1","root","W181lah6g");
	*/		
			ps = con.prepareStatement(INSERT_INTO_PERMANET);
			ps.setString(1, name);
			ps.setString(2, age);
			ps.setString(3, ms);
			ps.setString(4, f2val1);
			ps.setString(5, f2val2);

			result = ps.executeUpdate();

			if (result == 1)
				pw.println("<h2 style='color:red;text-align:center'>Record Inserted");
			else

				pw.println("<h2 style='color:red;text-align:center'>Record Failed to Inserted");

		}catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
			// TODO: handle exception
		} catch (SQLException se) {
			se.printStackTrace();
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			// close jdbc objs
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finallt
		pw.println("<hr>");
		pw.println("<b> form1 /req1 data:::" + name + "...." + age+ "....." + ms + "<br>");
		pw.println("<b> form2 /req2 data:::" + f2val1 + "...." + f2val2);
		// add hyperelink
		pw.println("<a href='input.html'>home </a>");
		// close stream
		rd1=req.getRequestDispatcher("footer.html");
		rd1.include(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stu
		doGet(req, res);
	}

}
