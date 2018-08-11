//VoterServlet.java
package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VoterServlet extends HttpServlet {
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VoterServlet::process(-,-)");
		String name = null, tage = null;
		int age = 0;
		PrintWriter pw = null;
		List<String> list = null;
		String vstatus = null;

		// get PrintWriter
		pw = res.getWriter();
		// set reponse content type
		res.setContentType("text/html");
		// read form data (req parameter names, values)
		name = req.getParameter("pname");
		tage = req.getParameter("page");

		// read vflg value to know client Side validations are performed or not
		vstatus = req.getParameter("vflag");

		if (vstatus.equalsIgnoreCase("no")) {
			// form valiation logic (Server side)
			System.out.println("VoterServlet:: server side form validations...");
			list = new ArrayList();
			if (name == null || name.equals("") || name.length() == 0) { // required
				list.add("<p style='color:red'>Person name is required</p>");
			}

			if (tage == null || tage.equals("") || tage.length() == 0) { // required
				list.add("<p style='color:red'>Person age is required</p>");
			} else {
				try {
					age = Integer.parseInt(tage);
				} catch (NumberFormatException nfe) {
					list.add("<p style='color:red'>Person age must be number value</p>");
				}
				if (age <= 0 || age > 125) {
					list.add("<p style='color:red'>Person age should be in between 1 to 125</p>");
				}
			} //

			if (list.size() != 0) {
				// dispaly form vlidation errors
				for (String msg : list) {
					pw.println(msg);
				} // for
				return;
			} // if
		} // if
		else {
			age = Integer.parseInt(tage);
		}

		// writer request processing logic
		if (age < 18)
			pw.println("<h1 style='color:red'>Mr/Miss. " + name + " u r not elgible to vote</h1>");
		else
			pw.println("<h1 style='color:green'>Mr/Miss. " + name + " u r  elgible to vote</h1>");

		// add grpahical hyperlink
		pw.println("<a href='input.html'><img src='james.png' width='100' height='200'/></a>");
		// close stream
		pw.close();
	}// doGet(-,-)

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VoterServlet:: doGet(-,-)");
		process(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VoterServlet:: doPost(-,-)");
		process(req, res);
	}

}// class