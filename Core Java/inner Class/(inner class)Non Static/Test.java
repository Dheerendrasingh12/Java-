class Sample1 
{
	class B
	{
		void m1(){
			System.out.println("B m1");
		}
	};

	void m2(){
		B b=new B();
		b.m1();
	}
	public static void main(String[] args) 
	{
//		B b=new B();
	Sample1 s=new Sample1();
	s.m2();
		Sample1.B sam=new Sample1().new B();
		System.out.println("Hello World!");
	
		sam.m1();
	}
}

class Test
{
	public static void main(String[] args) 
	{
		//B b=new B();
		Sample1.B b1=new Sample1().new B();
		b1.m1();
		Sample1 s=new Sample1();
		Sample1.B b2=s.new B();
		b2.m1();

			
		}
};
