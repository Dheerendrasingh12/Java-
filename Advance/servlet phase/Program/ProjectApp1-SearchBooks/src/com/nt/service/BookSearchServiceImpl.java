package com.nt.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.nt.bo.BookBO;
import com.nt.dao.BookSearchDAO;
import com.nt.dao.BookSearchDAOImpl;
import com.nt.dto.BookDTO;
import com.nt.exception.InternalDBProblemException;
import com.nt.exception.InternalJndiProblemException;

public class BookSearchServiceImpl implements BookSearchService {

	@Override                     
	public List<BookDTO> search(String category) throws InternalDBProblemException, InternalJndiProblemException {
		BookSearchDAO dao=null;
		List<BookBO> listBO=null;
		List<BookDTO> listDTO=new ArrayList();
		//BookDTO dto=null;
		//use DAO
		dao=new BookSearchDAOImpl();
		try{
		listBO=dao.findBooks(category);
		}
		catch(SQLException se){
			throw new InternalDBProblemException(se.getMessage());
		}
		catch(NamingException ne){
			throw new InternalJndiProblemException(ne.getMessage());
		}
		//Convert ListBO to ListDTO
		/*for(BookBO bo:listBO){
			//copy Each BO to Each DTO
			dto=new BookDTO();
			dto.setSno(listDTO.size()+1);
			dto.setBookId(bo.getBookId());
			dto.setBookName(bo.getBookName());
			dto.setCategory(bo.getCategory());
			dto.setStatus(bo.getStatus());
			dto.setAuthor(bo.getAuthor());
			//add DTO to ListDTO
			listDTO.add(dto);
		}//for
*/		
		listBO.forEach(bo->{
			BookDTO dto=new BookDTO();
			dto.setSno(listDTO.size()+1);
			dto.setBookId(bo.getBookId());
			dto.setAuthor(bo.getAuthor());
			dto.setBookName(bo.getBookName());
			dto.setStatus(bo.getStatus());
			dto.setCategory(bo.getCategory());
			listDTO.add(dto);
		});
		
		return listDTO;
	}//method

}//class
