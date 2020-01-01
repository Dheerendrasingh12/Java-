class Upper
{
	public static void main(String ...args)
	{
		String str="hello dheeReNdra singh";
			char ch[]=str.toCharArray();
		for(int i=0 ; i<str.length() ; i++)
		{			
			if((ch[i]>=65) && (ch[i]<=90))
			{	ch[i]=(char)(ch[i]+32);}
			else if((ch[i]>=97) && (ch[i]<=122))
				{ch[i]=(char)(ch[i]-32);}	
		}
		System.out.println(new String(ch));
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		
	}
}
