package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
		Scanner sc=null;
		int no=0;
		String newName=null,newAddrs=null;
		Connection con=null;
		Statement st=null;
		String query=null;
		int result=0;
		try{
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter existing student number");
				no=sc.nextInt(); //gives 1001
				sc.nextLine();
				System.out.println("Enter new name for student::");
				newName=sc.nextLine();  // gives new raja
				System.out.println("Enter new addrss for student::");
				newAddrs=sc.nextLine(); //gives new hyd
			}
			//Convert input values as required for the  SQL Query
			newName="'"+newName+"'"; //gives 'new raja'
			newAddrs="'"+newAddrs+"'"; //gives 'new hyd'
			//register jdbc driver
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 //establish the connection
			 con=DriverManager.getConnection("jdbc:odbc:oradsn", "system","manager");
			 //create STatement object
			 if(con!=null)
				 st=con.createStatement();
			 //prepare SQL Query
			         //update student set sname='new raja', sadd='new hyd' where sno=101
			  query="update student set sname="+newName+", sadd="+newAddrs+" where sno="+no;
			  System.out.println(query);
			 //send and execute SQL Query in DB s/w
			  if(st!=null)
				  result=st.executeUpdate(query);
			  //process the reuslt
			  if(result==0)
				  System.out.println("record not found for updation");
			  else
				  System.out.println(result+"no.of record(s) updated");
		}//try
		catch(SQLException se){
			System.out.println("Record not inserted");
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
			  if(st!=null)
				  st.close();
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
