package com.nt.jdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*SQL> select * from userlist;

UNAME                PWD
-------------------- --------------------
ramesh               chari
raja                 rani
ravi                 ramesh
jani                 begum*/

/*CREATE OR REPLACE PROCEDURE P_AUTHENTICATION(U_NAME IN VARCHAR,
                                                                                                  PASS IN VARCHAR,
                                                                                                   RESULT OUT VARCHAR)
 AS
    CNT NUMBER;
BEGIN
    SELECT COUNT(*) INTO CNT FROM USERLIST  WHERE UNAME=U_NAME AND PWD=PASS;
   IF(CNT<>0) THEN
       RESULT:='Valid Crendials';
   ELSE
       RESULT:='InValid Crendials';
   END IF;
END;
/*/


public class  CsTest3{
	private static final String CALL_PROCEDURE="{ CALL P_AUTHENTICATION(?,?,?)}";
  public static void main(String[] args) {
	  String user=null,pwd=null;
	  //read inputs
	  try(Scanner sc=new Scanner(System.in)){
		  if(sc!=null){
			  System.out.println("Enter user name::");
			  user=sc.nextLine(); //gives  raja
			  System.out.println("Enter Password::");
			  pwd=sc.nextLine(); //gives  rani
		  }//if
	  }//try
	  catch(Exception e){
		  e.printStackTrace();
	  }
	  //establish the conenction
	  try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager")){
           if(con!=null)
        	   try(CallableStatement cs=con.prepareCall(CALL_PROCEDURE)){
        		     //register OUT params with JDBC types
        		      if(cs!=null)
        		    	  cs.registerOutParameter(3,Types.VARCHAR);
        		      //set values to IN params
        		      if(cs!=null){
        		    	  cs.setString(1,user);
        		    	  cs.setString(2,pwd);
        		      }
        		      //execute PL/SQL procedure
        		      if(cs!=null)
        		    	  cs.execute();
        		      //gather results from OUT params
        		      if(cs!=null)
        		    	  System.out.println(cs.getString(3));
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





