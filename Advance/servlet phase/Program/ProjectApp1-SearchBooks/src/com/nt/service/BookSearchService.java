package com.nt.service;

import java.util.List;

import com.nt.dto.BookDTO;
import com.nt.exception.InternalDBProblemException;
import com.nt.exception.InternalJndiProblemException;

public interface BookSearchService {
	
	public  List<BookDTO>  search(String category)throws InternalDBProblemException,InternalJndiProblemException;

}
