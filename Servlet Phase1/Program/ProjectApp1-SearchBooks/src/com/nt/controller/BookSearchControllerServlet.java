package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.BookDTO;
import com.nt.exception.InternalDBProblemException;
import com.nt.exception.InternalJndiProblemException;
import com.nt.service.BookSearchService;
import com.nt.service.BookSearchServiceImpl;

@WebServlet("/controller")
public class BookSearchControllerServlet extends HttpServlet {
	
	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String category=null;
        String source=null;
        BookSearchService service=null;
        List<BookDTO> listDTO=null;
        RequestDispatcher rd=null;
		//read form data
        category=req.getParameter("category");
        source=req.getParameter("source");
        //create Service class object
        service=new BookSearchServiceImpl();
        try{
        	listDTO=service.search(category);
        	req.setAttribute("searchResults", listDTO);
        }
        catch(InternalDBProblemException idpe){
        	rd=req.getRequestDispatcher("/err.jsp");
        	rd.forward(req,res);
        	return;
        }
        catch(InternalJndiProblemException ijpe){
        	rd=req.getRequestDispatcher("/err1.jsp");
        	rd.forward(req,res);
        	return;
        }
        
        //forward to html_screen.jsp or excel_screen.jsp
        if(source.equalsIgnoreCase("html")){
           rd=req.getRequestDispatcher("/html_screen.jsp");
           rd.forward(req,res);
        }
        else{
        	 rd=req.getRequestDispatcher("/excel_screen.jsp");
             rd.forward(req,res);
        }
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class
