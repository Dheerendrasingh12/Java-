class A2 
{
	B m1(){
		class B
		{
			void m3(){
				System.out.println("B m3");
			}
		};
	
	B b=new B();
	m2(b);
	return b;

	}
	void m2(B b){
		b.m3();
	}

}
