package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.bo.InfoBO;
import com.nt.dto.InfoDTO;
import com.nt.service.NaukriInfoService;
import com.nt.service.NaukriInfoServiceImpl;

@WebServlet("/thirdurl")
public class ThirdServlet extends HttpServlet {
	   
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      PrintWriter pw=null;
		HttpSession ses=null;
		String city=null,name=null,addrs=null,skill=null;
		int salary=0,age=0;
		float exp=0.0f;
		InfoDTO dto=null;
		NaukriInfoService service=null;
		String result=null;
		
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form2/req2 data
		city=req.getParameter("city");
		salary=Integer.parseInt(req.getParameter("sal"));
		//Locate/Access the SEssion
		ses=req.getSession(false);
		//get  form1/req1 and form2/req2 data from HttpSession obj from session attribute values(session tracking)
		name=(String)ses.getAttribute("name");
		addrs=(String)ses.getAttribute("addrs");
		age=(Integer)ses.getAttribute("age");
		skill=(String)ses.getAttribute("skill");
		exp=(Float)ses.getAttribute("exp");
		//prepare DTO class obj having all the 3 forms  data
		dto=new InfoDTO();
		dto.setName(name); dto.setAddrs(addrs); dto.setAge(age);
		dto.setCity(city); dto.setSalary(salary); dto.setSkill(skill);
		dto.setExp(exp);
		//use Service class
		try{
		service=new NaukriInfoServiceImpl();
		result=service.register(dto);
		pw.println("<h1 style='color:red;text-align:center'> "+result+"</h1>");
		}
		catch(Exception e){
			e.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'> Internal Problem </h1>");
		}
		pw.println("<a href='personal.html'> home </a>");
		   pw.println("<br> sesssion id ::"+ses.getId());
		//Invalid sesession
		ses.invalidate();
	   			//close stream
	   pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
}//class
