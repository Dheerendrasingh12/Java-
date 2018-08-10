<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html; charset=UTF-8" %>

<fmt:setLocale value="fr_FR"/>

<fmt:formatNumber var="fprice" type="currency"  value="100000000"  currencyCode="EUR" currencySymbol="EUR"/>
Formatted price :: ${fprice}

 <jsp:useBean  id="dt"   class="java.util.Date"/>
 <fmt:formatDate var="fdt" value="${dt}"/>
 <br> Fromatted date :: ${fdt} <br>
 
 <fmt:setBundle basename="App" var="b1"/>
 
<fmt:message bundle="${b1}" key="wish.msg" var="fmsg"/>
 <br> Formatted message ::  ${fmsg} 
 


