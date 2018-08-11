class Demo_Yield_Thread 
{
	public static void main(String[] args) 
	{
		Yield_MyThread ymt=new Yield_MyThread();
		ymt.start();

		for(int i=0;i<=12;i++){
			Thread.yield();
		
			System.out.println("Main Method");
		}
	}
}
