<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Declare variable -->
 <c:set var="msg" value="hello" scope="session"/>
 <!-- Display variable value -->
 value :: <c:out value="${msg}"/>    &nbsp;&nbsp; ${msg}
 <!-- Remove variable from scope -->
 <c:remove var="msg" scope="session"/>
 <!-- Display variable value -->
 value :: <c:out value="${msg}"/> &nbsp;&nbsp; ${msg}

