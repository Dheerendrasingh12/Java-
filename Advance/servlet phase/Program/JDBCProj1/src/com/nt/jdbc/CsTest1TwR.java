package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;



public class CsTest1TwR {
   private static final String CALL_PROCEDURE="{ CALL P_FIRST(?,?)}";
	public static void main(String[] args) {
		int no=0;
		int result=0;
		try(Scanner sc=new Scanner(System.in)){
			//read inputs
			if(sc!=null){
				System.out.println("Enter a number::");
				no=sc.nextInt();
			}//if
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
			//Establish the connection
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager")){
			//create CallableStatement object
			if(con!=null)
				try(CallableStatement cs=con.prepareCall(CALL_PROCEDURE)){
		        	//register OUT param with JDBC types
			      if(cs!=null)
				    cs.registerOutParameter(2,Types.INTEGER);
          			//set values to Query params
			         if(cs!=null)
				           cs.setInt(1, no);
           			//call PL/SQL Procedure
            			if(cs!=null)
			              	cs.execute();
                  			//Gather results from OUT params
			               if(cs!=null)
				             result=cs.getInt(2);
           			System.out.println("Square Value:::"+result);
		       }//try
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//main
}//class
