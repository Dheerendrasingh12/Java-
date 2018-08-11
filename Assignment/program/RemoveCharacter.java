class RemoveCharacter
{
	public static String replace(String src , char c)
	{
		char ch[]=src.toCharArray();
		int count=0;
		for(int i=0 ; i<ch.length ; i++)
			if(c==ch[i])
				count++;
		
		char newch[]=new char[ch.length-count];
		int j=0;
		for(int i =0 ; i<ch.length ; i++)
		{
			if(c!=ch[i])
			{
				newch[j]=ch[i];
				j++;
			}
		}
		String newString = new String(newch);
		return newString;
	}
	public static void main(String ...args)
	{
		System.out.println(replace("dheerendra" , 'e'));
	}
}