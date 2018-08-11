package com.dheerendra.Case;

class MyThread4 extends Thread{
	public void run() {
		System.out.println("run start");
		System.out.println(" run mt state after call "+this.getState());
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("run end");
	}
}
public class GetThreadState {
	public static void main(String[] args) throws InterruptedException {
		MyThread4 mt=new MyThread4();
		System.out.println("main method mt state after obj creation "+mt.getState());
		mt.start();

		System.out.println("main method mt state after Call "+mt.getState());
		Thread.sleep(500);

		System.out.println("main method mt state after Sleep "+mt.getState());
	Thread.sleep(6000);

	System.out.println("main method mt state after run "+mt.getState());
	
	}

}
