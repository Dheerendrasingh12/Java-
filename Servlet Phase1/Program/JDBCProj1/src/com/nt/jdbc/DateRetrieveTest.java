package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class DateRetrieveTest {
  private static final String  GET_ALL_PERSONS="SELECT PID,PNAME,DOB,DOJ FROM PERSON_TAB";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int no=0;
		String name=null,dob=null,doj=null;
		java.sql.Date sqdob=null,sqdoj=null;
		java.util.Date udob=null,udoj=null;
		SimpleDateFormat sdf=null;
		
		try{
		/*	//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");*/
			
			//register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:mysql:///ntaj99db1","root","root");
			
			//create PreparedStatement object
			if(con!=null)
				ps=con.prepareStatement(GET_ALL_PERSONS);
			//execute the Query
			 if(ps!=null)
				 rs=ps.executeQuery();
			 //process the ReusltSet
			  if(rs!=null){
				  while(rs.next()){
					  no=rs.getInt(1);
					  name=rs.getString(2);
					  sqdob=rs.getDate(3);
					  sqdoj=rs.getDate(4);
					  //Convert java.sql.Date class objs to java.utl.Date class object
					  udob=(java.util.Date)sqdob;
					  udoj=(java.util.Date)sqdoj;
					//Convert java.util.Date class objs to String values
					  sdf=new SimpleDateFormat("yyyy-MMM-dd");
					  dob=sdf.format(udob);
					  doj=sdf.format(udoj);
					  
					  System.out.println(no+"   "+name+"   "+dob+"  "+doj);
				  }//while
			  }//if
		}//try
		catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException se) { // To handle known Exception
			se.printStackTrace();
		} catch (Exception e) { // To handle unknown Exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} // try
			catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
			} // try
			catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} // try
			catch (SQLException se) {
				se.printStackTrace();
			}
		} // finally

	}//main
}//class
