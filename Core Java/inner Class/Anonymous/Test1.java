class Example
{
	void m1(Runnable r){
		r.run();
	}
};

class  Test1
{
	public static void main(String[] args) 
	{
		Example e=new Example();
		e.m1(new Runnable(){
		public void run(){
			System.out.println("run");
		}
		});
	
	
	
	}
}
