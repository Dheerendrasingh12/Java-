package com.dheerendra.Daeemon;

public class Daemon_Thread_Test{

	
	public static void main(String[] args) {
		Daemon_Thread2 ddm=new Daemon_Thread2();
		System.out.println("Countdown start");
	
		for(int i=1;i<=5;i++) {
			System.out.println("main "+i);
		}
	
	}

	
}
