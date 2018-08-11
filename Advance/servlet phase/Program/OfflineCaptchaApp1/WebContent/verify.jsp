<%@page import="nl.captcha.Captcha"%>
<%
//get Captcha obj from Session attribute 
Captcha captcha=(Captcha)session.getAttribute(Captcha.NAME);

// read answer from the form page
String answer=request.getParameter("answer");

if(captcha.isCorrect(answer))
    out.println("Correct");
   else{ %>
      <jsp:forward page="index.html"/>
 <% }
     %>