
package com.dheerendra.Pausing;

public class Sleep_Thread_Test {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("main");
		Sleep_Thread st=new Sleep_Thread();
		st.start();
		Thread.sleep(5000);
		for(int i=10;i>1;i--) {
			System.out.println("main "+i);
		}

		
		System.out.println("main end");
	}

}
