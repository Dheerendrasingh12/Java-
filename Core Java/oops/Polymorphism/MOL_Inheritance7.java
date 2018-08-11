class A99
{

	void m1(Object str){
	System.out.println("A Object");
	}
	
};
class B99 extends A99
{
	
	void m1(Object obj){
	System.out.println("B- Object");
	}

	
	void m1(String str){
	System.out.println("B String");
	}

};
class MOL_Inheritance7 
{
	public static void main(String[] args) 
	{

		B99 b=new B99();
		b.m1(50);
		b.m1("d");
		System.out.println("Hello World!");
	
	
		A99 a=new B99();
		a.m1(50);
		a.m1("d");
	}
}
