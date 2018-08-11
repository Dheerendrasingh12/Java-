package com.dheerendra.Programming;

public class MultipleTHread_WithSameLogic {

	public static void main(String[] args) {
		MyThread4 mt1 = new MyThread4();
		
		mt1.setX(7);
	
		mt1.start();
	
	
	MyThread4 mt2 = new MyThread4();
		
		mt2.setX(7);
		mt2.start();
	
	MyThread4 mt3 = new MyThread4();
		
		mt3.start();
	
		for(int i=0;i<20;i++) {
			System.out.println("main "+i);
			
		}
	}
}
