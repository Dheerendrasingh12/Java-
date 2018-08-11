class Interrupted_MyThread extends Thread
{
	public void run(){
		try{
			for (int i=0;i<=100 ;i++ )
			{
				System.out.println("Lazy Thread");
				Thread.sleep(2000);
			}
		}catch(InterruptedException ie){
		System.out.println("i got interrupted");
		}
	}
}
