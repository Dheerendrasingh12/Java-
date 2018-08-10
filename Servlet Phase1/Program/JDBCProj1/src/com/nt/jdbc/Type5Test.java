package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Type5Test {
   private static final String  GET_STUDENTS_QUERY="SELECT * FROM STUDENT";
	public static void main(String[] args) {

		try{
			//register jdbc driver
			Class.forName("com.ddtek.jdbc.oracle.OracleDriver");
		}
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
		//establish the connection
		try(Connection con=DriverManager.getConnection("jdbc:datadirect:oracle://localhost:1521;ServiceName=xe","system","manager")){
			//create Statemet
			try(Statement st=con.createStatement()){
				//send execute Query
				try(ResultSet rs=st.executeQuery(GET_STUDENTS_QUERY)){
					//process the ResultSet
					while(rs.next()){
						System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
					}//while
				}//try
			}//try
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}//main
}//class
