package com.dheerendra.Daeemon;

public class Daemon_Thread3 extends Thread{

	public void run() {
		System.out.println("MyThread 1 priority "+this.getPriority());
		System.out.println("my thread 1 daemon "+this.isDaemon());

 }
}
