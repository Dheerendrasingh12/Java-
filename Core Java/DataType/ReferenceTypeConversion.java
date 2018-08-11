class ReferenceTypeConversion 
{
	public static void main(String[] args) 
	{
		Object obj1=new Object();
		Object obj2 = new A();
		Object obj3=new B();
		Object obj4=new D();
		Object obj5=new D();

		A a1=new A();
		A a2= new B();
		A a3=new C();
		//A a4=new D();

		//B b1=new A();


		A ab=new B();
		System.out.println(ab instanceof Object);
		System.out.println(ab instanceof A);
		System.out.println(ab instanceof B);
		System.out.println(ab instanceof C);
	//	System.out.println(ab instanceof D);

	Object objb=new B();

		System.out.println(objb instanceof Object);
		System.out.println(objb instanceof A);
		System.out.println(objb instanceof B);
		System.out.println(objb instanceof C);
	//	System.out.println(objb instanceof D);

	
	}
}
