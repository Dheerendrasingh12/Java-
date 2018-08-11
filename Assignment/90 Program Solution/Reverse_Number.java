import java.util.*;
public class Reverse_Number 
{
	public static void main(String[] args) 
	{
	
		Scanner scn=new Scanner(System.in);
		
		System.out.println("Enter Number ");
		int no=scn.nextInt();
		int rev=0,a;
		while(no>0){
			a=no%10;
			rev=rev*10+a;
			no=no/10;
		}

		System.out.println("Reverse Number "+rev);
	}
}
