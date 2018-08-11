package com.dheerendra.Daeemon;

public class Daemon_Thread2 extends Thread{
	Thread th;

	public Daemon_Thread2() {
		th=new Thread(this);
		th.setDaemon(true);

		th.start();
	}

	public void run() {
		System.out.println("run "+th.isDaemon());
		for(int i=1;i<100;i++) {
			System.out.println("run "+i);
		}
	}

	
}
