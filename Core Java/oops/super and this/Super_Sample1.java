class Super_Example1
{
	Super_Example1(){
	System.out.println("Example 0-param");
	}
	Super_Example1(int a){
	System.out.println("Example 1-param");
	}
};

class Super_Sample1 extends Super_Example1
{

	Super_Sample1(){
	System.out.println("Sample 0-param");
	}
	Super_Sample1(int a){
		super(12);
	System.out.println("Example 1-param");
	}

	public static void main(String[] args) 
	{
		Super_Sample1 sam=new Super_Sample1();
		Super_Sample1 sam1=new Super_Sample1(12);
	}
}
