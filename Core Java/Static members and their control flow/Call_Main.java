class Call_Main
{
	static {
		System.out.println("Static block start");
		main(new String[0]);
		System.out.println("Static block end");
	}
	public static void main(String[] args) 
	{
		System.out.println("main");
	}
}
