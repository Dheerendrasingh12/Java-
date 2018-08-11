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
		int j=0;
		for (int i=ch.length-1;i>=0 ;i-- )
		{

			
				newch[j]=ch[i];
				j++;
			
			
		}
		
		System.out.println(new String(newch));
	}	
}
