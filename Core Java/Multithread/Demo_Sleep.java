class Demo_Sleep 
{
	public static void main(String[] args) throws InterruptedException 
	{
		MyThread mt=new MyThread();
		mt.start();
		System.out.println("Dheerendra");
		Thread.sleep(2000);
		System.out.println("K");
		Thread.sleep(2000);
		System.out.println("Crazy");

	}
}