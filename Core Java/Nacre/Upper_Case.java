import java.util.Scanner;
class Reverse_String 
{
	public static void main(String[] args) 
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter String");
		String str=scn.nextLine();
		char[] ch=str.toCharArray();
		char[] newch=new char[ch.length];
		for (int i=ch.length-1;i>=0 ;i-- )
		{

			for (int j=0;j<ch.length ;j++ )
			{
				newch[j]=ch[i];
			}
			
		}
		
		System.out.println(new String(newch));
	}	
}
