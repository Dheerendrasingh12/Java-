class Join_MyThread extends Thread 
{
	public void run()
	{
		for(int i=0;i<=12;i++){
		System.out.println("K");
	
		try{
			Thread.sleep(2000);

		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
	}
}
