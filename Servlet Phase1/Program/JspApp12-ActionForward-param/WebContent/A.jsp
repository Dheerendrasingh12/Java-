
<b> start of A.jsp</b>
<br><b> hello1</b>
<%int price=800; %>
<jsp:forward page="B.jsp">
    <jsp:param name="bkName"  value="CRJ"/>
    <jsp:param name="rate"  value="<%=price%>"/>
</jsp:forward>
<br>
<b>hello2</b>
<br><b>End of A.jsp</b>
