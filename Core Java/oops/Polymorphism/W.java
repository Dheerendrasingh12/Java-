class Example
{
	
};
class Sample extends Example
{
};
class W 
{
	void m1(Example e){
		System.out.println("Example arg");
	
	}
	void m1(Sample s){
		System.out.println("Sample arg");
	
	}
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	
		W w=new W();
		w.m1(new Example());
		w.m1(new Sample());
		//w.m1("D");
		w.m1(null);
		
		Example e1=new Example();
		Example e2=new Sample();
		Sample s1=new Sample();
		Example e3=null;
		Sample s2=null;
System.out.println();
		w.m1(e1);
		w.m1(e2);
		w.m1(s1);
		w.m1(e3);
		w.m1(s2);
	}
}