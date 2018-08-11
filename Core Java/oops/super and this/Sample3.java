class Example3
{
	Example3(int a){
		System.out.println("1-param constructor");
	}
};
class Sample3 extends Example3
{
		Sample3(int a){

		super(12);
			System.out.println("Sample int param");
		}
	public static void main(String[] args) 
	{
		Sample3 s=new Sample3(12);

	}
}
