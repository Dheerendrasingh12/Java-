class Sample91
{
	Sample91(){
		this(10);
		System.out.println("Sa no arg constructor");
	}
	
	Sample91(int a){
		this("Dheerendra");
		System.out.println("Sa int arg constructor");
	}
	Sample91(String str){
		
		System.out.println("Sa string arg constructor");
	}

	public static void main(String...args){
	Sample91 s1=new Sample91();
	Sample91 s2=new Sample91("Dheerendra");
	Sample91 s3=new Sample91~W(12);
	}
}