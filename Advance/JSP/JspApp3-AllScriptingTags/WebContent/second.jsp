
<%!
   public  String generateWishMsg(String uname){
       java.util.Calendar calendar=null;
       int hour=0;
//        int x=0;
        //get System Date
        calendar=java.util.Calendar.getInstance();
        //get current hour of the day
        hour=calendar.get(java.util.Calendar.HOUR_OF_DAY);
        //generate wish message
        if(hour<=12)
            return "GM:"+uname;
         else if(hour<=16)
             return "GA:"+uname;
          else if(hour<=20)
             return "GE:"+uname;
           else
             return "GN:"+uname;
       }//method
 %>
 
<!-- <h1 style='color:red;text-align:center'> Welcome to jsp Page</h1> -->
<%--  Date and time :: <%=new  java.util.Date() %> <br> --%>
 <%String name="raja"; %>
 Wish Message :: <%=generateWishMsg(name) %>
  <br>
  out obj class name :: <%=out.getClass() %>
 
 
