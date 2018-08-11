class A18
{
	static int a=10;
	int x=20;
	static void m1(){
		System.out.println("A m1");
	}
	void m2(){
		System.out.println("A m2");
	}
	void m3(){
		System.out.println("A m3");
		System.out.println("A a "+a);
		System.out.println("A x "+x);
	}
};

class B18 extends A18
{
	static int a=50;
	int x=60;
	static void m1(){
		System.out.println("B m1");
	}
	void m2(){
		System.out.println("B m2");
		System.out.println("B a "+a);
		System.out.println("B x "+x);
	}
	void m4(){
		super.a=a-10;
		super.x=x-10;
	}
};
class AB18 
{
	public static void main(String[] args) 
	{
		B18 b1=new B18();
		B18 b2=new B18();
		A18 a1=new B18();
		b1.a=15;
		b1.x=16;
		b2.a=18;
		b2.x=19;
		b1.m2();

		b1.m4();
		b1.m2();
		b2.m4();

		b1.m3();
		System.out.println();
		b2.m3();

		
		System.out.println(b1.a);

		System.out.println(a1.a);

		System.out.println(b1.x);

		System.out.println(a1.x);

	}
}
