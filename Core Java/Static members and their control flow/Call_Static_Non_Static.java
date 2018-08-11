class Call_Static_Non_Static 
{
	static int a=10;
	static int b=20;
	int x=30;
	int y=40;

	public static void main(String[] args) 
	{
		System.out.println("a "+a);
		
		System.out.println("b "+b);
		
		System.out.println("a "+Call_Static_Non_Static.a);
		
		System.out.println("b "+Call_Static_Non_Static.b);
		
		Call_Static_Non_Static csns=new Call_Static_Non_Static(); 
	
		
		System.out.println("x "+csns.x);
		
		System.out.println("y "+csns.y);
		
		System.out.println("a "+csns.a);
		
		System.out.println("b "+csns.b);
//		System.out.println("x "+Call_Static_Non_Static.x);

	Call_Static_Non_Static cn=null;
		System.out.println("a "+cn.a);
		
		System.out.println("x "+cn.x);
		
	
	}
}
