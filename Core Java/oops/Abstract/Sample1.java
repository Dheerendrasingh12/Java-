abstract class  Example1

{
	static int a=10;
	int x=20;
	static {
		System.out.println("Example sb");
	
	}
	{
	
		System.out.println("NS Example");
	
	}
	Example1(){
	
		System.out.println("Example constructor");
	}
	static void m2(){
	
		System.out.println("ex static method");
	}

	 void m3(){
	
		System.out.println("ex non static method");
	}
	public static void main(String[] args) 
	{
		System.out.println("Example");

System.out.println("a "+a);
	m2();
//	Example1 ex=new Example1();
	}
}


class  Sample1 extends Example1

{
	static int a=30;
	int x=40;
	static {
		System.out.println("Sample sb");
	
	}
	{
	
		System.out.println("NS Sample");
	
	}
	Sample1(){
	
		System.out.println("Sample constructor");
	}
	static void m4(){
	
		System.out.println("sa static method");
	}
 void m1(){
	
		System.out.println("sa non static method");
	}
	
	 void m5(){
	
		System.out.println("sa non static method");
	}
	public static void main(String[] args) 
	{
		System.out.println("saample");

System.out.println("a "+a);
	m2();
	m4();
	System.out.println();

	Sample1 sa=new Sample1();
	sa.m1();
	sa.m3();

	sa.m5();
	}
}

