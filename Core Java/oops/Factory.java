class Factory 
{
	public static void main(String[] args) 
	{
		Bike ktm=new Bike("D1212","Red");
		Bike jupiter = new Bike("K0303","Love");

		ktm.setOwnerName("Dheerendra SIngh");
		ktm.setBikeNum("DL 12 DS 1212");
		jupiter.setOwnerName("K");
		jupiter.setBikeNum("MP 09 KT 0303");

		jupiter.start();
		jupiter.move();
		jupiter.stop();
	}
}
