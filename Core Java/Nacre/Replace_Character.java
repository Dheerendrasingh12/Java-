import java.util.Scanner;
class Replace_Character
{
	public static void main(String[] args) 
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter String");
		String str=scn.nextLine();

		
		System.out.println("Enter Replace character");
		char ch=scn.next().charAt(0);

		int count=0;
		char[] ch1=str.toCharArray();

		for (int i=0;i<str.length() ;i++ )
		{
			if(ch==ch1[i])
				count++;
		}
		int k=0;
		char newch[]=new char[ch1.length-count];

		for(int j=0;j<newch.length;j++){
			if(ch!=ch1[j]){
				newch[k]=ch1[j];
				k++;
			}
		}
		String newstr=new String(newch);
		System.out.println(newstr);

	}
}
