class Override_Start extends Thread 
{
	public void start(){
		
		System.out.println("Start()");
	}
	public void run(){
		System.out.println("run()");
	}
}

class Override_Start_Super extends Thread 
{
/*	public void start(){
		super.start();
		System.out.println("Start()");
	}
*/	public void run(){
		super.start();
		System.out.println("run()");
	}
}