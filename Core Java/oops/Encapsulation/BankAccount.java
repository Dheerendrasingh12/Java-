class BankAccount 
{	
	private double bal;

	public void setbalance(double bal){
		if(bal<=0){
		System.out.println("Do not enter -ve amount");
		}else{
			this.bal=bal;
		}
		}
		public double getBalance(){
			return bal;
		}
	
}
