package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.InfoBO;

public class NaukriInfoDAOImpl implements NaukriInfoDAO {
	private static final String INSERT_INFO_DETAILS="INSERT INTO INFO VALUES(?,?,?,?,?,?,?)";
	
	public  Connection  makeConnection()throws Exception{
		 InitialContext ic=null;
		 DataSource ds=null;
		 Connection con=null;
		 
		 ic=new InitialContext();
		 ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		 con=ds.getConnection();
     return con;				 
	}
	
	@Override
	public int insert(InfoBO bo) throws Exception {
	   PreparedStatement ps=null;
	   Connection con=null;
	   int result=0;
	   //get pooled jdbc con object
	   //con=ds.getConnection();
	   con=makeConnection();
	   //create PrpearedStatement object
	   ps=con.prepareStatement(INSERT_INFO_DETAILS);
	   //set values query params
	   ps.setString(1,bo.getName());
	   ps.setString(2,bo.getAddrs());
	   ps.setInt(3,bo.getAge());
	   ps.setString(4,bo.getSkill());
	   ps.setFloat(5,bo.getExp());
	   ps.setString(6,bo.getCity());
	   ps.setInt(7,bo.getSalary());
	   //execute Query
	   result=ps.executeUpdate();
		return result;
	}//method

}//class
