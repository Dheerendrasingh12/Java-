class A82
{
	int x=m1();
	 int m1(){
		System.out.println("A m1");
		x=50;
		return 60;
	}
};
class B82 extends A82
{
	int x;
	 int m1(){
		System.out.println("B m1");
		x=70;
		return 80;
	}
};
class AB82 
{
	public static void main(String[] args) 
	{
		B82 b=new B82();
		A82 a=b;
		System.out.println("X : "+b.x);
		
		System.out.println("x a: : "+a.x);
	}
}