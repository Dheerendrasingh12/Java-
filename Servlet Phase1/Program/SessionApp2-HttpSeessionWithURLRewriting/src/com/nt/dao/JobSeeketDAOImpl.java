package com.nt.dao;

import java.security.spec.DSAGenParameterSpec;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.JobSeekerBO;

public class JobSeeketDAOImpl implements JobSeekerDAO {
	 private static final String  INSERT_INFO_QUERY="INSERT INTO INFO VALUES(?,?,?,?,?,?,?)";
	 
	//gets jdbc con obj from jdbc con pool
	 private Connection getConnection()throws Exception{
		 DataSource ds=null;
		 InitialContext ic=new InitialContext();
		 ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		 return ds.getConnection();
	 }

	@Override
	public int insert(JobSeekerBO bo) throws Exception {
	    Connection con=null;
	    PreparedStatement ps=null;
	    int result=0;
		//get jdbc connection object
	    con=getConnection();
	    //create PreparedStatement object
	    ps=con.prepareStatement(INSERT_INFO_QUERY);
	    //set values to query params
	    ps.setString(1,bo.getName());
	    ps.setString(2,bo.getAddrs());
	    ps.setInt(3, bo.getAge());
	    ps.setString(4, bo.getSkill());
	    ps.setInt(5,bo.getExp());
	    ps.setString(6,bo.getCity());
	    ps.setInt(7,bo.getSalary());
	    //execute the query
	    result=ps.executeUpdate();
	    //close objs
	    ps.close();
	    con.close();
	   return result;
	}//method
}//class
