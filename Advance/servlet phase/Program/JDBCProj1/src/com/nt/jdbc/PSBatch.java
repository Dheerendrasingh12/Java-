package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PSBatch {
   private static   final String STUDENT_INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?)";  
	public static void main(String[] args) {
		 int result[]=null;
		 int sum=0;
		   //establish the connection
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager")){
			    //create PreparedStatement
			   try(PreparedStatement ps=con.prepareStatement(STUDENT_INSERT_QUERY)){
				     //set values to query params vlaues to batch
				    if(ps!=null){
				    	ps.setInt(1, 38);
				    	ps.setString(2,"raja");
				    	ps.setString(3,"hyd");
				    	ps.addBatch();
				    	
				    	ps.setInt(1, 39);
				    	ps.setString(2,"rajesh");
				    	ps.setString(3,"vizag");
				    	ps.addBatch();
				    }
				    //execute the Batch
				    if(ps!=null)
				    	result=ps.executeBatch();
				    //process the result
				    if(result!=null){
				    	for(int i=0;i<result.length;++i){
				    	  sum=sum+result[i];
				    	}//for
				    }//if
				    System.out.println("no.of records that effected"+sum);
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
