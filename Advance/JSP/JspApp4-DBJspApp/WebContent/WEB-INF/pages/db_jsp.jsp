<%@page import="java.sql.*"%>

<%!
   Connection con;
    PreparedStatement ps1,ps2;
    ResultSet rs;
    public void jspInit(){
      ServletConfig cg=null;
      String driver=null,url=null,dbUser=null,dbPwd=null;
    //get Access ServletConfig obj
      cg=getServletConfig();
       //read init param values
       driver=cg.getInitParameter("driver");
       url=cg.getInitParameter("url");
       dbUser=cg.getInitParameter("dbuser");
       dbPwd=cg.getInitParameter("dbpwd");
    try{
       //register jdbc driver
       Class.forName(driver);
       //Establish the connection
       con=DriverManager.getConnection(url,dbUser,dbPwd);
       //create PreparedStatement objs
        ps1=con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?)");
        ps2=con.prepareStatement("SELECT SNO,SNAME,SADD FROM STUDENT");
       }//try
       catch(SQLException se){
         se.printStackTrace();
         }
         catch(ClassNotFoundException cnf){
         cnf.printStackTrace();
         }
         catch(Exception e){
          e.printStackTrace();
          }
          }//jspInit()
    %>
    
    <%
        //read  s1 request param value to know wheather button or hyperlink has generated request
         String pVal=null;
         int sno=0; 
         String sname=null,sadd=null; 
         int result=0;
         pVal=request.getParameter("s1");
         //write logic for submit Button
         if(pVal.equalsIgnoreCase("register")){
             //read formd data
             sno=Integer.parseInt(request.getParameter("sno"));
             sname=request.getParameter("sname");
             sadd=request.getParameter("sadd");
             //set values to query params
             ps1.setInt(1,sno);
             ps1.setString(2,sname);
             ps1.setString(3,sadd);
             //execute the  Query
             result=ps1.executeUpdate();
             //process the result
             if(result==0){  %>
                <h1 style='color:red;text-align:center'> Registration failed </h1>
          <%      
               }//if
               else{  %>
                 <h1 style='color:red;text-align:center'> Registration Succeded </h1>
                <%  }//else
                }//outer if
                else{   //for hyperlink
                //execute SQL Select Query
                  rs=ps2.executeQuery();          %>
                  <table  border="1">
                    <tr><th>sno</th><th>sname </th><th>sadd </th></tr>
                  <%
                     while(rs.next()){ %>
                       <tr>
                         <td> <%=rs.getInt(1) %> </td>
                         <td><%=rs.getString(2) %> </td>
                         <td><%=rs.getString(3) %></td>
                         </tr>
                   <%  } //while %>
                  </table>
            <%}//else %> <br>
            <a href="input.html">home</a>
            
<%!    public void jspDestroy(){
           //close jdbc objs
              try{
             if(rs!=null)
                  rs.close();
               }  
             catch(SQLException se){
                se.printStackTrace();
                 }
           
          try{
             if(ps1!=null)
                  ps1.close();
               }  
             catch(SQLException se){
                se.printStackTrace();
                 }
                 
              try{
             if(ps2!=null)
                  ps2.close();
               }  
             catch(SQLException se){
                se.printStackTrace();
                 }
                 
            try{
             if(con!=null)
                  con.close();
               }  
             catch(SQLException se){
                se.printStackTrace();
                 }
       }//method
    %>

                
    