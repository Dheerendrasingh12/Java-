package com.dheerendra.priority;

public class Thread_Priority_Name extends Thread{

	public Thread_Priority_Name() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Thread_Priority_Name(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public void run() {
		for(int i=1;i<10;i++) {
			System.out.println(getName()+" i"+i);
		}
	}

	
}
