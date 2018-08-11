import java.util.Scanner;
class Rcheck
{
	public static void main(String artgs[])
	{
		int ar[]={1 ,2, 2, 1 ,2 , 2 ,4};
		
		int a[]=new int[ar.length] ,count=0 , j=0;
		Scanner sc=new Scanner(System.in);
		
		int first=ar[0];
		for(int i = 0 ; i<ar.length ; i++ ,count++)
		{
			
			if(first==ar[i])
			{
				
				a[j]=count;
				j++;
				
			}
		}
		if(j!=1)
		{
		for(int i=0 ;i<j ;i++ )
		{
			System.out.print(a[i] +" ");
		}
		}
		else
			{System.out.println("there is no Duplicate element");}

	}
	
}


	
		