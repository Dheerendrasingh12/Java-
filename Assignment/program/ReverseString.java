class ReverseString
{
	public static void main(String ...arg)
	{
		String str="hello dheerendra singh chouhan is here";
		char[] ch=str.toCharArray();
		char[] newch=new char[ch.length];
		for(int i=ch.length-1,j=0 ;i>=0 ; i--,j++)
			newch[j]=ch[i];
		System.out.println(new String(newch));
	}
}
		