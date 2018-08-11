import java.util.Scanner;
class  ArmStrong_Number
{

	public int checkArmStrong(int no){
	int num=no,rem=0,sum=0;
	while(num!=0){
		rem=num%10;
		sum=sum+rem*rem*rem;
		num=num/10;
	
	}
	return sum;
	
	
	}
	public static void main(String[] args) 
	{
		Scanner scn=new Scanner(System.in);
		
		System.out.println("Enter Number");
		
		int no=scn.nextInt();
				
		ArmStrong_Number an=new ArmStrong_Number();
		int check=an.checkArmStrong(no);

		if(check==no)
			System.out.println("Number is armstrong "+no);
		else
			System.out.println("Number is not armstrong "+no);
		
		

	}
}
