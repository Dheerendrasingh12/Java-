package com.dheerendra.Synchronized;

public class MyScynchronizedThread extends Thread{

	PrintNumber pn;

	public MyScynchronizedThread(PrintNumber pn) {
		this.pn = pn;
	}
	public void run() {
		pn.display();
	}
}
