package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		int val = 0;
		int squ = 0;
		ServletContext sc1 = null;
		ServletContext sc2 = null;
		pw = res.getWriter();
		res.setContentType("text/html");
		val = Integer.parseInt(req.getParameter("t1"));

		squ = val * val;
		pw.println("First Servlet: Square :" + squ);

		sc1 = getServletContext();
		sc2 = sc1.getContext("/WaTwo");

		RequestDispatcher rd = sc2.getRequestDispatcher("/s2url");

		rd.include(req, res);
		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
