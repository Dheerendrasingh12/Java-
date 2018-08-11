package com.dheerendra.State;
class MyThread extends Thread{
	public void run() {
		System.out.println("Run starat");
		System.out.println("run state after start call "+this.getState());
	
		try {
			Thread.sleep(5000);
			
		}catch (InterruptedException ie) {
			
			// TODO: handle exception
		}
		System.out.println("run end");
	
	}
}

public class Test_GetState {

	public static void main(String[] args) throws InterruptedException {
		MyThread mt=new MyThread();
		System.out.println("main method  state after object creation  "+mt.getState());
		
		mt.start();

		System.out.println("main method  state after start call  "+mt.getState());
		
		Thread.sleep(500);
		

		System.out.println("main method  state after sleep called  "+mt.getState());
		
		
		Thread.sleep(6000);

		System.out.println("main method  state after run complete  "+mt.getState());
		
	
	
	
	}
}
