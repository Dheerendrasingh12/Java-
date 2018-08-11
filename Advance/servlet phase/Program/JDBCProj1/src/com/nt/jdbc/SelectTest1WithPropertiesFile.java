package com.nt.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SelectTest1WithPropertiesFile {
   private static final String SELECT_STUDENT_QUERY="SELECT SNO,SNAME,SADD FROM STUDENT";
	public static void main(String[] args) {
		Connection con=null;
		InputStream is=null;
		Properties props=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			//locate proeprties file
			is=new FileInputStream("src/com/nt/commons/DBDetails.properties");
			//Load the properties content into java.util.Properties class object
			props=new Properties();
			props.load(is);
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",props);
			//create Statement object
			if(con!=null)
				st=con.createStatement();
			//send and execute SQL query
			if(st!=null)
				rs=st.executeQuery(SELECT_STUDENT_QUERY);
			if(rs!=null){
				while(rs.next()){
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				}//while
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
				if(is!=null)
					is.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}//finally

	}//main
}//class
