class A3
{
	int x=m1();

	int m1(){
		System.out.println(" A NON STATIC VARIABLE");
		return 10;

	}

	{
	System.out.println(" A NON STATIC Block");
	}
	A3(){
		System.out.println(" Constructor");
	}

};

class B3 extends A3 
{

	int y=m2();

	int m2(){
		System.out.println(" B NON STATIC VARIABLE");
		return 20;

	}

	{
	System.out.println(" B NON STATIC Block");
	}
	B3(){
		System.out.println(" B Constructor");
	}

	public static void main(String[] args) 
	{
		System.out.println("B main");
		B3 b1=new B3();
		System.out.println("\nB main x "+b1.x);
		System.out.println("\nB main y "+b1.y);
	}
}
