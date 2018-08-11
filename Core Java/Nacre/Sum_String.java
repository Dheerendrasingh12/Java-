import java.util.Scanner;

class Sum_String 
{
	public static void main(String[] args) 
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter String");
		String str=scn.nextLine();
		int sum=0,num;
		String[] splStr=str.split(" ");
			
			for (int i=0;i<splStr.length ;i++ )
			{
			
			try{
					num=Integer.parseInt(splStr[i]);
					sum=sum+num;
					
			}catch(Exception e){
			
			}

		}
		System.out.println(sum);


	}
}
