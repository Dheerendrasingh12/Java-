package com.dheerendra.arraylist;

import java.util.ArrayList;

public class Test02_ArrayListRemove1 {

	public static void main(String[] args) {
		ArrayList al=new ArrayList<>();
		for(int i=0;i<12;i++) {
			al.add(i*10);
		}
		al.remove(1);
		al.remove(3);
		System.out.println(al);
	}
}
