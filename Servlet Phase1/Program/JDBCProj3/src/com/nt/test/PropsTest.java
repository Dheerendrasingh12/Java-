package com.nt.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropsTest {
	public static void main(String[] args) {
		Properties props=null;
		InputStream is=null;
		try{
			//Locate properties file..
			is=new FileInputStream("src/com/nt/commons/myfile.properties");
			//create Properties class obj
			props=new Properties();
			//load the content  of properties file into java.util.Properties class obj
			props.load(is);
			System.out.println("props data"+props);
			System.out.println("name key value::"+props.getProperty("person.name"));
		}//try
		catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//main
}//class
