//input a[]={4,7,8,9,2,1}

//find min value and max v alue


public class Min_Max{

	public static void main(String... args){
	int[] a={4,7,8,9,2,1};
	//System.out.println(a);
	int temp=a[0];
	for(int i=0;i<a.length; i++){
	if(a[i]<temp)
		temp=a[i];
	
	
	}
	System.out.println(" minimum value"+temp);
	
	for (int i=0;i<a.length ;i++ )
	{
		if(a[i]>temp)
			temp=a[i];
	}
	System.out.println("Maximum value "+temp);
	
	}
}