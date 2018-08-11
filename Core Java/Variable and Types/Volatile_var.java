class Volatile_var 
{
	static volatile int x=12;
	volatile int y=23;
	public static void main(String[] args) 
	{
		//volatile int z=23;
		x=24; 
		System.out.println(x);
	}
}
