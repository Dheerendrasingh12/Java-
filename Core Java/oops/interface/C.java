interface i1{
	int a=10;
	int x=12;
	int y=30;
}

interface i2{
	int b=20;
	double x=20;
}


class  C implements i1,i2
{
	public static void main(String[] args) 
	{
		System.out.println("a: "+a);

		System.out.println("b: !"+b);


//			System.out.println(x);
    		//System.out.println(C.x);
//			System.out.println(x);

			System.out.println(i1.x);
			System.out.println(i2.x);
			System.out.println(y);	
	
	
			System.out.println(y);
			System.out.println(C.y);
			System.out.println(i1.	y);	
	
	
	}
}
