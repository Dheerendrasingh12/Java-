class Assign_static_variable 
{
	static int a=12;
	public static void main(String[] args) 
	{
		int a=124;
		a=a;
		System.out.println(a);
		Assign_static_variable.a=a;
		System.out.println(Assign_static_variable.a);
		
		System.out.println(a);
	}
}