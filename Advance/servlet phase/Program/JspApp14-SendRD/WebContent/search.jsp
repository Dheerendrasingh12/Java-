<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <%
     //read form data
     String ss=request.getParameter("ss");
     //encode search string
     ss=URLEncoder.encode(ss);
     //perform sendRedirection
     response.sendRedirect("https://google.co.in/search?q="+ss);
   %>

