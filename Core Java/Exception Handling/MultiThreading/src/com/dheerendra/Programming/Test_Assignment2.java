package com.dheerendra.Programming;


public class Test_Assignment2{
	public static void main(String[] args) {
	Thread th=new Thread();
	th.start();
	for(int i=1;i<=20;i++) {
			System.out.println("main "+i);
		}
	}
}