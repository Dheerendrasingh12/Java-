
package com.dheerendra.Pausing;

public class Yield_Thread_Test {
	public static void main(String[] args) {
		System.out.println("main");
		Yield_Thread yt = new Yield_Thread();

		yt.start();
		Thread.yield();
		for(int i=10;i>1;i--) {
			System.out.println("main "+i);
		}
		
		
		System.out.println("main end");
	}

}
