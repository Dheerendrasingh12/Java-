<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>

<%--     attr1(req)  value :: <%=request.getAttribute("attr1") %> <br>
    attr2(ses)  value :: <%=session.getAttribute("attr2") %> <br>
    attr3(sc)  value :: <%=application.getAttribute("attr3") %> <br> --%>
    
    attr1(req)  value :: ${requestScope.attr1 } <br>
    attr2(ses)  value :: ${sessionScope.attr2 } <br>
    attr3(sc)  value ::  ${applicationScope.attr3 } 
    
    