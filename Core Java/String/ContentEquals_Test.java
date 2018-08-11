class ContentEquals_Test 
{
	public static void main(String[] args) 
	{
		String s1=new String("d");
		String s2=new String("d");
		StringBuffer sb1=new StringBuffer("d");

		System.out.println(s1.equals(s2));
		System.out.println(s1.contentEquals(s2));

		System.out.println(s1.equals(sb1));
		System.out.println(s1.contentEquals(sb1));
//		System.out.println(sb1.contentEquals(s1));

		System.out.println(s1==sb1);//
}
}
