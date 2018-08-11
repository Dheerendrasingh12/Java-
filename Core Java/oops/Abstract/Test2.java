abstract class Rule 
{

abstract void m1();
abstract void m2();
}

 class Sample extends Rule
{
	void m1()
		{
	System.out.println("m1");
	}
	void m2()
		{
	System.out.println("Hello");
	}
};
class Test2
{
	public static void main(String...args){
		Rule r=new Sample();
		r.m1();
	}
};

