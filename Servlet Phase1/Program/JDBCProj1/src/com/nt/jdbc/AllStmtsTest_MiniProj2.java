/*SQL> select * from All_student;

       SNO SNAME                        M1         M2         M3
---------- --------------------         ---------- ---------- ----------
       101 raja                               90         89         45
       102 ravi                               23         45         45
       103 ramesh                         35         55         55
*/

/*CREATE OR REPLACE PROCEDURE P_FIND_PASS_FAIL(M1 IN NUMBER,M2 IN NUMBER,M3 IN NUMBER,RESULT OUT VARCHAR)AS
  BEGIN
     IF(M1<35 OR M2<35 OR M3<35)THEN
       RESULT:='FAILED';
     ELSE
       RESULT:='PASSS';
     END IF;
   END;
*/
package com.nt.jdbc;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AllStmtsTest_MiniProj2 extends JFrame implements ActionListener {
	private static final  String GET_ALL_SNOs="SELECT SNO FROM ALL_STUDENT";
	private static final String GET_STUDENT_DETAILS_BY_NO="SELECT SNO,SNAME,M1,M2,M3 FROM ALL_STUDENT WHERE SNO=?";
	private static final String  CALL_PROCEDURE="{ call  P_FIND_PASS_FAIL(?,?,?,?)}";
	
	private JLabel lno, lname, lm1, lm2, lm3,lres;
	private JComboBox tno;
	private JTextField tname, tm1, tm2, tm3, tresult;
	private JButton bDetails, bResult;
	private Connection con;
	private Statement st;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs1,rs2;
	

	public AllStmtsTest_MiniProj2() {
		System.out.println("constructor");
		setTitle("Mini Project--->1");
		setSize(300, 400);
		setBackground(Color.CYAN);
		setLayout(new FlowLayout());

		// prepare and add comps
		lno = new JLabel("Student number::");
		add(lno);
		tno = new JComboBox();
		add(tno);

		bDetails = new JButton("Details");
		bDetails.addActionListener(this);
		add(bDetails);

		lname = new JLabel("Student name::");
		add(lname);
		tname = new JTextField(10);
		add(tname);

		lm1 = new JLabel("Marks1::");
		add(lm1);
		tm1 = new JTextField(10);
		add(tm1);

		lm2 = new JLabel("Marks2::");
		add(lm2);
		tm2 = new JTextField(10);
		add(tm2);

		lm3 = new JLabel("Marks3::");
		add(lm3);
		tm3 = new JTextField(10);
		add(tm3);
		
		bResult=new JButton("Result");
		add(bResult);
		bResult.addActionListener(this);
		
		lres = new JLabel("Result::");
		add(lres);
		tresult = new JTextField(10);
		add(tresult);
		//Disable editing of TextBox comps
		tname.setEditable(false);
		tm1.setEditable(false);
		tm2.setEditable(false);
		tm3.setEditable(false);
		tresult.setEditable(false);
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing(-) method");
				//close jdbc objects
				try{
					if(rs1!=null)
						rs1.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}
				
				try{
					if(rs2!=null)
						rs2.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}
				
				try{
					if(cs!=null)
						cs.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}
				
				try{
					if(ps!=null)
						ps.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}
				
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
			}//method
		});
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initialize();
	}//constructor
	
	
	private void  initialize(){
		System.out.println("initialize()");
		try{
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create Statement object
			st=con.createStatement();
			//send  and execute SQL Query
			rs1=st.executeQuery(GET_ALL_SNOs);
			//copy snos from ResultSEt obj to ComboBox
			while(rs1.next()){
				tno.addItem(rs1.getInt(1));
			}
			//create PreparedSTatement object
			ps=con.prepareStatement(GET_STUDENT_DETAILS_BY_NO);
			//create CallableStatement object
			cs=con.prepareCall(CALL_PROCEDURE);
			//register OUT param with JDBC type
			cs.registerOutParameter(4,Types.VARCHAR);
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//initialize()

	public static void main(String[] args) {
		System.out.println("main method");
         new  AllStmtsTest_MiniProj2();
	}//main

	@Override
	public void actionPerformed(ActionEvent ae) {
      int no=0;
		System.out.println("actionPerformed(-)");
      
      if(ae.getSource()==bDetails){
    	  System.out.println("details button clicked");
    	  try{
    		//read selected item from combo box
    		  no=(int) tno.getSelectedItem();
    		  //set selected  sno to quuery param
    		  ps.setInt(1,no);
    		  //execute query
    		  rs2=ps.executeQuery();
    		  //get Record from ResultSEt and set to text boxes
    		  if(rs2.next()){
    			  tname.setText(rs2.getString(2));
    			  tm1.setText(rs2.getString(3));
    			  tm2.setText(rs2.getString(4));
    			  tm3.setText(rs2.getString(5));
    		  }//if
    	  }//try
    	  catch(SQLException se){
    		  se.printStackTrace();
    	  }
    	  catch(Exception e){
    		  e.printStackTrace();
    	  }
      }//if
      else{  //for ResultButton
    	  System.out.println("result button clicked");
    	  try{
    	  //get marks from text boxes and set to IN params
    	  cs.setInt(1, Integer.parseInt(tm1.getText()));
    	  cs.setInt(2,Integer.parseInt(tm2.getText()));
    	  cs.setInt(3,Integer.parseInt(tm3.getText()));
    	  //execute PL/SQL procedure
    	  cs.execute();
    	  //gather results from OUT param and set to Text box
    	  tresult.setText(cs.getString(4));
    	  }//try
    	  catch(SQLException se){
    		  se.printStackTrace();
    	  }
    	  catch(Exception e){
    		  e.printStackTrace();
    	  }
      }//else
	}//method
}//outer class
