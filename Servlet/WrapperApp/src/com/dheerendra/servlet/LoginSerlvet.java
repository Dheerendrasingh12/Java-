package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginSerlvet
 */
@WebServlet("/loginurl")
public class LoginSerlvet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw = null;
		String uname = null;
		String pwd = null;
			pw = res.getWriter();

		res.setContentType("text/html");
		uname = req.getParameter("uname");
		pwd = req.getParameter("pwd");

		System.out.println(uname + "  " + pwd);

		if (uname.equalsIgnoreCase("Dheerendrasingh12@gmail.com") && pwd.equals("queen")) {
			pw.println("<h1 style='color:red'>Valid Credential</h1>");
		} else
			pw.println("<h1 style ='color :red'>Invalid Credential</h1>");

		pw.println("<a href=login.html>Home</a>");
		pw.println("req object " + req.getClass());
		pw.println("res object " + res.getClass());
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
