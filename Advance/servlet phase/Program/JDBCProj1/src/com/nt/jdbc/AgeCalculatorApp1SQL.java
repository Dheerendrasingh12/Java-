package com.nt.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AgeCalculatorApp1SQL {
  private static final String  GET_AGE_BY_NO="SELECT (SYSDATE-DOB)/365 FROM PERSON_TAB WHERE PID=?";
	public static void main(String[] args) {
		int no=0;
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
	
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
				ps=con.prepareStatement(GET_AGE_BY_NO);
			 //set param values
			 if(ps!=null)
				 ps.setInt(1,no);
			 //execute the Query
			 if(ps!=null)
				 rs=ps.executeQuery();
			 
			 if(rs!=null){
				 if(rs.next()){
					 System.out.println("Age of the person::"+rs.getFloat(1));
					// System.out.println("Age of the person::"+rs.getFloat("(SYSDATE-DOB)/365"));
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
