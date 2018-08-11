class Fibnacci
{
	Fibnacci()
	{
		int a, b, c;
		a=0 ; b=1;
		System.out.print("0 ,1 ");
		for(int i=0 ; i<100 ; i++)
		{
			c=a+b;
			a=b;
			b=c;
			System.out.print(" ,"+c);
		}
	}
	
	public static void main(String ...args)
	{
		Fibnacci fib=new Fibnacci();
	}
}