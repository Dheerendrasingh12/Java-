package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectTest10TWS {
  private static final String GET_DEPT_DETAILS_BY_NO="SELECT DEPTNO,DNAME,LOC FROM DEPT WHERE DEPTNO=?";
	public static void main(String[] args) {
		int dno=0;
		boolean flag=false;
	 // read inputs
		try(Scanner sc=new Scanner(System.in)){
			if(sc!=null){
				System.out.println("Enter Dept number::");
				dno=sc.nextInt();
			}//if
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
		
		//create JDBC connection object
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager")){
			 //create PReparedStatement object
			try(PreparedStatement ps=con.prepareStatement(GET_DEPT_DETAILS_BY_NO)){
			    	//set value to Query param
				   ps.setInt(1,dno);
				 //execute Query
				 try(ResultSet rs=ps.executeQuery()){
					 //process the ResultSet
					 while(rs.next()){
						 flag=true;
						 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(5));
					 }//while
					 if(flag==false){
						 System.out.println("Records not found");
					 }
				 }//try
				 /*catch(SQLException se){
					 se.printStackTrace();
				 }*/
			}//try
		/*	catch(SQLException se){
				se.printStackTrace();
			}*/
		}//try
		catch(SQLException se){
			System.out.println("hello");
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//main
}//class
