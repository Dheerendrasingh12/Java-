import java.util.*;


class Proj2_MobileVerify 
{
	public static void main(String[] args) 
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter Mobile Number");

		String no=scn.nextLine();

		if(no.length()==10){
			try{
				long mn=Long.parseLong(no);
				System.out.println("Valid Mobile Number");
			}
			catch(Exception e){
				System.out.println("Enter only digit");
				

			}
		
		}else{
			System.out.println("Invalid Number");
		}

	}
}
