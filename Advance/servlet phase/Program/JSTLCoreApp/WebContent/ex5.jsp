<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="names"  value="raja,rani,jani,boni,phani,tuni,dhoni,ambhani"/>

 <c:forTokens var="str" items="${names}" delims="i,">
    ${str},   <br>
 </c:forTokens>

<c:redirect url="${googleUrl}" /> 


