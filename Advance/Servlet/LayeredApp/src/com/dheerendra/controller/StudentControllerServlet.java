package com.dheerendra.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dheerendra.dto.StudentDTO;
import com.dheerendra.service.StudentService;
import com.dheerendra.vo.StudentVO;

public class StudentControllerServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		String no = null, name = null, m1 = null, m2 = null, m3 = null;
		StudentVO vo = null;
		StudentDTO dto = null;
		StudentService service = null;
		String result = null;
		// general settings
		pw = res.getWriter();
		res.setContentType("text/html");
		// read form data
		no = req.getParameter("no");
		name = req.getParameter("sname");
		m1 = req.getParameter("m1");
		m2 = req.getParameter("m2");
		m3 = req.getParameter("m3");

		vo = new StudentVO();
		vo.setSno(no);
		vo.setSname(name);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);

		dto = new StudentDTO();
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));

		service = new StudentService();
		try {
			 result=service.generateResult(dto);
			   pw.println("<h1>"+ result+"</h1>");
		} catch (Exception e) 
		{
			
			 pw.println("<h1>Interal Problem </h1>-->"+e.getMessage());
			 e.printStackTrace();
		} pw.println("<br><a href='form.html'>Try Again</a>");
		   //close stream
		   pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class
