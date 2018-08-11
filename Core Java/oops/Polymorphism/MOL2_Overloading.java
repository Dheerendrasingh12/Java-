class CalleeImpl
{
	public void foo(Object o){
		System.out.println("Object PARAM");
	}

	
	public void foo(String str){
		System.out.println("String PARAM");
	}
	
	public void foo(Integer i){
		System.out.println("Integer PARAM");
	}
};
class MOL2_Overloading 
{
	public static void main(String[] args) 
	{
		CalleeImpl cal=new CalleeImpl();
		Object obj1=new Object();
		Object obj2="Dheerendra";
		
		Object obj3=new Integer(12);
		
		cal.foo(obj1);
		cal.foo(obj2);
		cal.foo(obj3);
		
		cal.foo("Dheerendra");
		cal.foo(12);
		cal.foo(obj3);
		

		cal.foo((String)obj2);
		cal.foo((Integer)obj3);
		cal.foo(obj3);

		
		
 		cal.foo((String)obj1);
		cal.foo((Integer)obj1);
		cal.foo((String)obj3);
		cal.foo((Integer)obj3);

		
		
		
		
	}
}
