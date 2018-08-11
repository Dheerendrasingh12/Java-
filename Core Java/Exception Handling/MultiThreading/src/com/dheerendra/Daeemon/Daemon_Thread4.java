package com.dheerendra.Daeemon;

public class Daemon_Thread4 extends Thread{

	public void run() {
		System.out.println("MyThread 2 priority "+this.getPriority());
		System.out.println("my thread 2 daemon "+this.isDaemon());

		Daemon_Thread3 mt1=new Daemon_Thread3();
		mt1.start();
 }
}
