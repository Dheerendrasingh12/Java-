package com.dheerendra.Programming;

public class CustomThread_Test {

	public static void main(String[] args) {
		System.out.println("main started");
		
		Custom_MyThread2 mt2=new Custom_MyThread2();
		mt2.start();
		System.out.println("main end"
				+ "");
	}
}
