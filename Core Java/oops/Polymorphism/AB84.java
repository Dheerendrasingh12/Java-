class A84
{
	static int x=m1();
	 static int m1(){
		System.out.println("A m1");
		x=50;
		return 60;
	}
};
class B84 extends A84
{
static	int x;
	 static int m1(){
		System.out.println("B m1");
		x=70;
		return 80;
	}
};
class AB84
{
	public static void main(String[] args) 
	{
		B84 b=new B84();
		A84 a=b;
		System.out.println("X : "+b.x);
		
		System.out.println("x a: : "+a.x);
	}
}
