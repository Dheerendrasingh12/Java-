class Yield_MyThread extends Thread 
{
	public void run(){
		for (int i=0;i<=12 ;i++ )
		{
			//Thread.yield();
			System.out.println("Child Thread");
		}
	}
}
