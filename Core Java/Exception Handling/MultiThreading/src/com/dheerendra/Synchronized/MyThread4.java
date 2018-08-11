package com.dheerendra.Synchronized;

public class MyThread4 extends Thread {

	Add2 a;

	public MyThread4(Add2 a) {
		this.a = a;
	}
	
	public void run() {
		a.add(70, 80);
	}
}
