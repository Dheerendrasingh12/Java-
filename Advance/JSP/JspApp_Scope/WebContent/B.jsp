<b>From B.jsp</b>

<br>
<br>
Attr1(req) value=<%=pageContext.findAttribute("attr1")  %><br>

Attr2(ses) value=<%=pageContext.findAttribute("attr2")  %><br>
Attr3(application) value=<%=pageContext.findAttribute("attr3")  %><br>

<jsp:forward page="C.jsp"/>