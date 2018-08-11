class Compareto_CompareToIgnoreCase 
{
	public static void main(String[] args) 
	{
		String s1="d";
		String s2="d";
		String s3="D";

		System.out.println(s1.equals(s2));
		System.out.println(s1.compareTo(s2));
		System.out.println();

		System.out.println(s1.equals(s3));
		System.out.println(s1.compareTo(s3));

		System.out.println(s3.equals(s1));

		System.out.println(s3.compareTo(s1));

		System.out.println(s3.equalsIgnoreCase(s1));
		System.out.println(s3.compareToIgnoreCase(s1));
	
		String s4="Dheerendra";
		String s5="dHEERENDRA";

		System.out.println(s4.equals(s5));
		System.out.println(s4.compareTo(s5));

		System.out.println(s4.compareToIgnoreCase(s5));

		String s6="Dheerendrasingh";
		System.out.println(s4.compareTo(s6));
		System.out.println(s6.compareTo(s4));
		
		System.out.println(s5.compareTo(s6));
		System.out.println(s6.compareTo(s5));

		
	}
}
