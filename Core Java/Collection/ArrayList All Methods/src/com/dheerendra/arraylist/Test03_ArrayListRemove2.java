package com.dheerendra.arraylist;

import java.util.ArrayList;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_COLOR_BURNPeer;

public class Test03_ArrayListRemove2 {

	public static void main(String[] args) {
		ArrayList al = new ArrayList<>();
		al.add("d");
		al.add(12);
		al.add(21.23);
		al.add('s');
		al.add(96l);
		al.add(true);
		al.add(null);
		al.add(new StringBuffer("DS"));

		System.out.println(al);

		al.remove(5);
		System.out.println(al);

		al.remove("d");
		System.out.println(al);
		//al.remove('s');
	//	al.remove(new Integer(12));
		System.out.println(al);
	//	al.remove(12);
		al.remove(new Character('b'));
		al.remove(true);
		al.remove((char)'s');
	
	}
}
