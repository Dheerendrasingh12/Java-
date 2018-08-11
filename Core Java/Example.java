class Example{
	
	int x=12;
	{
		System.out.println("Non block");
	}
	
	Example(int x)
	{
		System.out.println("Constructor block");
	}
	
	{
		System.out.println("non-Static block");
	}
	public static void main(String[] args){
		Example e=new Example(5);
	}
}