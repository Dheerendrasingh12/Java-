
package com.dheerendra.Case;

class MyThread3 extends Thread {
	public void run() {
		for (int i = 20; i >= 1; i--)
			System.out.println("  run " + i);
		try {
			Thread.sleep(100);
		}catch (InterruptedException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}

class Sleep {
	public static void main(String[] args) {
		MyThread3 mt = new MyThread3();
		mt.start();
		// mt.run();
		for (int i = 1; i <= 20; i++) {
			System.out.print("  main " + i);
		}
	}
}
