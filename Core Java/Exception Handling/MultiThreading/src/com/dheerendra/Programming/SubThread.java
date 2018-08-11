package com.dheerendra.Programming;

public class SubThread extends Thread {

	int dif=0;
	public void run() {
		for(int i=1;i<=50;i++) {
			dif=dif+i;
			System.out.println("dif "+dif);
		}
	}
}
