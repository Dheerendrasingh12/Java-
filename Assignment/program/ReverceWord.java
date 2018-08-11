class ReverceWord
{
	public static void main(String ...arg)
	{
		String str="hello dheerendra singh "; //output str="olleh ardnereehd hgnis "
		

		int strlength=str.length()-1;
		String reverse="" , temp="";
	
		for(int i=0 ; i<=strlength ; i++)
		{
			temp=temp+str.charAt(i);
			
			if(str.charAt(i)==' ' || i==strlength)
			{
				for(int j=temp.length()-1 ; j>=0 ; j--)
				{
					reverse=reverse+temp.charAt(j);
					if(j==0 && i!=strlength)
						reverse=reverse+" ";
				}
				temp="";
			}
		}
		System.out.println(reverse);
				
		
	}
}
			
			
	