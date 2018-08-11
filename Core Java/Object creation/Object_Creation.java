import java.lang.*;
class Object_Creation{
	public static void main(String[] args)throws ClassNotFoundException,InstantiationException,IllegalAccessException{
		Class c1=Class.forName("Test");
		Test ts=(Test)c1.newInstance();
		ts.m1();
	  Constructor<Test> constructor = Test.class.getConstructor();
        Test tst = constructor.newInstance();
      	tst.m1();
	}
}