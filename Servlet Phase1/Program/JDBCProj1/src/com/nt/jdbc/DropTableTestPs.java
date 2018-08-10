package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DropTableTestPs {
	 
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String tabName=null;
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter table name to drop::");
				tabName=sc.next();
			}
/*			//register jdbc driver
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 //establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
*/			 
				//register jdbc driver
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 //establish the connection
			 con=DriverManager.getConnection("jdbc:odbc:oradsn", "system","manager");

			 //create STatement object
			 if(con!=null)
				 ps=con.prepareStatement("drop table "+tabName);
			 //send and execute SQL query
			 if(ps!=null)
				 result=ps.executeUpdate();
			 //process the result
			System.out.println("result::"+result);
			 if(result==0)
				  System.out.println("Table not found to drop");
			 else
				 System.out.println("Table dropped");
		}//try
		catch(SQLException se){
			System.out.println("table not found to drop ");
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
		}//finally
	}//main
}//class
