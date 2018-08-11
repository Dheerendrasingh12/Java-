class A98
{

	void m1(String str){
	System.out.println("A String");
	}
	
	void m1(Integer itr){
	System.out.println("A Integer");
	}
};
class B98 extends A98
{
	
	void m1(Object obj){
	System.out.println("B- Object");
	}

	
	void m1(String str){
	System.out.println("B String");
	}
	
	void m1(Integer itr){
	System.out.println("B Integer");
	}

};
class MOL_Inheritance6 
{
	public static void main(String[] args) 
	{

		B98 b=new B98();
		b.m1(50);
		b.m1("d");
		System.out.println("Hello World!");
	
	
		A98 a=new B98();
		a.m1(50);
		a.m1("d");
	}
}
