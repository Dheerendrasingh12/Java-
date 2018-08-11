package com.dheerendra.Programming;

public class MultiThread_App extends Thread{
	static PrintNumber pn=new PrintNumber();
	public void run() {
		pn.print50to1();
	}
	
	public static void main(String[] args) {
		MultiThread_App mul=new MultiThread_App();
		long time1=System.currentTimeMillis();
		
		mul.start();
			pn.print1to50();
			
			
			
			
		long time2=System.currentTimeMillis();
		System.out.println();
		System.out.println("time taken to complete task "+((time2-time1)/1000)+" sec");
	}
}
