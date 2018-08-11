package com.dheerendra.Programming;

public class MyThread3 extends Thread {

	int x;
	public MyThread3(int x) {
		this.x=x;
	}

	public void run() {
		for (int i = 1; i <= this.x; i++) {
			System.out.println(getName() + " run " + i);
		}
	}

}
