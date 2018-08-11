package com.nt.service;

import com.nt.bo.InfoBO;
import com.nt.dao.NaukriInfoDAO;
import com.nt.dao.NaukriInfoDAOImpl;
import com.nt.dto.InfoDTO;

public class NaukriInfoServiceImpl implements NaukriInfoService {

	@Override
	public String register(InfoDTO dto) throws Exception {
		NaukriInfoDAO dao=null;
		int count=0;
		InfoBO bo=null;
		//Convert InfoDTO to InfoBO
		bo=new InfoBO();
		bo.setName(dto.getName());
		bo.setAddrs(dto.getAddrs());
		bo.setAge(dto.getAge());
		bo.setExp(dto.getExp());
		bo.setCity(dto.getCity());
		bo.setSalary(dto.getSalary());
		bo.setSkill(dto.getSkill());
		//use DAO
		dao=new NaukriInfoDAOImpl();
		count=dao.insert(bo);
		//process the result
		if(count==0)
			return dto.getName()+" Details  Registration failed";
		else
			return dto.getName()+" Details  Registration done";
	}//method
}//class
