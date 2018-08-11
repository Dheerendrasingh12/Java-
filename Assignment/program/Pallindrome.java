import java.util.Scanner;
class Pallindrome
{
	public static void check(int num1)
	{
		int num2=num1 , rem,sum=0;
		while(num1!=0)
		{
			rem=num1%10;
			sum=sum*10+rem;
			num1=num1/10;
		}
		if(num2==sum)
			{System.out.println("given no is pllindrome");}
		else
		{	System.out.println("Ginven no is not a pallindrome");}
		
	}
	public static void main(String ...args)
	{
		
	check(151);
	check(123);
	}
}