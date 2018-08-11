
<%! public  void jspInit(){
   //get Access to ServletConfig ,ServletContext objs directly using Servlet api
      ServletContext sc=getServletContext();
      ServletConfig cg=getServletConfig();
      System.out.println("sc obj class name::"+sc.getClass());
      System.out.println("cg obj class name ::"+cg.getClass());
      
       System.out.println("p1 inti param value::"+cg.getInitParameter("p1"));
       System.out.println("p2 p2 context param value::"+sc.getInitParameter("p2"));
       try{
       Class.forName("oracle.jdbc.driver.OracleDriver");
       }
       catch(Exception e){
       e.printStackTrace();
       }

 } %>
 
 hello
