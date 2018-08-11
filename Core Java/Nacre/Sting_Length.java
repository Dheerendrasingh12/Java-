import java.util.Scanner;
class Sting_Length 
{
	public static void main(String[] args) 
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter String");
		String str=scn.nextLine();
		int count=0;
		for(char c : str.toCharArray())
			count++;

		System.out.println("length of  String "+count);

		}
}
