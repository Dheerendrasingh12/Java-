import java.util.*;
public class Reverse_String 
{
	public static void main(String[] args) 
	{
	
		Scanner scn=new Scanner(System.in);
		
		System.out.println("Enter Name ");
		String name=scn.nextLine();
		String reverse="";
		for(int i=name.length()-1;	i>=0;		i--){
			reverse=reverse+name.charAt(i);

		}

		System.out.println("reverse String "+reverse);

		/*
		for(int i=name.length()-1;	i>=0;		i--){
			System.out.print(name.charAt(i));
		}*/
	
		/*char[] ch=name.toCharArray();
		System.out.println("user enter name "+name);
		for(int i=name.length()-1;	i>=0;	i--){
			System.out.print(ch[i]);
		
		}*/
		
		



	}
}
