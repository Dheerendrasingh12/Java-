class MyThread extends Thread
{
	public void run(){
		for(int i=0;i<=12;i++)
			System.out.println("Child Thread");
	}
}

class Not_Override_Run extends Thread
{

};

class Override_Run extends Thread
{
	public void run(){
			System.out.println("run");
	}
	public void run(int i){
		System.out.println("run(int i)");
	}

};