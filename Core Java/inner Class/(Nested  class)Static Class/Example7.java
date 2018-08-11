class Example7 
{
	static {
		System.out.println("Outer class is loaded");
	
	}
	Example7(){
		System.out.println("Outer class Constructor");
	
	}
	static class A
	{

	static {
		System.out.println("inner class is loaded");
	
	}
	A(){
		System.out.println("inner class Constructor");
	
	}
	static void m1(){
		System.out.println("inner class SM m1");
	
	}
	void m2(){
		System.out.println("inner class NSM m2");
	
	}
	public static void main(String[] args) 
	{
		System.out.println("inner class");
	//	Example7.m1();
		Example7 e=new Example7();
	//	e.m1();
	
	}
	};


	static void m3(){
		System.out.println("Outer class SM");
	
	}
	void m4(){
		System.out.println("Outer class NSM");
	
	}
	public static void main(String[] args) 
	{
		System.out.println("Outer class");
	//	A.m3();
		A a=new A();
	//	a.m4();

		
	
	}
}
