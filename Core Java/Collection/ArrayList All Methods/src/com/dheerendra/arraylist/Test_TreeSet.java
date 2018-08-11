package com.dheerendra.arraylist;

import java.util.TreeSet;

public class Test_TreeSet {
	public static void main(String[] args) {
		TreeSet<Object> ts1=new TreeSet<>();
		
		ts1.add("a");
		ts1.add("c");
		ts1.add("b");
		System.out.println("First  "+ts1);

		
		TreeSet<Object> ts2=new TreeSet<>();
		ts2.add(5);
		ts2.add(7);
		
		System.out.println("Second "+ts2);
	
	/*	TreeSet<Object> ts3=new TreeSet<>();
		
		ts3.add(new StringBuffer("a"));
		ts3.add(new StringBuffer("b"));
		ts3.add(new StringBuffer("c"));
		
		System.out.println("Third "+ts3);
	
	*/
	
		TreeSet<Object> ts4=new TreeSet<>();
		
		ts4.add("a");
		ts4.add(null);
		
		System.out.println(ts4);
	
	
	}
}
