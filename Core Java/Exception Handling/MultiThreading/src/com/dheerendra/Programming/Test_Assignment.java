package com.dheerendra.Programming;
class Mythread extends Thread
{
	public void run() {
		for (int i=20;i>=1;i--) {
			System.out.println("Run "+i);
		}
	}

}

public class Test_Assignment{
	public static void main(String[] args) {
		Mythread mt=new Mythread();
		mt.start();
		mt.run();
		for(int i=1;i<=20;i++) {
			System.out.println("main "+i);
		}
	}
}