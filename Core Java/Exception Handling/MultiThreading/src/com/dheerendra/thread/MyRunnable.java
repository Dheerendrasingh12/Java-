package com.dheerendra.thread;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		
		System.out.println("Run Executed");
	}
	
	public static void main(String[] args) {
		MyRunnable mr=new MyRunnable();
		Thread th=new Thread(mr);
		th.start();
		
	}

}
