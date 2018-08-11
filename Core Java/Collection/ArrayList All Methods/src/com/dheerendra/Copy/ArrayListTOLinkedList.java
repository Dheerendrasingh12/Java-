package com.dheerendra.Copy;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListTOLinkedList {

	public static void main(String[] args) {
		long time1=System.nanoTime();
		ArrayList<Object> al=new ArrayList<>();
		
		System.out.println("Al size "+al.size());
		System.out.println("Al elements  "+al);
		
		al.add("d");
		al.add(5);
		al.add(12);
		al.add("h");
		al.add(null);
		al.add(true);
		
		
		System.out.println("al size "+al.size());
		System.out.println("al elements "+al);
		
		long time2=System.nanoTime();
		
		System.out.println("Time Taken by "+(time2-time1));
	
		LinkedList<Object> ll=new LinkedList<>(al);
		
		System.out.println("ll size "+ll.size());
		System.out.println("ll elements "+ll);
		long time3=System.nanoTime();
		
		ll.add(2,"dheerendra");
		ll.add(4,"singh");
		ll.add("k");
		
		
		long time4=System.nanoTime();
		System.out.println("ll size "+ll.size());
		System.out.println("ll elements "+ll);
		al.clear();
		
		System.out.println("current al Element "+al);
		
		al.addAll(ll);
		System.out.println("arraylist elements "+al);
		
		System.out.println("time taken by linked list "+(time4-time3));
		
		
	
	}
}
