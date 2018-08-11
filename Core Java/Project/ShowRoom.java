import java.util.*;
class ShowRoom
{
	private Bike[] bikes;
	private int bikeIndex;
	private static int bikeNum;
	private static Scanner scn;
	public Bike buy(){
		System.out.println("Customer Selecting bike");
		if(bikes==null || bikeIndex>=bikes.length){
			Factory bajaj=new Factory();
			bikes=bajaj.order(7);
			bikeIndex=0;
		
		}	
		Bike bike=bikes(bikeIndex);
	return bike;
	}
}
