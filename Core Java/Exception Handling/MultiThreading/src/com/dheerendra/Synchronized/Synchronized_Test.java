package com.dheerendra.Synchronized;

public class Synchronized_Test {
	public static void main(String[] args) {
		Add a=new Add();
		
		new MyThread(a).start();
		new MyThread2(a).start();
	
	}

}
