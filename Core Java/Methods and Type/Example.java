class Example 
{
	
	void m3(){}
	void m4(){
	return;
	}
	void m5(){
//	return 12;
	return;
	}

/*	int m6(){
	}

	int m7(){
	return;
	}
*/

	int m8(){
	return 12;
	}


	int m9(){
	return 'd';
	}
	int m18(){
	return (int)12.12;
	}
/*	int m82(){
	return (int)true;
	}
*/

	static void m1(){
		System.out.println("m1");
	}
	
	 void m2(){
		System.out.println("m2");
	}
	public static void main(String[] args) 
	{
		m1();
		//m2();
		Example e=new Example();
		e.m2();
//		int x=m1();
//		System.out.println(m1());

	}
}
