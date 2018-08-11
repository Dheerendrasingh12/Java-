package com.dheerendra.Programming;

public class Single_Thread_App {
	public static void main(String[] args) {
		PrintNumber pn = new PrintNumber();
		long time1 = System.currentTimeMillis();
		pn.print1to50();

		System.out.println();
		pn.print50to1();

		long time2 = System.currentTimeMillis();
		System.out.println();
		System.out.println("Time taken to complete both task " + ((time2 - time1) / 1000) + " sec");

	}
}
