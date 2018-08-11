class A17
{
  static	void m1(){
		System.out.println("A m1()");
	}
	
	static void m2(){
		System.out.println("A m2()");
		m1();
	}
};

class B17 extends A17
{
	
	static	void m1(){
		System.out.println("B m1()");
	}
	
	void m3(){
		System.out.println("B m3()");
		m1();
		super.m2();
	}
};
class C17 extends B17
{
	
	
static	void m2(){
		System.out.println("C m2()");
	//	m4();
	}
};
class D17 extends C17 
{
	
static	void m1(){
		System.out.println("D m1()");
	}
	
static	void m2(){
		System.out.println("D m2()");
		
	}
static	void m4(){
		System.out.println("D m4()");
		
	}
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		D16 d=new D16();
		d.m1();
		d.m2();
		d.m3();
		d.m4();
	}
}
