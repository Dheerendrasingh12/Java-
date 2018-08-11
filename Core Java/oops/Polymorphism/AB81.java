class A81
{
	int x=m1();
	static int m1(){
		System.out.println("A m1");
		return 50;
	}
};
class B81 extends A81
{
	int y=m1();
	 static int m1(){
		System.out.println("B m1");
		return 60;
	}
};
class AB81 
{
	public static void main(String[] args) 
	{
		B81 b=new B81();
		System.out.println("X : "+b.x);
		
		System.out.println("Y : "+b.y);
	}
}
