interface Shape{
double pi=3.14;
void findArea();
} 


 class Rec implements Shape
{

void findArea(){
	System.out.println(pi);
	}
	public static void main(String[] args) 
	{
		System.out.println("Hello World!"+pi);
		Shape r=new Rec();
		r.findArea();	
	}
}
