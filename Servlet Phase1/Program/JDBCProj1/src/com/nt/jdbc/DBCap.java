package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCap {

	public static void main(String[] args) {
		Connection con=null;
		DatabaseMetaData dbmd=null;
		try{
		  //establish the connection
			//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//con=DriverManager.getConnection("jdbc:mysql:///ntaj99db1","root","root");
			con=DriverManager.getConnection("jdbc:odbc:oradsn","system","manager");
		  //create DatabaseMetaData object
			dbmd=con.getMetaData();
			System.out.println("dbmd class obj "+dbmd.getClass());
			System.out.println("Database name::"+dbmd.getDatabaseProductName());
		  System.out.println("Database Version::"+dbmd.getDatabaseProductVersion());
			System.out.println("JDBC  Version ::"+dbmd.getJDBCMajorVersion()+"."+dbmd.getJDBCMinorVersion());
			//System.out.println("JDBC Driver Version::"+dbmd.getDriverMajorVersion()+"."+dbmd.getDatabaseMinorVersion());
			System.out.println("JDBC driver name ::"+dbmd.getDriverName());
			System.out.println("SQL keywords::"+dbmd.getSQLKeywords());
			System.out.println("Numberic functions::"+dbmd.getNumericFunctions());
			System.out.println("System Functions::"+dbmd.getSystemFunctions());
			System.out.println("Max Chars in table name::"+dbmd.getMaxTableNameLength());
			System.out.println("Max chars in col name ::"+dbmd.getMaxColumnNameLength());
			System.out.println("Max Tables in Select Query::"+dbmd.getMaxTablesInSelect());
			System.out.println("Supports Procedures?"+dbmd.supportsStoredProcedures());
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
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
