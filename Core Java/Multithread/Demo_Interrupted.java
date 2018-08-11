class Demo_Interrupted 
{
	public static void main(String[] args) throws InterruptedException
	{
	//	System.out.println("Start main");
		Interrupted_MyThread imt=new Interrupted_MyThread();
		imt.start();
		imt.interrupt();
		System.out.println("End of main");
		
	}
}
