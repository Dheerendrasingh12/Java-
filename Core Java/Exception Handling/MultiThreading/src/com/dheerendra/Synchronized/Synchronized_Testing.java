package com.dheerendra.Synchronized;

public class Synchronized_Testing {

	public static void main(String[] args) {
		PrintNumber pn=new PrintNumber();
	/*	MyScynchronizedThread mt1=new MyScynchronizedThread(pn);
		MyScynchronizedThread mt2=new MyScynchronizedThread(pn);
		
		mt1.start();
		mt2.start();
		
		System.out.println();
		*/
		
		PrintNumber pn2=new PrintNumber();
		MyScynchronizedThread mt3=new MyScynchronizedThread(pn);
		MyScynchronizedThread mt4=new MyScynchronizedThread(pn2);
		
		mt3.start();
		mt4.start();
		
		
	}
}
