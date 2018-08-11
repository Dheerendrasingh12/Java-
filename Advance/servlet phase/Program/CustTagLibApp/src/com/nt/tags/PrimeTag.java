package com.nt.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PrimeTag extends TagSupport {
	private int n=10;
	
	public void setN(int n){
		this.n=n;
	}
	
	private  boolean isPrime(int x){
		boolean flag=true;
		for(int i=2;i<x;++i){
			  if(x%i==0){
				  flag=false;
				  break;
			  }
		}
		return flag;
	}
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out=null;
	  //get Out object
		out=pageContext.getOut();
		try{
		//print prime numbers
		for(int i=2;i<=n;++i){
			if(isPrime(i)){
				out.print(i+"  ");
			}
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
	
		return EVAL_PAGE;
	
	}

}
