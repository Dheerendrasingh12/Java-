package com.dheerendra.Case;

class MyThread extends Thread {
	
	int x;
	public MyThread(int x) {
	this.x=x;
	}

	public void run() {
		for (int i = this.x; i >= 1; i--)
			System.out.println( getName()+ "  run " + i);
	}
}

class MultipleCustomThread {
	public static void main(String[] args) {
			MyThread mt1=new MyThread(12);
			mt1.start();
			MyThread mt2=new MyThread(24);
			mt2.start();
			MyThread mt3=new MyThread(36);
			mt3.start();
			
		for(int i=0;i<=20;i++)
			System.out.println(" main "+i);
		}
}