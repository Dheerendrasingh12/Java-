class Example4 
{
	static int a;
	
/*	static void m1(int x){
		a=x;*/
		static void m1(int a){
			a=a;
		System.out.println(a);
	}
	public static void main(String[] args) 
	{
		System.out.println(a);
		m1(12);
		System.out.println(a);
	}
}
