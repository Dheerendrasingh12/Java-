package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.nt.bo.BookBO;

public class BookSearchDAOImpl implements BookSearchDAO {
	 private static final String  GET_BOOKS_BY_CATEGORY="SELECT BOOKID,BOOKNAME,AUTHOR,STATUS,CATEGORY FROM BOOK_DETAILS WHERE CATEGORY=?";
	
	private  Connection getPooledConnection()throws NamingException,SQLException{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//create InitialContext obj
		ic=new InitialContext();
		//get DataSource obj from jndi registry
		ds=(DataSource) ic.lookup("java:/comp/env/DsJndi");
		//get Pooled jdbc connection
		con=ds.getConnection();
		return con;
		
	}

	@Override
	public List<BookBO> findBooks(String category) throws SQLException,NamingException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BookBO> listBO=null;
		BookBO bo=null;
		//get Pooled connection
		con=getPooledConnection();
		//create PreparedStatement object
		ps=con.prepareStatement(GET_BOOKS_BY_CATEGORY);
		//set values to query params
		ps.setString(1,category);
		//execute Query
		rs=ps.executeQuery();
		//copy ResultSet obj records to ListBO 
		listBO=new ArrayList();
		while(rs.next()){
			//copy each record of ResultSet to BO class obj
			bo=new BookBO();
			bo.setBookId(rs.getInt(1));
			bo.setBookName(rs.getString(2));
			bo.setAuthor(rs.getString(3));
			bo.setStatus(rs.getString(4));
			bo.setCategory(rs.getString(5));
			//Add Each BO class obj to List Collection
			listBO.add(bo);
		}//while
		//close jdbc objs
		ps.close();
		con.close();
		return listBO;
	}//method
}//class
