class All_String_Constructor{
	public static void main(String[] args){
	String s1=new String();
	System.out.println(s1);
	//String s2;
	//System.out.println(s2);

	String s2="Dheerendra";
	System.out.println(s2);
	String s3=new String(s2);
	System.out.println(s3);	
	
	String s4=new String("Singh");
	System.out.println(s4);

	String s5=s4;
	System.out.println(s5);
	
	char[] ch ={'D','s','K','S'};

	String s6=new String(ch);
	System.out.println(s6);

	char ch1[] = {'D','s','d','k','t'};
	String s7=new String(ch,1,2);
	System.out.println(s7);

	byte b[]={99,98,99,100};
	String s8=new String(b);
	System.out.println(s8);
	
	byte[] b1={101,99,100,105};
	//String s9=new String(b1,1,5);
	//System.out.println(s9);
	
	//String s11=new String(b1,-2,4);
//	System.out.println(s11);
//	String s12=new String(s12,1,-2);
	System.out.println("length "+s8.length());
	String s13=new String(b1,3,0);
	System.out.println(s13);
	System.out.println(s13.length());
	
	}
}