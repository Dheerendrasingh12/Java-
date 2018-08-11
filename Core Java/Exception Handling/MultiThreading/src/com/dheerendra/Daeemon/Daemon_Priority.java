package com.dheerendra.Daeemon;

public class Daemon_Priority {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("main started");
		
		Thread th=Thread.currentThread();
		System.out.println("main thread priority "+th.getPriority());
		System.out.println("main thread daemon "+th.isDaemon());
		
		
		Daemon_Thread4 mt4=new Daemon_Thread4();
		
		mt4.start();
		System.out.println("daemon4 thread priority "+mt4.getPriority());
		System.out.println("daemon4 thread daemon "+mt4.isDaemon());
		
		mt4.setPriority(7);
		mt4.setDaemon(true);
		
		mt4.start();
		Thread.sleep(3000);
		System.out.println("main exit");
	
	
	}
}
