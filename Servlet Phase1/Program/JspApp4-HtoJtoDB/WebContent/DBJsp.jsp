<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
  private  static final String INSERT_STUDENT="INSERT INTO STUDENT VALUES(?,?,?)";
  private static final String   GET_STUDENTS="SELECT SNO,SNAME,SADD FROM STUDENT";
    Connection con;
    PreparedStatement ps1=null,ps2=null;
    ResultSet rs=null;
   public void jspInit(){
     String driver=null,url=null,dbuser=null,dbpwd=null;
      ServletConfig cg=null;
      //get Accesss to ServletConfig object
      cg=getServletConfig();
      //read init param values
      driver=cg.getInitParameter("driverClass");
      url=cg.getInitParameter("url");
      dbuser=cg.getInitParameter("dbuser");
      dbpwd=cg.getInitParameter("dbpwd");
      try{
          //register jdbc driver
          Class.forName(driver);
          //Establish the connection
          con=DriverManager.getConnection(url,dbuser,dbpwd);
          //create PreparedStatement objs
           ps1=con.prepareStatement(INSERT_STUDENT);
          ps2=con.prepareStatement(GET_STUDENTS);
      }//try
      catch(SQLException se){
         se.printStackTrace();
       }
       catch(Exception e){
           e.printStackTrace();
       }
   }//jspInit() method
 %>
  <%
      //read s1 req param value
      String pval=request.getParameter("s1");
      if(pval.equalsIgnoreCase("register")){
          int no=Integer.parseInt(request.getParameter("sno"));
          String  name=request.getParameter("sname");
          String addrs=request.getParameter("sadd");
          //set values query params using ps1
          ps1.setInt(1,no);
          ps1.setString(2,name);
          ps1.setString(3,addrs);
          //execute the Query
          int result=ps1.executeUpdate();
          //process the Result
          if(result==0){ %>
             <h1 style="color:red;text-align:center">Registration Failed</h1>
          <% }//if
               else{ %>
                 <h1 style="color:red;text-align:center">Registraion Succeded</h1>
                 <% }//else
                   }//if
                   else{   //for hyperlink
                      //execute Select Query represented by ps2
                      rs=ps2.executeQuery();
                      ResultSetMetaData rsmd=rs.getMetaData();
                      int colCount=rsmd.getColumnCount(); %>
                        <table border="1">
                          <tr>
                      <% for(int i=1;i<=colCount;++i){  %>
                           <th><%=rsmd.getColumnLabel(i) %> </th>
                          <%} %> 
                           </tr>
                          <!-- print col values --> 
                         <% while(rs.next()){ %>
                            <tr>
                             <%for(int i=1;i<=colCount;++i){ %>
                                   <td><%=rs.getString(i) %> </td>
                               <%  }//for   %>
                               </tr>
                           <%}///while
                           }//else%>
                           </table> 
                           <br>
             <a href='input.html'>home</a>              
    <%!
       public void jspDestroy(){
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
       
       }//jspDestroy()
     %>                           
                  
 

