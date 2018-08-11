class DecimalToBinary
{
	public static int converter(int num)
	{
		int bin=0;
		while(num>0)
		{
			if(num%2!=0)
				bin++;
		
			num=num/2;
		}
	return bin;
	}
	
	public static void main(String []args)
	{
	System.out.println(converter(7));
	}
}