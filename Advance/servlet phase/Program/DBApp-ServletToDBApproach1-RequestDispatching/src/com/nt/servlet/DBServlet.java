package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;  //jdbc api.


public class DBServlet extends HttpServlet
{
	private static  final String  GET_EMP_DETAILS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
     private Connection con;
	 private PreparedStatement ps;
	 
	public void init(){
		try{
			//register driver class(type4 oracle thin driver)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
            //create PrpearedStatement object
			ps=con.prepareStatement(GET_EMP_DETAILS);
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//init()

	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		   PrintWriter pw=null;
		   int no=0;
		   ResultSet rs=null;
		   RequestDispatcher rd=null,rd1=null,rd2=null;
		   ServletContext sc=null;
             //general settings
			 pw=res.getWriter();
			 res.setContentType("text/html");
			 try{
				//header content
				 rd1=req.getRequestDispatcher("/headerurl");
				 rd1.include(req,res);
			//read form data
			no=Integer.parseInt(req.getParameter("eno"));
			//write jdbc code to execute Query
				//set value to query param (?)
                  ps.setInt(1,no);
				//execute the Query
				rs=ps.executeQuery();
				//process the ResultSet
				pw.println("<h1> Emplyoyee Details are </h1>");
				if(rs.next()!=false){
                   pw.println("<h3>emp number::"+rs.getInt(1)+"</h3>");
				    pw.println("<h3>emp name::"+rs.getString(2)+"</h3>");
					 pw.println("<h3>emp job::"+rs.getString(3)+"</h3>");
					  pw.println("<h3>emp Salary::"+rs.getInt(4)+"</h3>");
					   pw.println("<h3>Dept number::"+rs.getInt(5)+"</h3>");
				}//if
				else{
                  pw.println("<h1 style='color:red;text-align:center'>Employee not found</h1>");
				}
				pw.println("<a href='input.html'>home</a>");
				//Footer content
				rd2=req.getRequestDispatcher("/footer.html");
			
				rd2.include(req, res);
				//close strem
				pw.close();

	 		}//try
			catch(Exception e){
				System.out.println("before rd.forward(-,-)");
				pw.println("<b> before rd.forward(-,-)</b>");
				
				rd=req.getRequestDispatcher("errurl");
				pw.close();
				rd.forward(req,res);
				System.out.println("after rd.forward(-,-)");
				pw.println("<b> after rd.forward(-,-)</b>");
				e.printStackTrace();
			}
			finally{
				try{
				 if(rs!=null)
				 	rs.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}
			}//finally
		}//doGet(-,-)

		public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
           doGet(req,res);
		}

		public void destroy(){
				try{
				 if(ps!=null)
				 	ps.close();
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
		}//destroy
}//class