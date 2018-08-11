class Thread_Priority
{
	public static void main(String[] args) 
	{
		MyThread mt=new MyThread();
		mt.setPriority(10);
		mt.start();
		for (int i=0;i<=12 ;i++ )
		{
		
		System.out.println("Main method");
	}}

}
