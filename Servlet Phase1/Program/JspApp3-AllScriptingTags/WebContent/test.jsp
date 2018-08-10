<%! public void jspInit(){
         ServletConfig cg=getServletConfig();
           ServletContext sc=getServletContext();
        System.out.println("p1 init param value::"+cg.getInitParameter("p1"));
        System.out.println("c1 init param value::"+sc.getInitParameter("c1"));
        Object o1=this;
        System.out.println("p1 init param value::"+o1.getClass());
     }
 %>


p1 init param value :: <%=config.getInitParameter("p1") %> <br>
c1 context param value :: <%=application.getInitParameter("c1") %>