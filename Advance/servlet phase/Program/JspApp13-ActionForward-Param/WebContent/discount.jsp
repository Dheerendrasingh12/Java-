
<% //read form data
     String name=request.getParameter("iname"); 
     //read additonal req param value given by bill.jsp
     float bAmt=Float.parseFloat(request.getParameter("bAmt"));
     //Calculate discount amount
     float discount=bAmt*0.3f;
     //calculate final Amount
     float finalAmt=bAmt-discount;  %>
       <h1 style="color:red;text-align:center"> Bill Details </h1>
     Item  name :: <%=name %> <br>
     Bill Amount :: <%=bAmt %> <br>
     Discount Amount ::<%=discount %> <br>
     Final  Amount :: <%=finalAmt %> <br>
     
     <a href="form.html">home</a>
     
     
     
     
