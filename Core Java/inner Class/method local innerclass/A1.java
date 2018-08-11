class A1 
{
	static void m1(){
		//B b1=new B();
		class B
		{
			int x=12;
		};

		B b2=new B();
		System.out.println(b2.x);

	}

	static void m2(){
		//B b=new B();
	}
	public static void main(String[] args) 
	{
		m1();
		System.out.println("Hello World!");
	}
}
