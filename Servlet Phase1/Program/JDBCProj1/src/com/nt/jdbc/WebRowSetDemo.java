package com.nt.jdbc;

import java.io.FileWriter;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.WebRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleJDBCRowSet;
import oracle.jdbc.rowset.OracleWebRowSet;

public class WebRowSetDemo {

	public static void main(String[] args) {
		WebRowSet wrowset;
		FileWriter writer=null;
		try{
			//create RowSet object
			wrowset=new OracleWebRowSet();
			//set jdbc properties
			wrowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			wrowset.setUsername("system");
			wrowset.setPassword("manager");
			wrowset.setCommand("select * from student");
			//execute Query
			wrowset.execute();
			//Process theResultSet
			writer=new FileWriter("d:\\student_table.xml");
		    wrowset.writeXml(writer);
		    System.out.println("done ...");
			
			//close jdbc objs
		    writer.close();
			wrowset.close();
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}//main
}//class
