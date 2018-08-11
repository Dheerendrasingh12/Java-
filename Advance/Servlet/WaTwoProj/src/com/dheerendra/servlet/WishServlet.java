package com.dheerendra.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		Date d = null;
		Calendar cal = null;
		pw = res.getWriter();
		int hr = 0;
		res.setContentType("text/html");
		pw = res.getWriter();

		cal = Calendar.getInstance();
		hr = cal.get(Calendar.HOUR_OF_DAY);

		d = new Date();

		pw.println("<b><i><center>Date And Time " + d + "</b></i></center>");

		if (hr <= 12)
			pw.println("<h2>Good Morning</h2>");

		if (hr <= 16)

			pw.println("<h2>Good Afternoon</h2>");
		if (hr <= 20)

			pw.println("<h2>Good Evening</h2>");
		else
			pw.println("<h2>Good Night</h2>");

		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}

