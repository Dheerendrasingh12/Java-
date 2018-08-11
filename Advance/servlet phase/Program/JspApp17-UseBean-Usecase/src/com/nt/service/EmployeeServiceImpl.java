package com.nt.service;

import com.nt.dto.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl:0-param constructor");
	}
	
	@Override
	public void generatePaySlip(EmployeeDTO dto) throws Exception {
		float gSal=0.0f,netSal=0.0f;
		//calc Gross Salary and netSalary
		gSal=dto.getBasicSalary()+dto.getBasicSalary()*0.3f;
		netSal=gSal-(gSal*0.1f);
		//set grossSalary,netSalary to DTO
		dto.setNetSalary(netSal);
		dto.setGrossSalary(gSal);
	}

}
