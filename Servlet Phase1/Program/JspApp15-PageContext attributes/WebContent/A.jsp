
<b>From A.jsp</b>

<% pageContext.setAttribute("attr1","val1",PageContext.PAGE_SCOPE);
      pageContext.setAttribute("attr2","val2",PageContext.REQUEST_SCOPE);
      pageContext.setAttribute("attr3","val3",PageContext.SESSION_SCOPE);
      pageContext.setAttribute("attr4","val4",PageContext.APPLICATION_SCOPE);
 %>
 <!-- Forward the request to B.jsp -->
 <jsp:forward page="B.jsp"/>