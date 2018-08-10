package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class CsFxTest3 {
  private static final String  CALL_FX="{? = call   F_VIEW_DELETE_STUD_BY_NO(?,?)}";
	public static void main(String[] args) {
		int no=0;
		int count=0;
		//read inputs
		try(Scanner sc=new Scanner(System.in)){
			if(sc!=null){
				System.out.println("Enter student number::");
				no=sc.nextInt();
			}
		}//try
			catch(Exception e){
				e.printStackTrace();
			}
			//Establish the connection
			try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager")){
				//create CallableStatement if
				 if(con!=null)
					 try(CallableStatement cs=con.prepareCall(CALL_FX)){
						 //register OUT,RETURN parameters with JDBC types
						 if(cs!=null){
							 cs.registerOutParameter(1,OracleTypes.CURSOR); //return Param
							 cs.registerOutParameter(3,Types.INTEGER); // out param
						 }//if
						 //set values to IN params
						 if(cs!=null)
							 cs.setInt(2,no);
						 //execute PL/SQL function
						 if(cs!=null)
							 cs.execute();
						 //gather results from RETURN,OUT Params
						 if(cs!=null){
							 //get ResultSet from Return Param
							 try(ResultSet  rs=(ResultSet)cs.getObject(1)){
								 if(rs.next()){
									 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
								 }
								 else{
									 System.out.println("Record not found");
								 }
							 }//try
							 count=cs.getInt(3);
							 if(count==0)
								 System.out.println("Record not deleted");
							 else
								 System.out.println("Record deleted ");
						 }//if
					 }//try
			}//try
			catch(SQLException se){
				System.out.println("records not found");
				se.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}//main
}//class
