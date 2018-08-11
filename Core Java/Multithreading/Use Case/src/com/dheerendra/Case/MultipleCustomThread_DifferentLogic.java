package com.dheerendra.Case;

class AddThread extends Thread {
	int sum=0;

	public void run() {
		
		for (int i = 1; i <= 50; i++)
			sum=+i;
			System.out.println( getName()+ "  run " + sum);
	}
}
class SubThread extends Thread{
	int diff=0;
	public void run() {
		for(int i=50;i>=1;i--)
		{
			diff-=i;
			System.out.println("substrction"+diff);
		}
	}
}
class MultipleCustomThread_DifferentLogic {
	public static void main(String[] args) {
		System.out.println("main started");
		AddThread add=new AddThread();
		add.start();
		
		SubThread sub=new SubThread();
		sub.start();
		
		System.out.println("End main");
	
	}
	}