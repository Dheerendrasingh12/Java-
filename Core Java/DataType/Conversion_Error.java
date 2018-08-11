class Conversion_Error 
{

	public static void main(String[] args) 
	{
		int i=10;
	//	byte b2=i;	possible loss conversion
	byte b2=(byte)i;
	//byte b3=(int)i;plc
//	byte b3=(boolean)i; incompatible type

	int a=12;
	//byte b=a; plp

	byte b=(byte)a;
	//boolean bo=a;	incompatible
	//boolean bo=(boolean)a; incompatible 
	
	//byte b4=(short)a;	possible loss of conversion

	short s=(byte)a;

	byte b5=(byte)(short)a;

	int a1=1212;
	byte b6=(byte)a1;
	short s1=(short)a1;
	short s2=(short)(byte)a1;

	System.out.println(a1);
	System.out.println(b6);
	System.out.println(s1);
	System.out.println(s2);
	}
}
