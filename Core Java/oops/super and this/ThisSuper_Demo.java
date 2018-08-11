class Super_Class
{
	Super_Class(){
		this(12);
		System.out.println("Super class no arg");
	}
	Super_Class(int a){
		this("Dheerendra");
		System.out.println("Super class int arg");
	}
	Super_Class(String s){
		
		System.out.println("Super class string arg");
	}
};

class Sub_Class extends Super_Class
{
	Sub_Class(){
		this(12);
		System.out.println("Sub class no arg");
	}
	Sub_Class(int a){
		this("Dheerendra");
		System.out.println("Sub class int arg");
	}
	Sub_Class(String s){
		
		System.out.println("Sub class string arg");
	}
};


class ThisSuper_Demo 
{
	public static void main(String[] args) 
	{
		new Sub_Class();
	
		System.out.println("\n");
	
		new Sub_Class(12);
	
		System.out.println("\n");
	
	
		new Sub_Class("D
		");
	
		System.out.println("\n");
	
	}
}
