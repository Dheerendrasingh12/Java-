class SplitString
{
	public static int replace(String str )
	{
		
		int sum=0 , num;
		String[] newString=str.split(" ");
		
		for(int i=0 ; i< newString.length ; i++)
		{
			
			try{
			
				num=Integer.parseInt(newString[i]);
				sum=sum+num;
			}			
		
		catch(Exception e){}
		}
		return sum;

	}

	public static void main(String []args)
	{
		System.out.println(replace("Dheerendra 20 10 30 ha 40"));
	}
}
