class Runnable_Demo 
{
	public static void main(String[] args) 
	{
		MyRunnable r=new MyRunnable();
		Thread t=new Thread(r);
		t.start();
		for (int i=0;i<=12 ;i++ )
		{
			System.out.println("Main Thread");
		}
	}
}
