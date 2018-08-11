package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private static final String INSERT_STUDENT_QUERY="INSERT INTO LAYERED_STUDENT(SNAME,TOTAL,AVG,RESULT) VALUES(?,?,?,?)";
	
	
	public Connection getConnection()throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//method get connection obj from jdbc con pool
		ic=new InitialContext();
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		con=ds.getConnection();
       return con;		
	}
	
	
	@Override
	public int insert(StudentBO bo) throws Exception{
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//get Connection obj from jdbc con pool
		con=getConnection();
		//create PreparedStatement object
		ps=con.prepareStatement(INSERT_STUDENT_QUERY);
		//set values to Query params
		ps.setString(1,bo.getSname());
		ps.setInt(2,bo.getTotal());
		ps.setFloat(3,bo.getAvg());
		ps.setString(4,bo.getResult());
		//send and execute SQL Query
		result=ps.executeUpdate();
			return result;
	}//method
}//class
