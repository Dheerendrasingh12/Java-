import java.util.Scanner;
class Armstrong
{
	public static void check(int num1)
	{
		int num2=num1 , rem,sum=0;
		while(num1!=0)
		{
			rem=num1%10;
			sum=sum+rem*rem*rem;
			num1=num1/10;
		}
		if(num2==sum)
			{System.out.println("given no is Armstrong");}
		else
		{	System.out.println("Ginven no is not a Armstrong");}
		
	}
	public static void main(String ...args)
	{
		
	check(153);
	check(123);
	}
}