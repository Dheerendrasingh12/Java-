package com.nt.satish;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example
 */
public class Example extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Example() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Set response content type
		res.setContentType("text/html");

		PrintWriter out = res.getWriter();
		out.println("Hello");

		int mon = Integer.parseInt(req.getParameter("mon"));
		int Total = mon;
		out.println("<h1 Total Count of mon=" + Total + "></h1>");

		int tue = Integer.parseInt(req.getParameter("tue"));
		Total = mon + tue;
		out.println("<h1 Total Count of  mon + tue=" + Total + "></h1>");

		int wed = Integer.parseInt(req.getParameter("wed"));
		Total = mon + tue + wed;
		out.println("<h1 Total Count of mon + tue + wed=" + Total + "></h1>");

		int thu = Integer.parseInt(req.getParameter("thu"));
		Total = mon + tue + wed + thu;
		out.println("<h1 Total Count of mon + tue + wed + thu=" + Total + "></h1>");

		int fri = Integer.parseInt(req.getParameter("fri"));
		Total = mon + tue + wed + thu + fri;
		out.println("<h1 Total Count of mon + tue + wed + thu + fri=" + Total + "></h1>");

		int sat = Integer.parseInt(req.getParameter("sat"));
		Total = mon + tue + wed + thu + fri + sat;
		out.println("<h1 Total Count of mon + tue + wed + thu + fri + sat=" + Total + "></h1>");

		int sun = Integer.parseInt(req.getParameter("sun"));
		Total = mon + tue + wed + thu + fri + sat + sun;
		out.println("<h1 Total Count of mon + tue + wed + thu + fri + sat+sun=" + Total + "></h1>");

		res.sendRedirect("/index.html");
		out.close();

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	
	}

}
