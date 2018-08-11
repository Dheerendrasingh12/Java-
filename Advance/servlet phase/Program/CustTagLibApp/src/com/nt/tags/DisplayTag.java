package com.nt.tags;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DisplayTag extends TagSupport {
	private String font;
	private int size=20;
	
	
	
	public void setFont(String font) {
		this.font = font;
	}

	public void setSize(int size) {
		this.size = size;
	}

	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out=null;
		ServletRequest req=null;
		String status=null;
	  //get Out object
		out=pageContext.getOut();
		//get request object
		req=pageContext.getRequest();
		status=req.getParameter("print");
		try{
			out.println("<span style='font-family:"+font+";font-size:"+size+"px;'>");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(status==null)
		rewturn  SKIP_BODY;
		else if(status.equalsIgnoreCase("yes"))
			return EVAL_BODY_INCLUDE;
		else
			return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		JspWriter out=null;
	  //get Out obj
		out=pageContext.getOut();
		try{
		out.println("</span>");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return EVAL_PAGE;
	
	}//method
}//class
