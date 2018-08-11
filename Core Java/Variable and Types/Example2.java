class  Example2
{
	static int a=32;
	static final int b=212;
	
	final int x=23;
	 int y=12;

	public static void main(String[] args) 
	{
		final int p=43;
		p=134;
		System.out.println(p);
		
		Example2 e2=new Example2();
		System.out.println(e2.x);
	}
}
