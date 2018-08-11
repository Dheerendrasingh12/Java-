import java.util.Scanner;

class FibonicSeries 
{

	static int n1=0,n2=1,n3=0;

	static void fibonicRecusrion(int no){
		  if(no>0){  
         n3 = n1 + n2;  
         n1 = n2;  
         n2 = n3;  
         System.out.print(" "+n3); 
        fibonicRecusrion(no-1);  
     }  
 }
	public static void main(String[] args) 
	{
		Scanner scn=new Scanner(System.in);
		int a=0,b=1;
		System.out.print("Enter number for fibonic ");
		int no=scn.nextInt();
		System.out.print(a+" "+b);
		
		int c=0;
		for(int i=0;	i<no-2;	i++)
		{
		c=a+b;
		System.out.print(" "+c);
		a=b;
		b=c;
		
		
		}

		System.out.println();

		System.out.println("Using recursion");
	System.out.print(n1+" "+n2);//printing 0 and 1  
	fibonicRecusrion(no-2);
		
	}
}
