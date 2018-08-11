class ThreadA_Wait 
{
	public static void main(String[] args) 
	{
		ThreadB_Wait tb=new ThreadB_Wait();
		tb.start();
		//Thread.sleep(4000);
		Synchronized(b);{
		System.out.println("main thread trying to call");
		tb.wait();
		//tb.wait(1000);
		System.out.println("main thread got notification");
		System.out.println(b.total);
		}
	}
}

