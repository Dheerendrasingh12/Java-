package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServlet extends HttpServlet {

	Connection con;
	PreparedStatement ps;

	@Override
	public void init() throws ServletException {
		String driver=null,url=null,user=null,pass=null;
		ServletConfig cg=null;
		try {
			cg = getServletConfig();
			String s1 = cg.getInitParameter("driver");
			String s2 = cg.getInitParameter("dburl");

			String s3 = cg.getInitParameter("dbuser");
			String s4 = cg.getInitParameter("dbpwd");

			Class.forName(s1);

			con = DriverManager.getConnection(s2, s3, s4);
			ps = con.prepareStatement("select ename,sal from emp where empno=?");

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			int no=0;
			
			PrintWriter pw = null;
			pw = res.getWriter();
			
			res.setContentType("text/html");
			no = Integer.parseInt(req.getParameter("teno"));

			ps.setInt(1, no);
			ResultSet rs = null;
			rs = ps.executeQuery();
			if (rs.next()) {
				pw.println("<br><b><i>Emp Name is </i></b>" + rs.getString(1));
				pw.print("<br><<b>Emp Salaray is i</i></b>" + rs.getString(2));

			}
			rs.close();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

	@Override
	public void destroy() {
		try {
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
