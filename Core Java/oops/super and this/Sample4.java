class Example4
{
	private Example4(){
			System.out.println("Example4-0-param");
	}
	Example4(int a){
		System.out.println("Example4-1-param");
	}
};
class Sample4 extends Example4
{
	Sample4(){
		super(12);
		System.out.println("Sample4-0-param");
	}
	public static void main(String[] args) 
	{
		Sample4 s=new Sample4();

	}
}
