<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>

<!-- create DataSource -->
<sql:setDataSource var="ds" driver="oracle.jdbc.driver.OracleDriver"
                                     url="jdbc:oracle:thin:@localhost:1521:xe"
                                     user="system" password="manager"/>
<!-- execute select Query -->
<sql:query dataSource="${ds}"   sql="select * from emp" var="rs"/>
<!-- Process the ResultSet -->
<c:forEach var="row"  items="${rs.rows}">
     ${row.empno }  &nbsp;&nbsp;&nbsp; ${row.ename }<br>
</c:forEach>                                    
                                         
    
