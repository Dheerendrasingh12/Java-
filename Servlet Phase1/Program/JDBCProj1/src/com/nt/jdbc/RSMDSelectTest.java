//SelectTest3.java
package com.nt.jdbc;
/* Application to get Emp details from emp table based on given Desgs */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class RSMDSelectTest
{
	public static void main(String args[]){
		Scanner sc=null;
		String desg1=null,desg2=null,desg3=null;
		String cond=null;
		Connection con=null;
		Statement st=null;
		String query=null;
		ResultSet rs=null;
		boolean flag=false;
		ResultSetMetaData rsmd=null;
		int count=0;
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
			//prepare SQL Query condition ('CLERK','MANAGER','SALESMAN')
		     cond="('"+desg1+"','"+desg2+"','"+desg3+"')";
			 
			 //register JDBC driver s/w
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 //establish the connection
			 con=DriverManager.getConnection("jdbc:odbc:oradsn","system","manager");
			 //create STatement object
			 if(con!=null)
				 st=con.createStatement();
			 //prepare  SQL Query
			 //select empno,ename,job,sal,deptno from emp where job in('CLERK','MANAGER','SALESMAN') order by job;
               query="select empno,ename,job,sal,deptno from emp where job in"+cond+"order by job";
			   System.out.println(query);
			 //send and execute SQL Query in Db s/w
			 if(st!=null)
				 rs=st.executeQuery(query);
			 // get ResultSetMetaData
			 if(rs!=null)
				 rsmd=rs.getMetaData();
			 //print col names
			 count=rsmd.getColumnCount();
			 for(int i=1;i<=count;++i){
				 System.out.print(rsmd.getColumnLabel(i)+" ");
			 }
			 System.out.println();
			 
			 for(int i=1;i<=count;++i){
				 System.out.print(rsmd.getColumnTypeName(i)+" ");
			 }
			 System.out.println();
			 
			 
			 //process the ResultSet
			 if(rs!=null){
                   while(rs.next()){
                         flag=true;
                         for(int i=1;i<=count;++i){
                        	 System.out.print(rs.getString(i)+"   ");
                         }
                         System.out.println();
				   }//while
			 }//if
			 if(flag==false)
				 System.out.println("Records not found");
			 
			 for(int i=1;i<=count;++i){
				 System.out.println("col name::"+rsmd.getColumnName(i));
				 System.out.println("Col type::"+rsmd.getColumnType(i));
				 System.out.println("Col typeName::"+rsmd.getColumnTypeName(i));
				 System.out.println("Col scale ::"+rsmd.getScale(i));
				 System.out.println("Col Precision::"+rsmd.getPrecision(i));
				 System.out.println("Col is Signed?::"+rsmd.isSigned(i));
				 System.out.println("Col is Nullable?"+rsmd.isNullable(i));
			 }

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
          if(st!=null)
			  st.close();
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

 

