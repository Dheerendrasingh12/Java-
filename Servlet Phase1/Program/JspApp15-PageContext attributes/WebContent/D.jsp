
<b>From D.jsp</b><br>
attr1(page) value :: <%=pageContext.findAttribute("attr1") %> <br>
attr2(request) value :: <%=pageContext.findAttribute("attr2") %> <br>
attr2(request) value :: <%=request.getAttribute("attr2") %> <br>
attr3(session) value :: <%=pageContext.findAttribute("attr3") %> <br>
attr3(session) value :: <%=session.getAttribute("attr3") %> <br> 
attr4(application) value :: <%=pageContext.findAttribute("attr4") %> <br>
attr4(application) value :: <%=application.getAttribute("attr4") %> <br>


