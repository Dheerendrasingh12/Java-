class Test2
{
	static void m3(Example e){
	e.m1();
	if(e instanceof Sample){
		Sample s=(Sample)e;
		s.m2();
	}
	}


	public static void main(String[] args) 
	{
		Test1.m3(new Sample());

		Test1.m3(new Example());
	}
}
