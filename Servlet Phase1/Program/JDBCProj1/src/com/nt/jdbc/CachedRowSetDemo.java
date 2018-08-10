package com.nt.jdbc;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleJDBCRowSet;

public class CachedRowSetDemo {

	public static void main(String[] args) {
		CachedRowSet crowset;
		try{
			//create RowSet object
			crowset=new OracleCachedRowSet();
			//set jdbc properties
			crowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crowset.setUsername("system");
			crowset.setPassword("manager");
			crowset.setCommand("select * from student");
			//execute Query
			crowset.execute();
			//Process theResultSet
			while(crowset.next()){
				System.out.println(crowset.getInt(1)+"   "+crowset.getString(2)+" "+crowset.getString(3));
			}
			System.out.println("Stop DB s/w");
			Thread.sleep(40000);
			//modify Cached Rowset in offline mode
			crowset.absolute(3);
			crowset.updateString(2, "jani");
			crowset.updateString(3,"sydney");
			crowset.updateRow();
			
			System.out.println("start DB s/w");
			 Thread.sleep(60000);
			 crowset.acceptChanges();
				//Process theResultSet
				while(crowset.next()){
					System.out.println(crowset.getInt(1)+"   "+crowset.getString(2)+" "+crowset.getString(3));
				}
			
			//close jdbc objs
			crowset.close();
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}//main
}//class
