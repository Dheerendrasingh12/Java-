package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsertTestOracle {
	private static final String DATE_INSERT = "INSERT INTO PERSON_TAB VALUES(?,?,?,?)";
    private static final  String GET_PID="SELECT PERSON_ID_SEQ.NEXTVAL FROM DUAL";
	public static void main(String[] args) {
		Scanner sc = null;
		int no = 0;
		String name = null;
		String dob = null, doj = null;
		Connection con = null;
		java.util.Date udob = null;
		SimpleDateFormat sdf1 = null;
		long ms = 0;
		java.sql.Date sqdob = null, sqdoj = null;
		PreparedStatement ps = null,ps1=null;
		int result = 0;
		ResultSet rs=null;
		
		try {
			// read inputs
			sc = new Scanner(System.in);
			if (sc != null) {
				System.out.println("Enter Person name::");
				name = sc.next();
				System.out.println("Enter DOB(dd-MM-yyyy)");
				dob = sc.next(); // dd-MM-yyyy
				System.out.println("Enter DOJ(yyyy-MM-dd)");
				doj = sc.next(); // yyyy-MM-dd
			}
			// register JDBC Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			
			// Convert String date values to java.sql.Date class objs
			// FOR DOB (dd-MM-yyyy)
			// convert String date vlaue to java.util.Date class object
			sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			udob = sdf1.parse(dob);
			// convert java.util.Date class object to java.sql.Date class object
			ms = udob.getTime();
			sqdob = new java.sql.Date(ms);
			// FOR DOJ (yyyy-MM-dd)
			sqdoj = java.sql.Date.valueOf(doj);
			//create PreparedStatement obj for SEQUENCE
			if(con!=null)
			  ps1=con.prepareStatement(GET_PID);
			//get PID from Sequence
			if(ps1!=null)
				rs=ps1.executeQuery();
			//process the Reuslt
			if(rs!=null){
				rs.next();
				no=rs.getInt(1);
			}
			// create PreparedStatement object
			if (con != null)
				ps = con.prepareStatement(DATE_INSERT);
			// set values to query params(?)
			if (ps != null) {
				ps.setInt(1, no);
				ps.setString(2, name);
				ps.setDate(3, sqdob);
				ps.setDate(4, sqdoj);
			}
			// execute the SQL query
			if (ps != null) {
				result = ps.executeUpdate();
			}
			// process the Result
			if (result == 0)
				System.out.println("Record not inserted");
			else
				System.out.println("Record  inserted");
		} // try
		catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException se) { // To handle known Exception
			se.printStackTrace();
		} catch (Exception e) { // To handle unknown Exception
			e.printStackTrace();
		} finally {
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
			try {
				if (sc != null)
					sc.close();
			} // try
			catch (Exception se) {
				se.printStackTrace();
			}

		} // finally
	}// main
}// class

/*SQL>create sequence PERSON_ID_SEQ start with 1 increment by 1;*/
