package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PMDTest {

	public static void main(String[] args) {
		Connection con=null;
		ParameterMetaData pmd=null;
		PreparedStatement ps=null;
		int count=0;
		try{
		  //establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//con=DriverManager.getConnection("jdbc:mysql:///ntaj99db1","root","root");
			//con=DriverManager.getConnection("jdbc:odbc:oradsn","system","manager");
			//create PreparedStatement object
			if(con!=null)
				ps=con.prepareStatement("insert into Student values(?,?,?)");
			//create ParameterMetaData object
			if(ps!=null)
				pmd=ps.getParameterMetaData();
			//get parameter count
			count=pmd.getParameterCount();
			 //get parameter details
			for(int i=1;i<=count;++i){
				System.out.println("parameter number::"+i);
				System.out.println("parameter mode::"+pmd.getParameterMode(i));
				System.out.println("parmaeter type::"+pmd.getParameterType(i));
				System.out.println("parameter type name::"+pmd.getParameterTypeName(i));
				System.out.println("paramter is singed::"+pmd.isSigned(i));
				System.out.println("parameter is Nullable::"+pmd.isNullable(i));
			}
			
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
