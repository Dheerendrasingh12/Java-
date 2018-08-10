package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLTest {
   private static final String  GET_PRODUCTS_QUERY="SELECT * FROM PRODUCT";
	public static void main(String[] args) {

		/*try{
			//register jdbc driver
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}*/
		//establish the connection
		//try(Connection con=DriverManager.getConnection("jdbc:postgresql:ntaj99db","postgres","root")){
		try(Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ntaj99db","postgres","root")){
			//create Statemet
			try(Statement st=con.createStatement()){
				//send execute Query
				try(ResultSet rs=st.executeQuery(GET_PRODUCTS_QUERY)){
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
