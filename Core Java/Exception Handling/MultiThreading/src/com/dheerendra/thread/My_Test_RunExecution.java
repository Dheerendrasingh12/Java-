package com.dheerendra.thread;

public class My_Test_RunExecution {

	public static void main(String[] args) {
		Thread th1=new Thread();
		th1.start();
		My_Thread mt=new My_Thread();
		mt.start();
		
		My_Runnable mr=new My_Runnable();
		//mr.start();
		
		Thread th2=new Thread(mr);
		th2.start();
		
		My_Thread mt1=new My_Thread();
		Thread th3=new Thread(mt1);
		th3.start();
		
		
		Thread th4=new My_Thread();
		th4.start();
		
		//Thread th5=new My_Runnable();
		//th5.start();
		
		Runnable r=new My_Runnable();
	/*	r.start();
	*/
	
		Thread th6=new Thread(r);
		th6.start();
		
		Runnable r1=new My_Thread();
		/*r1.start();*/
	
		Thread th7=new Thread(r1);
		th7.start();
	}
}
