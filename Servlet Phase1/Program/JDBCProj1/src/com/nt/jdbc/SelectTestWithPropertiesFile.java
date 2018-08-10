package com.nt.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SelectTestWithPropertiesFile {
   private static final String SELECT_STUDENT_QUERY="SELECT SNO,SNAME,SADD FROM STUDENT";
	public static void main(String[] args) {
		Connection con=null;
		InputStream is=null;
		Properties props=null;
		String  driver=null,url=null,dbUser=null,dbPwd=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			//locate proeprties file
			is=new FileInputStream("src/com/nt/commons/jdbc.properties");
			//Load the properties content into java.util.Properties class object
			props=new Properties();
			props.load(is);
			//get Jdbc properties
			driver=props.getProperty("jdbc.driver");
			url=props.getProperty("jdbc.url");
			dbUser=props.getProperty("jdbc.username");
			dbPwd=props.getProperty("jdbc.password");
			//register jdbc driver
			Class.forName(driver);
			//establish the connection
			con=DriverManager.getConnection(url,dbUser,dbPwd);
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
