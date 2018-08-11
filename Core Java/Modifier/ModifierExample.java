//protected class ModifierExample 
//private class ModifierExample 
package p1;
public class ModifierExample 


{
	private int a=10;
			int b=12;
	protected int c=32;
	public int d=40;
	public static void main(String[] args) 
	{
		ModifierExample me=new ModifierExample();
		System.out.println("a "+me.a);
		System.out.println("b "+me.b);
		System.out.println("c "+me.c);
		System.out.println("d "+me.d);

	}
	void m4(){}
	public void m1(){}
	private void m2(){}
	protected void m3(){}
	
	public class A
	{
	}
	protected class B
	{
	}
	private class C
	{
	}
	class D
	{
	};

}
