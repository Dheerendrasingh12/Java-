<%@page import="java.util.*,com.nt.dto.BookDTO" %>
<%
   //read request attribute value
    List<BookDTO> listDTO=(List<BookDTO>)request.getAttribute("searchResults");
    //read catetory req param value
    String category=request.getParameter("category");
 %>
  <%
       response.setContentType("application/vnd.ms-excel");
       response.addHeader("Content-Disposition","attachment;fileName=Title.xls");
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
       
         
