class ThinkAsA_Compiler 
{
	public static void main(String[] args) 
	{
		System.out.println(10);
		System.out.println('a' );
		System.out.println("d");
		System.out.println(10.0);

		System.out.println(10.345f);
		
		System.out.println(30L);
		System.out.println(30l);
		System.out.println( 50+20 );

		int a=30,b=40;
		System.out.println(a+b);
		
		System.out.println("a+b");
		
		System.out.println("a+b"+a+b);

		int de=10/3;
//		System.out.println("a-b"+a-b);
		System.out.println("a-b"+(a-b));
		System.out.println("a*b"+a*b);
		System.out.println("a*b"+(a*b));
		System.out.println(""+10+20);
		System.out.println(10+""+20);
		System.out.println("a-b"+(a-b));
		System.out.println(10+20+"");
		System.out.println(22/7*10*10);
		System.out.println(22F/7*10*10);
		System.out.println(22D/7*10*10);
		//System.out.println(10/0);
		System.out.println(10.0/0);
		
		System.out.println(-10.0/0);
		
//		System.out.println(0/0);
		System.out.println(0.0/0);
		
		System.out.println(-0.0/0);
	
		
		int a1 =50;
		int b1=50;
		
		System.out.println(a1==b1);
		
		
		System.out.println(a1!=b1);

		System.out.println(a1=b1);
		//System.out.println(a1=b1==b1);
		System.out.println((a1=b1)==b1);
		
	}
}
