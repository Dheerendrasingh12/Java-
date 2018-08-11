package com.dheerendra.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.chart.PieChart.Data;


public class Test04_ArrayList_Employee {

	public static void main(String[] args) {
		ArrayList<Employee> emplist= new ArrayList<>();
		String option;
		int count=1;
		Employee emp;
		Scanner scn=new Scanner(System.in);
			
		do {
			System.out.println("employee "+count++ +" value");
			emp=new Employee();
			System.out.println("Enter eno");
			emp.setEno(scn.nextInt());
			scn.nextLine();
			System.out.println("Enter name");
			emp.setEname(scn.nextLine());
			System.out.println("enter  salary");
			emp.setSal(scn.nextDouble());
			scn.nextLine();
			System.out.println("Enter department name");
			emp.setDept(scn.nextLine());
			System.out.println("enter experiance");
			emp.setExp(scn.nextDouble());
			scn.nextLine();
			emplist.add(emp);
			System.out.println("Do you want to Continue press Y/N");
			option=scn.nextLine();
		}while(option.equalsIgnoreCase("Y"));
		emp=null;
		System.out.println("Employee ");
		for(int i=0;	i<emplist.size();	i++) {
			System.out.println(emplist.get(i));
		}
		
		System.out.println("Again "+emplist);
		
		for(int i=0; 	i<emplist.size();	i++) {
			Employee emp1=emplist.get(i);
			if(emp1.getDept().equalsIgnoreCase("CJ")) {
				if(emp1.getExp()<5) {
					emp1.setSal(2*emp1.getSal());
					
				}else
				{
					emp1.setSal(3/2*emp1.getSal());
				}
				
			}
		}
		System.out.println("Update Employee" + emplist);
		Database db=new Database();
		System.out.println(emplist.get(1));
		
		db.insert();
	}
}
