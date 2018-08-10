<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*" %>
  <table>
 <c:forEach var="i" begin="1" end="10"  step="1">
     <tr>
       <td>2 * ${i}=</td>
       <td>${2*i} </td>
     </tr>
 </c:forEach>
 </table>
 
 <jsp:scriptlet>
       String names[]={"raja","rani","jani","phani"};
       request.setAttribute("names",names);
 </jsp:scriptlet>
 
 <c:forEach var="nam"  items="${names}">
      ${nam}, <br>
 </c:forEach>
 
 <jsp:scriptlet>
 <![CDATA[
    List<String> fruitList=new ArrayList();
    fruitList.add("apple"); fruitList.add("banana"); fruitList.add("mango");
    request.setAttribute("fruitList",fruitList);
    ]]>
 </jsp:scriptlet>
 
  <c:forEach var="fruit" items="${fruitList}">
       ${fruit}, <br>
  </c:forEach>
 
 
 
 
 