<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Create or Locate JavaBean calss object(DTO) -->
<jsp:useBean id="dto" class="com.nt.dto.EmployeeDTO"  scope="request"/>
<!-- set recived form data to Bean class object -->
<jsp:setProperty property="*" name="dto"/>
<!-- create or locate SErvice class object -->
<jsp:useBean id="service"  class="com.nt.service.EmployeeServiceImpl" scope="application"/>
<%
   //invoke the method
     service.generatePaySlip(dto);
 %>
<!-- Display results(Gross,NetSalaries) -->
<h1 style="color:red;text-align:center">PaySlip Details</h1>
 Emp Number :: <jsp:getProperty name="dto" property="eno"/> <br>
 Emp Name :: <jsp:getProperty name="dto" property="ename"/> <br>
Emp Basic Salary :: <jsp:getProperty name="dto" property="basicSalary"/> <br>
Emp Addrs :: <jsp:getProperty name="dto" property="addrs"/> <br>
Emp GrossSalary :: <jsp:getProperty name="dto" property="grossSalary"/> <br>
Emp NetSalary :: <jsp:getProperty name="dto" property="netSalary"/> <br>



 