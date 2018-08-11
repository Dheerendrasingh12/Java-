package com.dheerendra.Programming;

public class Custom_MyThread1 extends Thread{

	public void run() {
		for(int i=1;i<=20;i++) {
			System.out.println("mythread 1 run "+i);
		}
	}
}
