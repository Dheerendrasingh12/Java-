package com.nt.jdbc;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class JdbcRowSetDemo {

	public static void main(String[] args) {
		JdbcRowSet jrowset;
		try{
			//create RowSet object
			jrowset=new OracleJDBCRowSet();
			//set jdbc properties
			jrowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			jrowset.setUsername("system");
			jrowset.setPassword("manager");
			jrowset.setCommand("select * from student");
			//execute Query
			jrowset.execute();
			//Process theResultSet
			while(jrowset.next()){
				System.out.println(jrowset.getInt(1)+"   "+jrowset.getString(2)+" "+jrowset.getString(3));
			}
			//close jdbc objs
			jrowset.close();
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}//main
}//class
