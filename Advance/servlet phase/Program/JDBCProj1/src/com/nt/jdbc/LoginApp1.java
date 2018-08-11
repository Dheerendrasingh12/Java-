package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginApp1 {

	public static void main(String[] args) {
		Scanner sc=null;
		String user=null;
		String pass=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		int count=0;
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null){
			  System.out.println("Enter Username:::");
			  user=sc.nextLine(); //gives raja
			  System.out.println("Enter Password");
			  pass=sc.nextLine(); //gives rani
		  }
			//Convert input values as required for the SQL Query
			user="'"+user+"'"; //gives 'raja'
			pass="'"+pass+"'"; //gives 'rani'
			
			//reggister Driver
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 //establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			 //create Statement object
			 if(con!=null)
				 st=con.createStatement();
			 //prepare SQL Query
			 query="select count(*) from userlist where pwd="+pass+" and uname="+user;
			 System.out.println(query);
			 //send and execute SQL Query in DB s/w
			  if(st!=null)
				  rs=st.executeQuery(query);
			  //Process the ResultSet
			  if(rs!=null){
				  rs.next();
				  count=rs.getInt(1);
			  }
			  if(count==0)
				    System.out.println("Invalid Credentials");
			  else
				  System.out.println("Valid Credentails");
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
