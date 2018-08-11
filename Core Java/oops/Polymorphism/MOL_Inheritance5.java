class A97
{

	void m1(String str){
	System.out.println("A String");
	}
};
class B97 extends A97
{
	
	void m1(Object obj){
	System.out.println("B- Object");
	}
};
class MOL_Inheritance5 
{
	public static void main(String[] args) 
	{

		B97 b=new B97();
		b.m1(50);
		b.m1("d");
		System.out.println("Hello World!");
	
	
		A97 a=new B97();
//		a.m1(50);
		a.m1("d");
	}
}
