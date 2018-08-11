package com.dheerendra.priority;

public class Current_Thread_Test {

	static {
		System.out.println("in sb");

		Thread th = Thread.currentThread();
		System.out.println("sb is executing in \"" + th.getName() + "\" thread\n");
	}

	public static void main(String[] args) {
		System.out.println("\n main method ");
	
		Thread th=Thread.currentThread();
		
		System.out.println("original name and priority of main thread");
		System.out.println("current thread name : "+th.getName());
		
		System.out.println("current thread priority "+th.getPriority());
		
		th.setName("Ds");
		th.setPriority(7);
		
	
		System.out.println("\nmodified name and priority ");
		System.out.println("current thread name "+th.getName());
		System.out.println("current thread priority "+th.getPriority());
	
	
	}
	
}
