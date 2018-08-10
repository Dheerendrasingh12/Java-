//SelectTest3.java
package com.nt.jdbc;
/* Application to get Emp details from emp table based on given Desgs */
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PsSelectTest3
{
	private static final String   GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?)";
	public static void main(String args[]){
		Scanner sc=null;
		String desg1=null,desg2=null,desg3=null;
		String cond=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean flag=false;
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter Desg1::");
				desg1=sc.next().toUpperCase();  //gives CLERK
				System.out.println("Enter Desg2::");
				desg2=sc.next().toUpperCase();  //gives MANAGER
				System.out.println("Enter Desg3::");
				desg3=sc.next().toUpperCase();  //gives SALESMAN
			}//if
			 
			 //register JDBC driver s/w
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 //establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			 //create STatement object
			 if(con!=null)
				 ps=con.prepareStatement(GET_EMPS_BY_DESG);
			   //set values to Query params
			   if(ps!=null){
				   ps.setString(1,desg1);
				   ps.setString(2,desg2);
				   ps.setString(3,desg3);
			   }
			 // execute SQL Query in Db s/w
			 if(ps!=null)
				 rs=ps.executeQuery();
			 //process the ResultSet
			 if(rs!=null){
                   while(rs.next()){
                         flag=true;
						 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4)+"   "+rs.getInt(5));
				   }//while
			 }//if
			 if(flag==false)
				 System.out.println("Records not found");

		 }//try
        catch(ClassNotFoundException cnf){  //To handle known Exception
		  cnf.printStackTrace();
		}
		catch(SQLException se) {  //To handle known Excepion
           se.printStackTrace();
		}
		catch(Exception e){    // To handle unknown Exception
            e.printStackTrace();
		}
	 finally{
        try{
          if(rs!=null)
			  rs.close();
		  }//try
		  catch(SQLException se){
			  se.printStackTrace();
		  }
         try{
          if(ps!=null)
			  ps.close();
		  }//try
		  catch(SQLException se){
			  se.printStackTrace();
		  }
          try{
          if(con!=null)
			  con.close();
		  }//try
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
//>javac   -d    .  SelectTest3.java
//>java    com.nt.jdbc.SelectTest3

 

