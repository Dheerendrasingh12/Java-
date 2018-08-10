package com.nt.model;

import java.util.Random;

public class Rotator {
	private String[] images={"onlyvimal.jpg","peterengland.jpg","ramraj.jpg","raymond.jpg","siyarams.jpg"};
    private String[] links={"http://www.onlyvimal.co.in",
    		                                  "https://www.peterengland.com",
    		                                  "https://www.ramrajcotton.in",
    		                                  "https://www.raymond.in",
    		                                  "https://www.siyaram.com"
    		                                  };
       private int  index;
       
       public  int  getNextAdd(){
    	   Random rad=null;
    	     rad=new Random();
    	     index=rad.nextInt(5);
    	     return index;
       }
      public  String getImage(){
    	  return  images[index];
      }
      
      public  String getLink(){
    	  return links[index];
      }
   
}
