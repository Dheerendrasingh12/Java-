package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ScrollableTestPS {
   private static final String  GET_STUDENTS="SELECT * FROM STUDENT";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create STatement object with type,mode values
			if(con!=null)
				  //  ps=con.prepareStatement(GET_STUDENTS,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				   ps=con.prepareStatement(GET_STUDENTS,1005,1007);
			//send and execute SQL Query in DB s/w
			if(ps!=null)
				rs=ps.executeQuery();
			//print records (top-bottom)
			if(rs!=null){
			System.out.println("Top-Bottom-->");
			while(rs.next()){
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			}
			//print records ("Botton-->Top)
			System.out.println("Bottom--Top)-->");
			while(rs.previous()){
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			}
			
			//first Record
			rs.first();
			System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3));
			//last record
			rs.last();
			System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3));
			//4 th record
			rs.absolute(4);
			System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3));
			//From Bottom 3rd record
			rs.absolute(-3);
			System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3));
			//from current position
			rs.relative(2);
			System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3));
			//from current position
			rs.relative(-3);
			System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3));
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
