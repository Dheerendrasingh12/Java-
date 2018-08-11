package com.dheerendra.Synchronized;

public class MyThread extends Thread {

	Add a;

	public MyThread(Add a) {
		this.a = a;
	}
	
	public void run() {
		a.add(50, 60);
	}
}
