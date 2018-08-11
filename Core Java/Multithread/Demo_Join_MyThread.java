class Demo_Join_MyThread 
{
	public static void main(String[] args) throws InterruptedException
	{
		Join_MyThread jmt=new Join_MyThread();

		jmt.start();
		for (int i=0;i<=12 ;i++ ){
			System.out.println("Dheerendra");
				jmt.join();
	
		}
		
	}
}
