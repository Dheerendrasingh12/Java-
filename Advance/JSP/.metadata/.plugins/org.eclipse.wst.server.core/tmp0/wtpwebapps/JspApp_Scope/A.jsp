<%
pageContext.setAttribute("attr1","val1",pageContext.REQUEST_SCOPE);
pageContext.setAttribute("attr2","val2",pageContext.SESSION_SCOPE);
pageContext.setAttribute("attr3","val3",pageContext.APPLICATION_SCOPE);
%>

<jsp:forward page="B.jsp"/>