package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dao.StudentDAOImpl;
import com.nt.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {

	@Override
	public String generateResult(StudentDTO dto) throws Exception {
		int total=0;
		float avg=0.0f;
		String result=null;
		StudentDAO dao=null;
		StudentBO bo=null;
		int count=0;
		//write logic 
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(avg<35)
			result="fail";
		else
			result="pass";
		//prepare StudentBO having inputs and outputs
		bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//use DAO
		dao=new StudentDAOImpl();
		count=dao.insert(bo);
		
		if(count==0)
			return "Student Registraion failed:: Result--->"+result;
		else
			return "Student Registraion succeded:: Result--->"+result;
	}//method
}//class
