package com.dheerendra.object;
public class CreateObject {
	  public static void main(String[] args) {
	    try {
	      Class cls = Class.forName("JBTClass");
	      JBTClass obj = (JBTClass) cls.newInstance();
	      JBTClass obj1 = (JBTClass) cls.newInstance();
	      System.out.println(obj);
	      System.out.println(obj1);
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    } catch (InstantiationException e) {
	      e.printStackTrace();
	    } catch (IllegalAccessException e) {
	      e.printStackTrace();
	    }
	  }
	}