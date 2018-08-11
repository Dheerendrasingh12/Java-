package com.dheerendra.Synchronized;

public class Synchronized_Test2 {
	public static void main(String[] args) {
		Add2 a=new Add2();
		
		new MyThread3(a).start();
		new MyThread4(a).start();
	
	}

}
