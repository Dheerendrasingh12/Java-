class Super_Example
{
	Super_Example(){
	System.out.println("Example 0-param");
	}
	Super_Example(int a){
	System.out.println("Example 1-param");
	}
};

class Super_Sample extends Super_Example
{

	Super_Sample(){
	System.out.println("Sample 0-param");
	}
	Super_Sample(int a){
	System.out.println("Example 1-param");
	}

	public static void main(String[] args) 
	{
		Super_Sample sam=new Super_Sample();

	}
}