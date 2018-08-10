<%@page import="java.util.*,com.nt.dto.BookDTO" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<%-- <%
   //read request attribute value
    List<BookDTO> listDTO=(List<BookDTO>)request.getAttribute("searchResults");
    //read catetory req param value
    String category=request.getParameter("category");
 %>
 
 <h1 style="color:red"> Books  Belognging to  <%=category %> </h1>
 <%
      if(listDTO!=null || listDTO.size()!=0){ %>
      <table  border="1">
      <%
         for(BookDTO dto:listDTO){
    %>
           <tr>
             <td><%=dto.getSno() %> </td>
             <td><%=dto.getBookId() %> </td>
             <td><%=dto.getBookName() %> </td>
             <td><%=dto.getCategory() %> </td>
             <td><%=dto.getAuthor() %> </td>
             <td><%=dto.getStatus() %> </td>
           </tr>
    <%}//for %>
    </table>
    <%}//if
        else{
     %>
               <h1 style="color:red">Records not found </h1>
       <% } %>
       
 --%>       <br>
  <c:choose>
     <c:when test="${!empty searchResults}">
       <table>
         <tr><th>sno </th><th>BookId</th><th>BookName</th><th>Author</th><th>Status</th><th>category</th></tr>
         <c:forEach  var="dto" items="${searchResults}">
            <tr>
            <td>${dto.sno} </td>
            <td>${dto.bookId} </td>
            <td>${dto.bookName}</td>
            <td>${dto.author}</td>
            <td>${dto.status}</td>
            <td>${dto.category}</td>
            </tr>
         </c:forEach>
       </table>
     </c:when>
    <c:otherwise>
        <h1 style="color:red;text-align:center">Books Not Found </h1>
    </c:otherwise>
  </c:choose>
 <br> 
        <a href="search.html">home</a>  
         &nbsp;&nbsp;&nbsp;
         <a href="Javascript:showPrint()">print</a>
    <script language="JavaScript">
       function showPrint(){
          frames.focus();
          frames.print();
       }
    </script>     
         
