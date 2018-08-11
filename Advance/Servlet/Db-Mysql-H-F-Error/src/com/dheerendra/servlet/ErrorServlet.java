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
 * Servlet implementation class ErrorServlet
 */
@WebServlet("/eurl")
public class ErrorServlet extends HttpServlet {

		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			System.out.println("Error Servlet doget");
			RequestDispatcher rd1=null;
			RequestDispatcher rd2=null;
			PrintWriter pw=null;
			rd1=req.getRequestDispatcher("/headurl");
			
			rd1.include(req, res);
			pw=res.getWriter();
			res.setContentType("text/html");
			pw.println("<h1 style='color:red;text-align:center'>Internals Proble Please Try Again</h1>");
			pw.println("<a href='input.html'>Home Page</a>");
			
			rd2=req.getRequestDispatcher("/footer.html");
			
			rd2.include(req, res);
			pw.close();
			
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doGet(req, res);
		}
}
