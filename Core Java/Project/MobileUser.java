import java.io.*;

public class MobileUser 
{
	public static void main(String[] args) throws Exception
	{
		Mobile iphone=new Mobile();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Insert Sim ");
		String simName=br.readLine();

		iphone.insert(simName);

		System.out.println();

		System.out.println("Type 1 and press <Enter> key to Send SMS");
	
	
		System.out.println("Type 2 and press <Enter> key to Make Call\n");
		
		
		System.out.println("Enter Option ");
		String option = br.readLine();

		String resp;

		if(option.contains("1")){
		
		System.out.println("Type message and press <Enter> key ");
		String msg=br.readLine();
		
		System.out.println("Type mobile number and press <Enter> key\n");

		String mobNum=br.readLine();

		resp=iphone.sendSMS(msg,Long.parseLong(mobNum));
		System.out.println(resp);
		
		
		}else if(option.contains("2")){
		
		
		System.out.println("Type mobile number and press <Enter> key\n");

		String mobNum=br.readLine();

		resp=iphone.dialCall(Long.parseLong(mobNum));
		System.out.println(resp);
			
		}
		else {
			System.out.println("");
		}

	}
   rothe}
