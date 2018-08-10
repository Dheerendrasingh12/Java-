<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>

<!-- create DataSource -->
<sql:setDataSource var="ds" driver="oracle.jdbc.driver.OracleDriver"
                                     url="jdbc:oracle:thin:@localhost:1521:xe"
                                     user="system" password="manager"/>
                                     
 <sql:update var="count" dataSource="${ds}"   sql="insert into student values(?,?,?)">
       <sql:param value="10001"/>
       <sql:param>raja</sql:param>
       <sql:param>hyd</sql:param>
 </sql:update>              
 <br>
  No.of records effecetd :: ${count}                           
    
