class RemoveCharacterExample
{
	public static String replace(String str , char c)
	{
		char[] ch=str.toCharArray();
		int count=0;
		for(int i=0 ; i<str.length() ; i++)
		{
			if(ch[i]==c)
			{
				count++;
			}
		}
		char[] newCh=new char[ch.length-count];
 
		for(int i=0 , j=0 ; i<ch.length ; i++ , j++)
		{	
			if(c==ch[i])
			{
				i++;
			}
			newCh[j]=ch[i];
			
		}
		
		String newString=new String(newCh);
		return newString;

	}

	public static void main(String []args)
	{
		System.out.println(replace("Anand" , 'n'));
	}
}