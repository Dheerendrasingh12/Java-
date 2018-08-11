<%@page import="java.sql.*"%>

<%!
	Connection con;
	PreparedStatement ps1,ps2;
	ResultSet rs;
	
	public void jspinit(){
	
	try{
		ServletConfig cg=getServletConfig();
		String s1=cg.getInitParameter("driver");
		String s2=cg.getInitParameter("url");
		String s3=cg.getInitParameter("user");
		String s4=cg.getInitParameter("pwd");
		
		Class.forName(s1);
		
		con=DriverManager.getConnection(s2,s3,s4);
		ps1=con.prepareStatement("INSERT INTO CUSTOMER_SI VALUES (?,?,?)");
		ps2=con.prepareStatement("SELECT * FROM CUSTOMER_SI");
		}catch(SQLException se){
		se.printStackTrace();
		}catch(ClassNotFoundException cnf){
		cnf.printStackTrace();
		}catch(Exception e){
		e.printStackTrace();
		}			

}//jspinit
%>

<%
	String pval=request.getParameter("c1");
	if(pval.equals("register")){

	int no=Integer.parseInt(request.getParameter("tno"));
	String name=request.getParameter("tname");
	double princ=Double.parseDouble(request.getParameter("tprin"));
	double rate=Double.parseDouble(request.getParameter("trate"));
	double time=Double.parseDouble(request.getParameter("time"));

	
	double	si=princ*rate*time/100;
	
	ps1.setInt(1,no);
	ps1.setString(2,name);
	ps1.setDouble(3,princ);
	ps1.setDouble(4,rate);
	ps1.setDouble(5, time);
	ps1.setDouble(6, si);	
	
	int result=ps1.executeUpdate();	
	
	if(result==0){%>
	<i><b>Registration Failed</b></i>
	<%}
	else{
	 %>
	<i><b>Registration Successed</b></i>
	 <%
	 }
	}
	else{
	
	ResultSet rs=ps2.executeQuery();
	
	ResultSetMetaData rsmd=rs.getMetaData();
	
	%>
	<table border='1'>
	<tr>
	<% for(int i=0;	i<rsmd.getColumnCount();	++i) {%>
	<td><%= rsmd.getColumnLabel(i) %></td>
	<%} %>
	</tr>
	<%
		while(rs.next()){%>
	 <tr>
	 <%for(int i=0;i<rsmd.getColumnCount();	++i) {%>
	 
	 <td><%= rs.getString(i) %></td>
	 
	 <%} %>
	 </tr>
	 <%} 
	 %>
	 </table>
	 
	 <%} %>
	 <a href='form.html'>Back To Home</a>
	 
		<%! public void jspDestroy(){  
	
	try{
	if(rs!=null)
	rs.close();
	
	}catch(Exception e){
	e.printStackTrace();
	}
	try{
	if(ps1!=null)
	ps1.close();
	
	}
	catch(Exception e){
	e.printStackTrace();
	}
	
	try{
	if(ps2!=null)
	ps2.close();
	
	}
	catch(Exception e){
	e.printStackTrace();
	}
	try{
	if(con!=null)
	con.close();
	
	}
	catch(Exception e){
	e.printStackTrace();
	}
	}
	%>
	
	
	
	