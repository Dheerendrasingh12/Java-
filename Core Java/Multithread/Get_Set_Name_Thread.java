class Get_Set_Name_Thread 
{
	public static void main(String[] args) 
	{

		System.out.println(Thread.currentThread().getName());
		Thread.currentThread().setName("Dheerendra");
		
		System.out.println(Thread.currentThread().getName());
	}
}
