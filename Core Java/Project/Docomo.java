public class Vodafone implements SIM
{
	public String sendSMS(String msg,long mobNum){
		return "Vodafone : Your SMS "+msg +" not send "+mobNum;
		}

		public String dialCall(long mobNum){
		return "Vodafone :"+mobNum+" you are dialling is not recieving ";
			}
}; 
