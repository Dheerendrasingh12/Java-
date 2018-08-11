package com.nt.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AgeCalculatorApp {
  private static final String  GET_DOB_BY_NO="SELECT DOB FROM PERSON_TAB WHERE PID=?";
	public static void main(String[] args) {
		int no=0;
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		java.sql.Date sqdob=null;
		java.util.Date udob=null,sysDate=null;
		
		try{
			sc=new Scanner(System.in);
			if(sc!=null){
			   System.out.println("Enter Person ID:");
			   no=sc.nextInt();
			}
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create PreparedStatement object
			if(con!=null)
				ps=con.prepareStatement(GET_DOB_BY_NO);
			 //set param values
			 if(ps!=null)
				 ps.setInt(1,no);
			 //execute the Query
			 if(ps!=null)
				 rs=ps.executeQuery();
			 
			 if(rs!=null){
				 if(rs.next()){
					 sqdob=rs.getDate(1);
					 //Convert java.sql.Date class obj to java.util.Date class object
					 udob=(java.util.Date)sqdob;
					 //get System Date
					 sysDate=new java.util.Date();
					 System.out.println("Age of the person::"+(sysDate.getTime()-udob.getTime())/(1000.0f*60*60*24*365));
				 }//if
				 else{
					 System.out.println("record not found");
				 }//else
			 }//if
			 }//try
				catch(SQLException se){
					se.printStackTrace();
				}
				catch(ClassNotFoundException cnf){
					cnf.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally{
					//close jdbc objs
					try{
						  if(rs!=null)
							  rs.close();
						}
						catch(SQLException se){
							se.printStackTrace();
						}

					try{
					  if(ps!=null)
						  ps.close();
					}
					catch(SQLException se){
						se.printStackTrace();
					}
					try{
						  if(con!=null)
							  con.close();
						}
						catch(SQLException se){
							se.printStackTrace();
						}
					
					try{
						  if(sc!=null)
							  sc.close();
						}
						catch(Exception e){
							e.printStackTrace();
						}
				}//finally
		}//main
	}//class
