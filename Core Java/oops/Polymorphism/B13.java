class A13
{
	//static void m1()
	void m1()	
	{
	
	System.out.println("A m1");
	}
	
	 void m2(){
	
	System.out.println("A m2");
	m1();
	}
};

class B13 extends A13 
{
	
	 void m1(){
	
	System.out.println("B m1");
	}
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		B13 b1=new B13();
		b1.m1();
		b1.m2();

		A13 a=new B13();
		a.m1();
		a.m2();
	}
}
