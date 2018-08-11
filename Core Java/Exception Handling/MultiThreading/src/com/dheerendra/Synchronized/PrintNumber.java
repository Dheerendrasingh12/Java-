package com.dheerendra.Synchronized;

public class PrintNumber {

	synchronized void display() {
		for(int i=1;i<20;i++) {
			System.out.println(Thread.currentThread().getName()+" run "+i);
		}
	}
}
