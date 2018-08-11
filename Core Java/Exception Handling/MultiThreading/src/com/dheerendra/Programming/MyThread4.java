package com.dheerendra.Programming;

public class MyThread4 extends Thread
{
	int x;
	boolean xInitialized=false;
	public void setX(int x) {
		this.x=x;
		xInitialized =true;
		
	}
	public void run() {
		if(!xInitialized) {
			throw new IllegalStateException("Error x is not initialized for  the thread ["+getName()+"]");
		}
		for(int i=0;i<this.x;i++) {
			System.out.println(getName()+" run "+i);
		}
	}

}
