class ThreadDemo 
{
	public static void main(String[] args) 
	{
		MyThread mt=new MyThread();
		mt.start();
//		mt.run();
		for(int i=0;i<=12;i++)
			System.out.println("Main Thread");
	}
}
