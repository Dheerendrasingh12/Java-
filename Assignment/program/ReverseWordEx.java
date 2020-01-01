class ReverseWordEx
{
	public static void main(String ...args)
	{
		String str="hello dheerendra singh dhakad";
		str=" "+str;
		char ch[]=str.toCharArray();
		
		getReverse(ch);
		System.out.println(ch);
	}
	
	public static void getReverse(char ch[])
	{
		int n=ch.length;
		int st=0;
		
		for(int i=0 ; i<n ; i++)
		{
			if(ch[i]==' '  ) //&& i<0
			{	
				//reverse(ch , st , i-1);
				// start = i+1;
				i++;
				if(ch[i]>=97 && ch[i]<=122)
				ch[i]=(char)(ch[i]-32);
				
			}
			else if(i==n-1)
			{
				//reverse(ch , st ,i);
			}
		}
		
		//reverse(ch , 0 , n-1);
	}
	
	public static void reverse(char ch[] , int st , int end)
	{
		
		while(st<end)
		{
			swap(ch , st ,end);
			st++;
			end--;
		}
	}
	
	public static void swap(char ch[] , int st , int end)
	{
		char temp=ch[st];
		ch[st]=ch[end];
		ch[end]=temp;
	}
}
