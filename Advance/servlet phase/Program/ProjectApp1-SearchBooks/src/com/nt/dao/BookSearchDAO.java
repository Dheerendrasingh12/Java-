package com.nt.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.nt.bo.BookBO;

public interface BookSearchDAO {
	public  List<BookBO>  findBooks(String category)throws SQLException,NamingException;
}
