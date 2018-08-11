class Example
{
	static int a=10;
	int x=20;
	void m1(){
	int p=30;
	final int q=40;

	new Thread(){
		void m1(){
			System.out.println(a);
			System.out.println(x);
			System.out.println(p);
			System.out.println();
		}
	};
	
	
	
	}
};



class Test4 
{
	public static void main(String[] args) 
	{

		Example e=new Example(){
		public void m1(){
			System.out.println("Anonymous overriding method m1");
			m2();
		}

		public void m2(){
			System.out.println("Anonymous own method m2");
		}
	};
		System.out.println("Hello World!");
	}
}
