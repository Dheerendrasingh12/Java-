class IndexLastOf_IndexOf 
{
	public static void main(String[] args) 
	{
		String s1="java Programming Language";
		System.out.println(s1.length());

		System.out.println(s1.indexOf('a'));
		System.out.println(s1.lastIndexOf('a'));

		System.out.println(s1.indexOf('A'));
		System.out.println(s1.lastIndexOf('A'));
		System.out.println(s1.indexOf("Program"));
		System.out.println(s1.lastIndexOf("Program"));

		System.out.println(s1.indexOf('a',5));
		System.out.println(s1.lastIndexOf('a',5));

		System.out.println(s1.indexOf('a',1));
		System.out.println(s1.lastIndexOf('a',1));
		System.out.println(s1.indexOf('a',0));
		System.out.println(s1.lastIndexOf('a',0));
		System.out.println(s1.indexOf('a',24));
		System.out.println(s1.lastIndexOf('a',24));
		System.out.println(s1.indexOf('a',30));
		System.out.println(s1.lastIndexOf('a',30));
		System.out.println(s1.indexOf('a',-5));
		System.out.println(s1.lastIndexOf('a',-5));

		String s2="javaDheerendraSingh";
		System.out.println(s2.indexOf("dheerendra"));

		String s3=s2.toLowerCase();
		System.out.println(s3.indexOf("dheerendra"));
		System.out.println(s2);

		System.out.println(s3);

	}
}
