package com.dheerendra.Case;

class MyThread extends Thread {
	public void run() {
			System.out.println("  run ");
	}
}class Operation_WithStart {
	public static void main(String[] args) {
		System.out.println("main started");
 		SubThread sub=new SubThread();
		sub.start();
		
		System.out.println("End main");
	
	}
	}