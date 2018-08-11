package com.dheerendra.Case;

class MyThread1 extends Thread {
	
	int x;
	boolean xint=false;
	

	public void setX(int x) {
		this.x = x;
	}


	public void run() {
		if(!xint) {
			throw new IllegalArgumentException("Error x is not intilized "+getName());
			
		}
		for (int i = this.x; i >= 1; i--)
			System.out.println( getName()+ "  run " + i);
	}
}

class MultipleCustomThread_SameLogic {
	public static void main(String[] args) {
			MyThread1 mt1=new MyThread1();
			mt1.setX(12);
			mt1.start();
			MyThread1 mt2=new MyThread1();
	//		mt1.setX(24);
			mt2.start();
		for(int i=0;i<=20;i++)
			System.out.println(" main "+i);
		}
}