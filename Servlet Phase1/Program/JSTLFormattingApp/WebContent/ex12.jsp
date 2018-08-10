<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>

<c:set var="msg"  value="Happy new year my dears pillar Batch"/>

Lower case :: ${fn:toLowerCase(msg) } <bR>
Upper case :: ${fn:toUpperCase(msg) } <bR>
Length :: ${fn:length(msg) }

 <c:set var="msg1"  value="${fn:substring(msg,0,5)}"/>
  <br>
   ${msg1}
   



