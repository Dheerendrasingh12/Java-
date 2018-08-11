class Eg11
{
	public static void stringDivide(String str)
	{
		
		String [] strString=str.split(" ");
		int sum=0;
		
		for(int i=0 ; i<strString.length ; i++)
		{

			char[] strChar=strString[i].toCharArray();
			System.out.println(strChar);
				
			
		}
		System.out.println(sum);	
	}

	public static void main(String []args)
	{
		stringDivide("dheerendra 11 Singh 33 chouhan 44");
	}
}