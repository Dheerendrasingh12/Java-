package com.dheerendra.Case;

class MyThread extends Thread {
	public void run() {
		for (int i = 20; i >= 1; i--)
			System.out.print("  run " + i);
	}
}

class Test05_Assignment {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start();
		mt.start();
		//	mt.run();
		for (int i = 1; i <=MultipleCustomThread_DifferentLogic.java 20; i++) {
			System.out.print("  main " + i);
		}
		}
}