class TypeConversion 
{
	public static void main(String[] args) 
	{
		byte b1=10;
		int i1=b1;

//		byte b2=i1;
		byte b22=(byte)i1;
//		int i=true;
//		int i=(int)true;	
		int i2=254;

		byte b3=(byte)i2;
		char ch1='d';
		int i3=ch1;

		int i4=99;
		char ch2=(char)i4;

		long l1=12;
		float f1=l1;

		long l2=(long)f1;
		System.out.println("b1 "+b1);
		System.out.println("i1 "+i1);
		System.out.println("b2 "+b22);
		System.out.println("b3 "+b3);
		System.out.println("ch1 "+ch1);
		System.out.println("i3 "+i3);
		System.out.println("ch2 "+ch2);
		System.out.println("i4 "+i4);
		System.out.println("l1 "+l1);
		
		System.out.println("f1 "+f1);

		System.out.println("l2 "+l2);
	
	}
}