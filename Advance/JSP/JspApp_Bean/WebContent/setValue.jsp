<%@page import="com.dheerendra.StudentBean"%>
<jsp:useBean id="st" class="com.dheerendra.StudentBean" scope="session">
<jsp:setProperty name="st" property="sno" value=request.getParameter("no")></jsp:useBean>
<jsp:setProperty name="st" property="sname" value=request.getParameter("name")></jsp:useBean>
<jsp:setProperty name="st" property="sadd" value=request.getParameter("city")></jsp:useBean>
</jsp:useBean>

<br>
<b>Value are to set to bean</b>