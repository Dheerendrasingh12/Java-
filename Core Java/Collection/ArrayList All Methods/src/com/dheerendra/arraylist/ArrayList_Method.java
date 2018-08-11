package com.dheerendra.arraylist;

import java.util.ArrayList;

public class ArrayList_Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al=new ArrayList<>();
		System.out.println("al size "+al.size());
		System.out.println("al elements "+al);
		System.out.println();
		
		al.add(12);
		al.add(3);
		al.add("d");
		al.add("m");
		al.add(24.12);
		al.add(null);
		al.add(null);
		al.add("d");
		
		al.add(78);
		al.add(60);
		al.add(96);
		al.add("Dheerendra");
		
		System.out.println("al size "+al.size());
		System.out.println("al elements "+al);
		
		System.out.println(al.get(4));
		for(int i=0;	i<al.size();	i++) {
			
			System.out.println(al.get(i));
		}
		Object obj=al.get(1);
		System.out.println("1 index "+obj);
		
		
		System.out.println("al contains "+al.contains(12));
		System.out.println("is \"d\" availabel "+al.contains("d"));
		System.out.println("is \"D\" is available "+al.contains("D"));
	
	
			System.out.println("12 position "+al.indexOf(12));
			System.out.println("\"d\" position "+al.indexOf("d"));
			System.out.println("\"D\" position "+al.indexOf("D"));
			System.out.println("is \"d\" position "+al.lastIndexOf("d"));
			
			al.remove("d");

			System.out.println("al size "+al.size());
			System.out.println("al elements "+al);
			
			
			al.set(3, "h");

			System.out.println("al size "+al.size());
			System.out.println("al elements "+al);
			
			al.add(7, false);

			System.out.println("al size "+al.size());
			System.out.println("al elements "+al);
			
			
			Object obj1=al.set(8, "E");

			System.out.println("al size "+al.size());
			System.out.println("al elements "+al);
	
				al.add(obj1);

				System.out.println("al size "+al.size());
				System.out.println("al elements "+al);
				
				
			
	}

}
