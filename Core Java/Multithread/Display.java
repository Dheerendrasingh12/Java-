class  Display
{
	public synchronized void wish(String name){
		for (int i=0;i<10 ;i++ )
		{
			System.out.println("Good Afternoon");
			try{
				Thread.sleep(3000);

			}catch(InterruptedException ie){
			
			}
			System.out.println(name);
		}
	}
}
