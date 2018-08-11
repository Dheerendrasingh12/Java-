import java.util.*;
public class Palindrom_String 
{
	public static void main(String[] args) 
	{
	
		Scanner scn=new Scanner(System.in);
		
		System.out.println("Enter String ");
		String name=scn.nextLine();

		String reverse="";

		for (int i=name.length()-1	;i>=0 ;i-- )
		{
			reverse=reverse+name.charAt(i);
		}
		
			if(reverse.equals(name)){
				System.out.println("Given String Is palindrom");
			
			}
			else
				System.out.println("Given String Is NOT palindrom");

	}
}
