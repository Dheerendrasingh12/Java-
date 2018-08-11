import java.util.*;
class Factorial_Numeber 
{
		int f=1;
		int factorial(int no){
		
			if(no==0){
				return 1;
			}
			else{
			return (no*factorial(no-1));
			}
		}
	public static void main(String[] args) 
	{
	Scanner scn=new Scanner(System.in);
	
		System.out.print("Enter number for factorial ");
		int no=scn.nextInt();	
		Factorial_Numeber fn=new Factorial_Numeber();
		int c=fn.factorial(no);
		System.out.println(c);
		}
}
