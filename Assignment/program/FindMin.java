class FindMin
{
	public static int fin(int ar[])
	{
	int min=ar[0];
	for(int i=0 ;i<ar.length ; i++)
	{
		if(ar[i]< min)
			min=ar[i];	
	}
	return min;
	}
	public static void main(String ...args)
	{
		int ar[]={2,5,3,7,2,4,1,7};
		System.out.println(fin(ar));
	}
}