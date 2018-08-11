class A96
{
	void m1(Object obj){
	System.out.println("A Object");
	}
};
class B96 extends A96
{
	void m1(String str){
	System.out.println("B String");
	}
};
class MOL_Inheritance4 
{
	public static void main(String[] args) 
	{

		B96 b=new B96();
		b.m1(50);
		b.m1("d");
		System.out.println("Hello World!");
	
	
		A96 a=new B96();
		a.m1(50);
		a.m1("d");
	}
}
