package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TxMgmtTest_TransferMoney {

	public static void main(String[] args) {
		Scanner sc=null;
		int srcNo=0,destNo=0,amount=0;
         Connection con=null;
         Statement st=null;
         int result[]=null;
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter Source Account Number::");
				srcNo=sc.nextInt();
				System.out.println("Enter Dest Account Number::");
				destNo=sc.nextInt();
				System.out.println("Enter Amount to transfer::");
				amount=sc.nextInt();
			}//if
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//Begin Trasaction
			if(con!=null)
				con.setAutoCommit(false);
			//create STatement object
			if(con!=null)
				st=con.createStatement();
			
			if(st!=null){
			//add the Queries to the batch
			  //for withdraw operation
			st.addBatch("update jdbc_Account set balance=balance-"+amount+" where acno="+srcNo);
			//for deposite operation
			st.addBatch("update jdbc_Account set balance=balance+"+amount+" where acno="+destNo);
			}
			//execute the Batch
			if(st!=null){
				result=st.executeBatch();
			}
			//Perform Transaction management
			boolean flag=false;
			for(int i=0;i<result.length;++i){
				 if(result[i]==0){
					 flag=true;
					 break;
				 }//if
			}//for
			if(flag==true){
				con.rollback(); //rollback the Tx
				System.out.println("Money Not Transffered (Tx is rolledBack)");
			}
			else{
				con.commit(); //commit the Tx
				System.out.println("Money Transffered (Tx is Committed)");
			}
		}//try
		catch(SQLException se){
			try{
			con.rollback();
			}
			catch(SQLException se1){
				 se1.printStackTrace();
			}
			se.printStackTrace();
		}
		catch(Exception e){
			try{
				con.rollback();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			try{
				if(st!=null)
					st.close();
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
			
			try{
				if(sc!=null)
					sc.close();
			}
			catch(Exception se){
				se.printStackTrace();
			}
			
		}//finally
	}//main
}//class
