

<%
       //read form data
       String iname=request.getParameter("iname");
       float iprice=Float.parseFloat(request.getParameter("iprice"));
       int iqty= Integer.parseInt(request.getParameter("iqty"));
       //calculate Bill Amount
       float billAmt=iprice*iqty;
       if(billAmt>=50000){ %>
          <jsp:forward page="discount.jsp" >
             <jsp:param name="bAmt"   value="<%=billAmt%>"/>
          </jsp:forward>
      <% }
          else{ %>
            <h1> Bill Details </h1>
             Item name :: <%=iname %> <br>
             Bill Amount :: <%=billAmt %>
          <%} %>    <br>
    <a href="form.html">home</a>      
