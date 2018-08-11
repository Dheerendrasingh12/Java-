class First
{
	public static void main(String ...args)
	{
	String str="hello dheerendra singh dhakad";
	str=""+str;
	String cap="";

	char ar[]=str.toCharArray();
	for(int i = 0 ;i<str.length() ; i++)
	{
		char x=str.charAt(i);
		if(x==' ')
		{
			cap=cap+"";
			char y=str.charAt(i+1);
			cap=cap+Character.toUpperCase(y);
			i++;
		}
		else
		{
			cap=cap+x;
		}
	}
	
	System.out.println(cap);
}
}