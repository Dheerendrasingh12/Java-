package com.dheerendra.priority;

public class Example {
	
	static {
		Thread th=Thread.currentThread();
		System.out.println("example class is loaded through the thread "+th.getName());
	}
	
	static void m1() {
		Thread th=new Thread();
		System.out.println("example class m1 is executing in the thread "+th.getName());
	}
}
