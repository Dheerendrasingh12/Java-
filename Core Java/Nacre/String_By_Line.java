import java.util.Scanner;
class String_By_Line 
{
	public static void stringInLine(String str){
		int length=str.length()-1;
		char[] ch=str.toCharArray();
		int sum=0;
		int temp=0;
		for (int i=0;i<str.length() ;i++ )
		{
			temp++;
			if((ch[i]==' ')|| (i==length)){
				for (int j=;j<=temp-1 ;j++ )
				{
					System.out.print(ch[j]);
				}
				System.out.println();
			}
			
		}
	
	}

	public static void main(String[] args) 
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter String ");
		String str=scn.nextLine();
		stringInLine(str);
	}
}
