class Ex
{
	int x=10;
	final int y=20;

	void m1(int x){
	System.out.println("Example n=m1");
	}
	final void m2(){
	System.out.println("Example n=m1");
	}
};


class Sa  extends Ex
{
	public static final void main(String[] args) 
	{
		System.out.println("Hello World!");
		Ex e=new Ex();
		e.x=50;
		//e.y=60;
		e.m1(10);
		e.m2();
	}
}
