import java.util.Scanner;
class FindSame_Array 
{
	public static void main(String[] args) 
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter array size");
		int n=scn.nextInt();
		int[] a=new int[n];
		int[] b=new int[n];
		
		int count=0;
		System.out.println("Enter First array Value");
		
		for(int i=0;i<n;i++){
		a[i]=scn.nextInt();
		count++;
		}
		System.out.println("Enter Second array Value");
		
		for(int i=0;i<n;i++){
		b[i]=scn.nextInt();
		count++;
		}
		
		for(int i=0;	i<n;	i++){
			for(int j=0;j<n;j++)
			if(a[i]==b[j]){
			
				System.out.print(" Same" +a[i]);
			}else{
			
				System.out.print(" not Same" );

			}
			
			
			}
	}//main
}//clas
