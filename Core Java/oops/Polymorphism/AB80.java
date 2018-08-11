class A80
{
	int x=m1();
	int m1(){
		System.out.println("A m1");
		return 50;
	}
};
class B80 extends A80
{
	int y=m1();
	int m1(){
		System.out.println("B m1");
		return 60;
	}
};
class AB80 
{
	public static void main(String[] args) 
	{
		B80 b=new B80();
		System.out.println("X : "+b.x);
		
		System.out.println("Y : "+b.y);
	}
}
