import java.util.Scanner;
class DemoExample
{
	private String girlName;
	public void setName(String name)
	{
		girlName=name;
	}
	public String getName()
	{
		return girlName;
	}
	public void show()
	{
		System.out.println("First name of girl is..." + getName());
	}
}
class Demo
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		DemoExample demoexample=new DemoExample();
		System.out.println("Enter first girl name");
		String firstGirl=sc.nextLine();
		demoexample.setName(firstGirl);

		demoexample.show();
		
	}
}