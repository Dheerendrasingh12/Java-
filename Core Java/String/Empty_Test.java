import java.util.*;
public class Empty_Test 
{

	public static void main(String[] args) 
	{
		String s1="";
		System.out.println("is s1 empty :"+s1.isEmpty());

		String s2=" ";
		System.out.println("is is empty :"+s2.isEmpty());
	
		String s3="d";
		System.out.println("is is empty :"+s3.isEmpty());		
		String s4=new String();
		System.out.println("is is empty :"+s4.isEmpty());

		String s5=new String("");
		System.out.println("is is empty :"+s5.isEmpty());
		String s6=new String(" ");
		System.out.println("is is empty :"+s6.isEmpty());
		String s7=new String("d");
		System.out.println("is is empty :"+s7.isEmpty());

		String s8=null;

//		System.out.println("is is empty :"+s8.isEmpty());

		String s9;
//		System.out.println("is is empty :"+s9.isEmpty());

		Scanner scn=new Scanner(System.in);
		System.out.println("\nEnter String 1:");
		System.out.println(scn.nextLine().isEmpty());

		System.out.println("\nEnter String 2:");
		System.out.println(scn.nextLine().isEmpty());
	
		System.out.println("\nEnter String 1:");
		System.out.println(scn.nextLine().isEmpty());



			
	}
}
