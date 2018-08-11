class A95
{
	void m1(float a){
	System.out.println("A float");
	}
};
class B95 extends A95
{
	void m1(int a){
	System.out.println("B int");
	}
	void m1(float a){
	System.out.println("B float");
	}
	void m1(long ch){
	System.out.println("B long");
	}
};
class MOL_Inheritance3 
{
	public static void main(String[] args) 
	{

		B95 b=new B95();
		b.m1(50);
		b.m1('d');
		b.m1(50L);
		System.out.println("Hello World!");
	
	
		A95 a=new B95();
		a.m1(50);
		a.m1('d');
		a.m1(50L);
	}
}
