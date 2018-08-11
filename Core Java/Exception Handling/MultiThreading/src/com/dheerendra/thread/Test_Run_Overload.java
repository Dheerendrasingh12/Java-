package com.dheerendra.thread;

public class Test_Run_Overload {
	public static void main(String[] args) {
		MyThread2 mt=new MyThread2();
		mt.start();
		MyRunnable2 mr=new MyRunnable2();
		Thread th=new Thread(mr);
		th.start();
	}
}
