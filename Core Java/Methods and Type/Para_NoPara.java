class Para_NoPara 
{
	static void m1(){
		System.out.println("m1");
	}

	
	static void m2(int a){
		System.out.println("m2"+a);
	}

	public static void main(String[] args) 
	{
		m1();
//		m1(50);
		//m2();
		m2(50);
		m2('d');
		m2((byte)254.34);


		System.out.println("Hello World!");
	}
}