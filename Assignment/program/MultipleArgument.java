class MultipleArgument
{
	public static void main(String ...args)
	{
		int ch=1;
		switch((ch) , (ch+1))
		{
		case 1:
			System.out.println("Hi");
			break;
		case 2:
			System.out.println("Hello");
			break;
		default:
			System.out.println("wrong input");
		}
	}
}