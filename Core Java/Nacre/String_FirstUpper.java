import java.util.Scanner;
class String_FirstUpper 
{
	public static void main(String[] args) 
	{
	Scanner scn=new Scanner(System.in);
	System.out.println("Enter String");
	String str=scn.nextLine();
	str=" "+str;
	
	String str1="";
	char[] ch=str.toCharArray();
	
	for(int i=0;i<ch.length;i++){
	
	if(ch[i]==' '){
		i++;
			if((ch[i]>=97) && (ch[i]<=122) ){
			ch[i]=(char)(ch[i]-32);
			
			}
	}
	str1=str1+ch[i];

	}
	System.out.println(str1);

	}
}
