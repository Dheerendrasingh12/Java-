package com.nt.jdbc;

import java.text.SimpleDateFormat;

public class BasicDateValuesTest {
	public static void main(String[] args) throws Exception{
		SimpleDateFormat sdf1=null;
		java.util.Date  ud1=null;
		java.sql.Date sqd1=null,sqd2=null;
		long ms=0;
		String s2=null;
		
		//Converting String date value to java.util.Date class object
		String s1="43-21-1980"; //dd-MM-yyyy
		sdf1=new SimpleDateFormat("dd-MM-yyyy");
		ud1=sdf1.parse(s1);
		System.out.println(ud1);
		//Converting java.util.Date class object  to java.sql.Date class object
		ms=ud1.getTime();
		sqd1=new java.sql.Date(ms);
		System.out.println(sqd1);
		
		// if given String  Date pattern is yyyy-MM-dd then it can be converted
		//directly to java.sql.Date class object with out converting to java.util.Date class object
		s2="2010-12-20";  // yyyy-MM-dd
		sqd2=java.sql.Date.valueOf(s2);
		System.out.println(sqd2);
		
		//Converting java.sql.Date class obj to java.util.Date class object
		java.util.Date ud2=(java.util.Date)sqd2;
		System.out.println("util date::"+ud2);
		// Converting java.util.Date class obj to String date value
		SimpleDateFormat sdf2=new SimpleDateFormat("MMM-yyyy-dd");
		String s3=sdf2.format(ud2);
		System.out.println("String date::"+s3);
		
		
		
		
		
		
	}

}
