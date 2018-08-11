package com.dheerendra.thread;

public class MyThread extends Thread {

	public void run() {
		System.out.println("Run Executed");
	}
	public static void main(String[] args) {
		MyThread mt =new MyThread();
		mt.start();
	}
}
