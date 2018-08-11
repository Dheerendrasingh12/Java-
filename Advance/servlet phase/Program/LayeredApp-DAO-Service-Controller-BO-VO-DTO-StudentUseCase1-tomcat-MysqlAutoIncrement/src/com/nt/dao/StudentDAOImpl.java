package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private static final String INSERT_LAYERED_STUDENT_QUERY="INSERT INTO LAYERED_STUDENT(SNAME,TOTAL,AVG,RESULT) VALUES(?,?,?,?)";
	
	/*  @Resource(name="DsJndi")
	  private DataSource ds;*/
	
	private Connection getPooledConnection()throws Exception{
		  InitialContext ic=null;
		  DataSource ds=null;
		  Connection con=null;
		  //create InitaialContext object
		  ic=new InitialContext();
		  //get DataSource obj from Jndi Registry
		  ds=(DataSource) ic.lookup("java:/comp/env/DsJndi-mysql");
		  //get Pooled con obj from jdbc con pool
		  con=ds.getConnection();
		  return con;
	}
	

	@Override
	public int insert(StudentBO bo) throws Exception {
		Connection con=null;
		PreparedStatement  ps=null;
		int result=0;
		
		//get Pooled jdbc con object
		con=getPooledConnection();
		//con=ds.getConnection();
		//create DataSource object
		ps=con.prepareStatement(INSERT_LAYERED_STUDENT_QUERY);
		//set values to query params
		ps.setString(1,bo.getSname());
		ps.setInt(2,bo.getTotal());
		ps.setFloat(3,bo.getAvg());
		ps.setString(4,bo.getResult());
		//execute Query
		result=ps.executeUpdate();
		ps.close();
		con.close();
		return result; 
	}

}
