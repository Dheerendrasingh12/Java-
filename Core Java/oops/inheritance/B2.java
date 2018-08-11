class A2
{
	static int a=12;

	static {
			System.out.println("A SB");
			System.out.println("a "+a);
		//	System.out.println("b "+b);
			System.out.println("B "+B2.b);
		System.out.println("B "+B2.getB());
	}
};
class B2 extends A2 
{
	static int b=20;
	static {
				System.out.println("In B sb");
				System.out.println("a"+a);
				System.out.println("b "+b);
				System.out.println("b "+getB());
	}
	static int getB(){
		return b;
	}
	public static void main(String[] args) 
	{
		System.out.println("in b main");
		System.out.println("a "+a);
		
		System.out.println("b "+b);
	}
}
