import java.util.*;
class Proj1_UserNameEmptyCheck
{
	public static void main(String[] args) 
	{
		
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter UserName ");
		String usn=scn.nextLine();
	
		if(usn.isEmpty()){
			System.out.println("User name it not Available");
			
		}
		else
		{
			String usn1=usn.trim();
			if(usn1.isEmpty()){
			System.out.println("User name it not Available");
			
			
			}
			else{
			System.out.println("username "+usn1);
		}
		
	}


	}
}
