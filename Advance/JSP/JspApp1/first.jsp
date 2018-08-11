<%! static{
            System.out.println("static block");
            }
		 public first_jsp(){
           System.out.println("constructor");
		 }
		 public void jspInit(){
            System.out.println("jspInit()");
		 }
		 %>

		 <%  System.out.println("_jspService(-,-)");  %>


hello..
