package com.nt.jdbc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdk.nashorn.internal.ir.CatchNode;

public class CLOBRetriveTwR {
	private static final String GET_STUDENT_BY_NO="SELECT STNO,STNAME,STADD,STRESUME FROM STUDENTALL WHERE STNO=?";
	public static void main(String[] args) {
		int no=0;
	
		int sno=0;
		String name=null,addrs=null;
		char[] buffer=null;
		int charsRead=0;
		
		//read inputs
			try(Scanner sc=new Scanner(System.in)){
				System.out.println("Enter Student Number:::");
				no=sc.nextInt();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager")){
				try( PreparedStatement ps=con.prepareStatement(GET_STUDENT_BY_NO)){
					  ps.setInt(1, no);
					try(ResultSet rs=ps.executeQuery()){
						if(rs.next()){
					    sno=rs.getInt(1);
					    name=rs.getString(2);
					    addrs=rs.getString(3);
					    try(Reader	reader=rs.getCharacterStream(4)){
					    	buffer=new char[1024];
					    	try(Writer writer=new FileWriter("e:/my_resume1.txt")){
					    		while((charsRead=reader.read(buffer))!=-1){
					    			writer.write(buffer,0,charsRead);
					    		}
					    		System.out.println("Resume retrived and other details");
					    		System.out.println(sno+"  "+name+"  "+addrs);
					    	}//try
					    		catch(IOException ioe){
					    			ioe.printStackTrace();
					    		}
					    	}//try
					    	catch(IOException ioe){
					    		ioe.printStackTrace();
					    	}
						}//if
						else{
							System.out.println("record not found");
						}
							
					    }//try
					    catch(SQLException se){
					    	se.printStackTrace();
					    }
					}//try
					catch(SQLException se){
						se.printStackTrace();
					}
				}//try
				catch(SQLException se){
					se.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
				}
		}//main
}//class
