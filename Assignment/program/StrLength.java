class StrLength
{
	public static void  checklength(String str)
	{
	int i=0;
	for(char c : str.toCharArray())
		i++;

	System.out.println("length of dtring is...."+i);
	}
	
	public static void main(String ...args)
	{
		checklength("Dheerendra");
	}
}