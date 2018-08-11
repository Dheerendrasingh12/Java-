class A6
{
	int x=10;
	void m1(){
		System.out.println(this.x);
		
	//	System.out.println(super.x);
	}
};
class B6 extends A6
{
	
	int x=20;
	void m1(){
		System.out.println(this.x);
		
		System.out.println(super.x);
	}
	public static void main(String[] args) 
	{
		
	}
}
