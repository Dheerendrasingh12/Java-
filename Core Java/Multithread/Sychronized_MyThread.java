class Sychronized_MyThread extends Thread 
{
	Display d;
	String name;
	Sychronized_MyThread(Display d,String name){
		this.d=d;
		this.name=name;

	}
	public void run(){
		d.wish(name);
	}
}
