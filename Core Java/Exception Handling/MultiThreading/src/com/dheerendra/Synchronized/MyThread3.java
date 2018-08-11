package com.dheerendra.Synchronized;

public class MyThread3 extends Thread {

	Add2 a;

	public MyThread3(Add2 a) {
		this.a = a;
	}
	
	public void run() {
		a.add(60, 50);
	}
}
