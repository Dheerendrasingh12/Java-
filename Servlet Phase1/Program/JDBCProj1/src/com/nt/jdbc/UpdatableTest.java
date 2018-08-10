package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatableTest {
   private static final String  GET_ALL_STUDENTS="SELECT  SNO,SNAME,SADD FROM STUDENT";
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
		  //register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create Statement object
			if(con!=null)
				st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						                                      ResultSet.CONCUR_READ_ONLY);
			//execute query
			if(st!=null)
				rs=st.executeQuery(GET_ALL_STUDENTS);
			//process the ResultSet (Select operation)
			System.out.println("select operation");
			if(rs!=null){
				while(rs.next()){
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				}
			}
		/*	//for insert operation
			if(rs!=null){
				rs.moveToInsertRow();
				rs.updateInt(1,22);
				rs.updateString(2,"singh");
				rs.updateString(3,"hyd");
				rs.insertRow();
				System.out.println("record inserted");
			}*/
/*			//for Update operation
			if(rs!=null){
				rs.absolute(4);
				rs.updateString(3,"blore");
				rs.updateRow();
				System.out.println("record updated...");
			}
*/      //for deletion
			if(rs!=null){
				rs.absolute(2);
				rs.deleteRow();
				System.out.println("record deleted");
			}
			
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
			catch(Exception e){
				e.printStackTrace();
			}
		}//finally
	}//main
}//class
