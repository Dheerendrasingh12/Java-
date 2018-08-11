package com.nt.service;

import com.nt.bo.JobSeekerBO;
import com.nt.dao.JobSeekerDAO;
import com.nt.dao.JobSeeketDAOImpl;
import com.nt.dto.JobSeekerDTO;

public class JobSeekerServiceImpl implements JobSeekerService {

	@Override
	public String register(JobSeekerDTO dto) throws Exception {
		JobSeekerDAO dao=null;
		JobSeekerBO bo=null;
		int count=0;
		//convert BO to DTO
		bo=new JobSeekerBO();
		bo.setName(dto.getName());
		bo.setAddrs(dto.getAddrs());
		bo.setAge(dto.getAge());
		bo.setSkill(dto.getSkill());
		bo.setExp(dto.getExp());
		bo.setSalary(dto.getSalary());
		bo.setCity(dto.getCity());
		  //create DAO class object
		dao=new JobSeeketDAOImpl();
		//use DAO
		count=dao.insert(bo);
		if(count==0)
			return "Registration  Failed";
		else
			return "Registration  Successful";
	}//method
}//class
