package com.nt.jdbc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GUIScrollFrame {
   private static final String GET_ALL_STUDENTS="SELECT  SNO,SNAME,SADD FROM STUDENT";
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIScrollFrame window = new GUIScrollFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIScrollFrame() {
		initialize();
		initializeJdbc();
	}
	
	private void initializeJdbc(){
		try{
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			ps=con.prepareStatement(GET_ALL_STUDENTS,
					                                          ResultSet.TYPE_SCROLL_SENSITIVE,
					                                          ResultSet.CONCUR_UPDATABLE);
			rs=ps.executeQuery();
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//initializeJdbc()

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudentnumber = new JLabel("StudentNumber");
		lblStudentnumber.setBounds(29, 33, 106, 16);
		frame.getContentPane().add(lblStudentnumber);
		
		textField = new JTextField();
		textField.setBounds(148, 30, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Student Name");
		lblNewLabel.setBounds(39, 66, 96, 16);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 63, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("student address");
		lblNewLabel_1.setBounds(29, 112, 96, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(148, 109, 116, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("First");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					rs.first();
					textField.setText(rs.getString(1));
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));
				}//try
				catch(SQLException se){ se.printStackTrace();}
			}
		});
		btnNewButton.setBounds(38, 166, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(!rs.isLast()){
						rs.next();
					textField.setText(rs.getString(1));
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));
					}
				}//try
				catch(SQLException se){ se.printStackTrace();}
			}
		});
		btnNewButton_1.setBounds(214, 166, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Previous");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try{
					if(!rs.isFirst()){
						rs.previous();
					textField.setText(rs.getString(1));
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));
					}
				}//try
				catch(SQLException se){ se.printStackTrace();}
				
			}
		});
		btnNewButton_2.setBounds(38, 204, 97, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Last");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
						rs.last();
					textField.setText(rs.getString(1));
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));
				}//try
				catch(SQLException se){ se.printStackTrace();}
				
			}
		});
		btnNewButton_3.setBounds(224, 204, 97, 25);
		frame.getContentPane().add(btnNewButton_3);
	}

}
