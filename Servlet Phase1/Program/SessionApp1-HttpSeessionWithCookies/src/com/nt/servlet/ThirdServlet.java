package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dto.JobSeekerDTO;
import com.nt.service.JobSeekerService;
import com.nt.service.JobSeekerServiceImpl;

public class ThirdServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  PrintWriter pw=null;
		  String city=null;
		  int salary=0,exp=0,age=0;
		  String name=null,addrs=null,skill=null;
		  HttpSession ses=null;
		  JobSeekerService service=null;
		  JobSeekerDTO dto=null;
		  String result=null;
		  RequestDispatcher rd=null;
		   //general settings
		  pw=res.getWriter();
		  res.setContentType("text/html");
		  //read form3/req3 data
		  city=req.getParameter("city");
		  salary=Integer.parseInt(req.getParameter("sal"));
		  //get Access to Session object
		  ses=req.getSession(false);
		  //read form1/req1 and form2/req2 data from Session attributes(Session tracking)
		 name=(String)ses.getAttribute("name");
		 addrs=(String)ses.getAttribute("addrs");
		 age=(Integer)ses.getAttribute("age");
		 skill=(String)ses.getAttribute("skill");
		 exp=(Integer)ses.getAttribute("exp");
	
		 //prepare DTO class having all 3 forms data
		 dto=new JobSeekerDTO();
		 dto.setName(name);
		 dto.setAddrs(addrs);
		 dto.setAge(age);
		 dto.setSkill(skill);
		 dto.setExp(exp);
		 dto.setCity(city);
		 dto.setSalary(salary);
		 //create Servie class object
		 service=new JobSeekerServiceImpl();
		 pw.println("<body bgcolor='cyan'>");
		 pw.println("<br> session id::"+ses.getId());
		 try{
		 //invoke the method
		 result=service.register(dto);
		 pw.println("<h1> "+result+"</h1>");
		 }
		 catch(Exception e){
			 rd=req.getRequestDispatcher("/err.html");
			 rd.forward(req,res);
		 }
		 //invalidate  Session
		 ses.invalidate();
		 //add hyperlink
		 pw.println("<a href='input.html'>home</a>");
		 pw.println("</body>");
		 //close stream
		 pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class
