class A5

{
	static int a=10;
	int x=10;
	static void m1(){
	System.out.println("A class m1");
	}
	void m2(){
	System.out.println("A m2");
	}
	void m3(){
	System.out.println("A m3");
	}
};
class B5 extends A5 
{
	
	static int a=50;
	int x=60;
	static void m1(){
		super.m1();
		A5.m1();
	System.out.println("B class m1");
	}
	void m2(){
	System.out.println("B m2");
		super.m2();
	}
		void m4(){
		System.out.println(super.a+ "  a "+a);
		System.out.println(super.x+" x"+x);
		super.m1();
		m1();
		super.m2();
		m2();
		}
	public static void main(String[] args) 
	{	B5 b=new B5();
		b.m4();

	}
}
