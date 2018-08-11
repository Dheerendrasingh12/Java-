package com.dheerendra.priority;

public class Thread_Priority_Name_Test {
	public static void main(String[] args) {
		Thread_Priority_Name mt1 = new Thread_Priority_Name();
		Thread_Priority_Name mt2=new Thread_Priority_Name("Child2");
		
		System.out.println();
		
		System.out.println("mt1 thread initial name and priority");
		System.out.println("mt1 name "+mt1.getName());
		System.out.println("mt1 priority "+mt1.getPriority());
		
		System.out.println();

		System.out.println("mt2 thread initial name and priority");
		System.out.println("mt2 name "+mt2.getName());
		System.out.println("mt2 priority "+mt2.getPriority());
		
		
		mt1.setName("Shruti");
		mt1.setPriority(6);
		
		
		mt2.setPriority(9);
		

		System.out.println();
		
		System.out.println("mt1 thread initial name and priority");
		System.out.println("mt1 name "+mt1.getName());
		System.out.println("mt1 priority "+mt1.getPriority());
		
		System.out.println();

		System.out.println("mt2 thread initial name and priority");
		System.out.println("mt2 name "+mt2.getName());
		System.out.println("mt2 priority "+mt2.getPriority());
		
		
		mt1.start();
		mt2.start();
		for(int i=0;i<10;i++) {
			System.out.println("main "+i);
		}
	}
}
