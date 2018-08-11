import mypack.Test;
import upack.*;
class PackageTest
{
	public static void main(String []args)
	{
		mypack.Test obj1 = new mypack.Test();
		upack.Test obj2 = new upack.Test();
		
		obj1.show();
		obj2.show();
	}
}
