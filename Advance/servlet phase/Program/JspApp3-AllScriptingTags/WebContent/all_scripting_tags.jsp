<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
     public String generateWishMessage(String uname){
         java.util.Calendar calendar=null;
         int hour=0;
          //get Calendar object (System Date)
          calendar=java.util.Calendar.getInstance();
          //get current hour of the day
          hour=calendar.get(java.util.Calendar.HOUR_OF_DAY);
          //generate wish Message
          if(hour<=12)
            return "Good Morning::"+uname;
           else if(hour<=16)
             return "Good AfterNoon::"+uname;
            else if(hour<=20)
              return "Good Evening::"+uname;
            else
             return "Good Night::"+uname;
     } 
 %>
<!--   <h1 style="color:red;text-align:center">Welcome to jsp Page </h1> -->
  Date and time :: <%-- <%=new java.util.Date() %> --%> <br>
  <%String name=request.getParameter("uname"); %>
  Wish MEssage :: <!--<%=generateWishMessage(name) %> -->
  <!--  <jsp:expression>
       generateWishMessage(name)
   </jsp:expression>  -->
  




