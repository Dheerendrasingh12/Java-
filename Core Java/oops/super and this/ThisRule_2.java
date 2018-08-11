class ThisRule_2 
{
	ThisRule_2(){
	this(10);
	System.out.println("No-param");
	}
	
	ThisRule_2(int a){
	super();
	this("dheerendra");

	System.out.println("int-param");
	}
	ThisRule_2(String s){

	System.out.println("String-param");
}
	

	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
