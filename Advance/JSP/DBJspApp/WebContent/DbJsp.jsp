<%@page import="java.sql.*" %>
<%!
	Connection con;
	PreparedStatement ps1, ps2;
	ResultSet rs;

	public void jspInit() {

		try {
		
			ServletConfig cg = getServletConfig();
			String s1 = cg.getInitParameter("driver");
			String s2 = cg.getInitParameter("url");
			String s3 = cg.getInitParameter("user");
			String s4 = cg.getInitParameter("pwd");

			Class.forName(s1);
			con = DriverManager.getConnection(s2, s3, s4);

			ps1 = con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?)");

			ps2 = con.prepareStatement("SELECT * FROM STUDENT");

		} catch (SQLException se) {
			se.printStackTrace();

		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}%>

<%
String pval=request.getParameter("s1");
if(pval.equals("register")){
	int no=Integer.parseInt(request.getParameter("tno"));
	
	String name=request.getParameter("tname");
	String addrs=request.getParameter("tadd");
	
	ps1.setInt(1,no);
	ps1.setString(2,name);
	ps1.setString(3,addrs);
	
	int result =ps1.executeUpdate();
	
	if(result==0){
	%><!-- //2 -->
<b>Registration Failed</b>
<%}/* 3 */
	/* 3 */else{%>
<b>Registration Success</b>
<%}/* 4 */
	
	}
	
	else {
	ResultSet rs=ps2.executeQuery();
	
	ResultSetMetaData rsmd=rs.getMetaData();
/* 4 */	%>

<table border='1'>
	<tr>
		<!-- 5 --><%  for(int i=1;	i<=rsmd.getColumnCount();	++i){%><!-- 5 -->
		<td><%=/* 6 */ rsmd.getColumnLabel(i)%><!-- 6 --></td>
		<!-- 7 --><%}%><!-- 7 -->

	</tr>
	<% /* 8 */
			while(rs.next()){%><!-- 8 -->
	<tr>

		<!-- 9 --><%for(int i=1;	i<=rsmd.getColumnCount();++i) {%><!-- 9 -->
		<td><!-- 10 --><%= rs.getString(i) %><!-- 10 --></td>
		<!-- 11 --><%} %><!-- 11 -->
	</tr>
	<!-- 12 --><%}
			     %><!-- 12 -->
			     </table>
			     <!-- 13 --><% } %><!-- 13 -->
	<a href='Input.html'>GET Back HomePage</a>
	
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
	
	
	
	