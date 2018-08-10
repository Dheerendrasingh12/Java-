<table border="0" width="100%"  height="100%">
    <tr height="20%">
         <td colspan="3"> <jsp:include page="/headurl"/> </td>
    </tr>
    <tr height="70%">
        <td width="20%"> <%@include file="menu.html" %> </td>
        <td width="50%"><jsp:include page="home.jsp"/>  </td>
        <td width="30%">
            <table border="0">
                 <tr>
                   <td><jsp:include page="horoscope.jsp"></jsp:include> </td>
                 </tr>
                 <tr>
                 <td><jsp:include page="weather.jsp"></jsp:include> </td>
                 </tr>
            </table>
         </td>
    </tr>
    <tr height="10%">
           <td colspan="3"><%@include file="footer.html" %> </td>
    </tr>
</table>

