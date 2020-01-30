import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;


public class Register extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8;
	 JTextField tf1,tf2,tf4,tf3,tfl;
	 JButton btn1;
	 JPasswordField p2, p1;
	 ButtonGroup Type = new ButtonGroup();
	 JRadioButton t1, t2, t3;
	 
	 JFrame frame = new JFrame("Registration Form");
	 private JLabel lblGender;
	 private JButton btnNewButton;
	 
	 private JLabel lblPresentAddress;
	 private JTextField textField;
	 private JLabel lblContactNo;
	 private JTextField textField_1;
	 private JTextPane tf5;
	
	 
	 Register(String nam, String username, int page)
	 {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.getContentPane().setBackground(new Color(25, 25, 112));
		  frame.setVisible(true);
		  frame.setSize(600, 600);
		  frame.getContentPane().setLayout(null);
		  
		  btnNewButton = new JButton("");
		  btnNewButton.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
		  btnNewButton.setBounds(20, 8, 30, 29);
		  frame.getContentPane().add(btnNewButton);
		  if(page == 2)
		  {
			  btnNewButton.addActionListener(new ActionListener()
			  {
				  	public void actionPerformed(ActionEvent ae)
					 {
				  		frame.dispose();
				  		if(username.equals("broyogesh88"))
							new Admin(nam, username, 12);
						else
							new Blogger(nam, username, 12);
					 }
			  });
			  
		  }
		 ResultSet rs;
		 Statement stmt = First.query();
		 try {
			rs = stmt.executeQuery("SELECT firstname, lastname, email, username, password, about, gender, contact, tempaddress FROM user WHERE username = '"+username+"'");
			if(rs.next())
			{
				String first = rs.getString(1);
				String last = rs.getString(2);
				String email = rs.getString(3);
				String uname = rs.getString(4);
				String password = rs.getString(5);
				String about = rs.getString(6);
				String gender = rs.getString(7);
				String contact = rs.getString(8);
				String address = rs.getString(9);
				
				l1 = new JLabel("Registration..");
				  l1.setForeground(new Color(165, 42, 42));
				  l1.setFont(new Font("Serif", Font.BOLD, 20));
				
				  l2 = new JLabel("First Name: ");
				  l2.setForeground(new Color(255, 255, 255));
				  l2.setBackground(new Color(255, 255, 255));
				  l3 = new JLabel("Last Name:");
				  l3.setForeground(new Color(255, 255, 255));
				  l4 = new JLabel("Email:");
				  l4.setForeground(new Color(255, 255, 255));
				  l5 = new JLabel("Username:");
				  l5.setForeground(new Color(255, 255, 255));
				  l6 = new JLabel("Password:");
				  l6.setForeground(new Color(255, 255, 255));
				  l7 = new JLabel("Confirm Password:");
				  l7.setForeground(new Color(255, 255, 255));
				  l8 = new JLabel("About:");
				  l8.setForeground(new Color(255, 255, 255));
				  tf1 = new JTextField();
				  tf1.setText(first);
				  tf4 = new JTextField();
				  tf4.setText(uname);
				  tf4.setEditable(false);
				  tf3 = new JTextField();
				  tf3.setText(email);
				  
				  tfl = new JTextField();
				  tfl.setText(last);
				  p2 = new JPasswordField();
				  p1 = new JPasswordField();
				  p1.setText(password);
				  p2.setText(password);
				  btn1 = new JButton("Update");
				  
				  l1.setBounds(224, 0, 173, 30);
				  l2.setBounds(80, 48, 89, 30);
				  l3.setBounds(80, 90, 77, 30);
				  l4.setBounds(80, 132, 71, 30);
				  l5.setBounds(80, 174, 77, 30);
				  l6.setBounds(80, 222, 77, 30);
				  l7.setBounds(80, 264, 132, 30);
				  l8.setBounds(80, 460, 89, 30);
				  tf1.setBounds(224, 48, 200, 30);
				  tf4.setBounds(224, 174, 200, 30);
				  tf3.setBounds(224, 132, 200, 30);
				  tfl.setBounds(224, 90, 200, 30);
				  p2.setBounds(224, 264, 200, 30);
				  p1.setBounds(224, 222, 200, 30);
				  btn1.setBounds(224, 531, 100, 30);
				
				  frame.getContentPane().add(l1);
				  frame.getContentPane().add(l2);
				  frame.getContentPane().add(l3);
				  frame.getContentPane().add(l4);
				  frame.getContentPane().add(l5);
				  frame.getContentPane().add(l6);
				  frame.getContentPane().add(l7);
				  frame.getContentPane().add(l8);
				  frame.getContentPane().add(tf1);
				  
				  frame.getContentPane().add(tf4);
				  frame.getContentPane().add(tf3);
				  frame.getContentPane().add(tfl);
				  frame.getContentPane().add(p2);
				  frame.getContentPane().add(p1);
				  frame.getContentPane().add(l3);
				  frame.getContentPane().add(btn1);
				  
				  lblPresentAddress = new JLabel("Present Address:");
				  lblPresentAddress.setForeground(new Color(255, 255, 255));
				  lblPresentAddress.setBounds(80, 362, 132, 16);
				  frame.getContentPane().add(lblPresentAddress);
				  
				  textField = new JTextField();
				  textField.setBounds(224, 364, 200, 30);
				  frame.getContentPane().add(textField);
				  textField.setColumns(10);
				  textField.setText(address);
				  
				  lblContactNo = new JLabel("Contact No. :");
				  lblContactNo.setForeground(new Color(255, 255, 255));
				  lblContactNo.setBounds(80, 414, 100, 16);
				  frame.getContentPane().add(lblContactNo);
				  
				  textField_1 = new JTextField();
				  textField_1.setBounds(224, 409, 197, 30);
				  frame.getContentPane().add(textField_1);
				  textField_1.setColumns(10);
				  textField_1.setText(contact);
				  
				  tf5 = new JTextPane();
				  tf5.setBounds(224, 460, 200, 49);
				  frame.getContentPane().add(tf5);
				  tf5.setText(about);
				
				  t1 = new JRadioButton("Male");
				  t1.setForeground(new Color(255, 255, 255));
				  t2 = new JRadioButton("Female");
				  t2.setForeground(new Color(255, 255, 255));
				  t3 = new JRadioButton("Others");
				  t3.setForeground(new Color(255, 255, 255));
				  Type.add(t1);
				  Type.add(t2);
				  Type.add(t3);
				  
				  t1.setBounds(301, 316, 77, 23);
				  frame.getContentPane().add(t1);
				  t2.setBounds(224, 316, 77, 23);
				  frame.getContentPane().add(t2);
				  t3.setBounds(364, 316, 77, 23);
				  frame.getContentPane().add(t3);
				  if(gender.equals("Male"))
				  {
					  t1.setSelected(true);
				  }
				  else if(gender.equals("Female"))
				  {
					  t2.setSelected(true);
				  }
				  else if(gender.equals("Others"))
				  {
					  t3.setSelected(true);
				  }
				  
				  
				  btn1.addActionListener(new ActionListener()
				  {
					  	public void actionPerformed(ActionEvent ae)
						 {
					  		String fname = tf1.getText();
							String lname = tfl.getText();
							String emai = tf3.getText();
							String pass = p2.getText();
							String cpass = p1.getText();
							String abo = tf5.getText();
							String add = textField.getText();
							String con = textField_1.getText();
							String gen = "None";
							int empty = 0;
							
							if(fname.length() == 0 || lname.length() == 0 || email.length() == 0 || uname.length() == 0 || pass.length() == 0 || cpass.length() == 0 || about.length() == 0 || address.length() == 0 || contact.length() == 0)
								empty = 1;
							
							int check = 0;
							if(t1.isSelected())
								gen = "Male";
							else if(t2.isSelected())
								gen = "Female";
							else if(t3.isSelected())
								gen = "Others";
							else
								check = 1;
						
							
							Statement stmt = First.query();
							int flag1 = 0, flag2 = 0;
							
							if(flag2 == 1 || check == 1 || empty == 1)
							{
								if(empty == 1)
									JOptionPane.showMessageDialog(btn1,"Please fill the Empty fields..",
									      "Error",JOptionPane.ERROR_MESSAGE);
								else if(check == 1)
									JOptionPane.showMessageDialog(btn1,"Please Select your Gender..",
										      "Error",JOptionPane.ERROR_MESSAGE);
								else
									JOptionPane.showMessageDialog(btn1,"Sorry this email has already registered..",
										      "Error",JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								if(fname.length() != 0 && email.length() != 0 && pass.length() != 0 && pass.equals(cpass) && about.length() > 25 )
								{
									try
									{
										
										stmt.execute("UPDATE user SET firstname = '"+fname+"', lastname = '"+lname+"', email = '"+emai+"', password = '"+pass+"', about = '"+abo+"', gender = '"+gen+"', contact = '"+con+"', tempaddress = '"+add+"' WHERE username = '"+username+"'");
										String name = fname + " " + lname;
										frame.dispose();
										if(username.equals("broyogesh88"))
											new Admin(name, username, 1);
										else
											new Blogger(name, username, 1);
									}
									
									catch(Exception e)
									{
										System.out.print(e);
									}
									
									
								}
								else
								{
									JOptionPane.showMessageDialog(btn1,"Mismatch",
										      "Error",JOptionPane.ERROR_MESSAGE); 
								}
							}
						 }
				  });
				  
				  
				  
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 
		 
		 
	 }
	 
	 
	 
	 /**
	  * @wbp.parser.constructor
	  */
	 Register(int page)
	 {
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.getContentPane().setBackground(new Color(25, 25, 112));
		  frame.setVisible(true);
		  frame.setSize(600, 600);
		  frame.getContentPane().setLayout(null);
		  
		  l1 = new JLabel("Registration..");
		  l1.setForeground(new Color(165, 42, 42));
		  l1.setFont(new Font("Serif", Font.BOLD, 20));
		
		  l2 = new JLabel("First Name: ");
		  l2.setForeground(new Color(255, 255, 255));
		  l2.setBackground(new Color(255, 255, 255));
		  l3 = new JLabel("Last Name:");
		  l3.setForeground(new Color(255, 255, 255));
		  l4 = new JLabel("Email:");
		  l4.setForeground(new Color(255, 255, 255));
		  l5 = new JLabel("Username:");
		  l5.setForeground(new Color(255, 255, 255));
		  l6 = new JLabel("Password:");
		  l6.setForeground(new Color(255, 255, 255));
		  l7 = new JLabel("Confirm Password:");
		  l7.setForeground(new Color(255, 255, 255));
		  l8 = new JLabel("About:");
		  l8.setForeground(new Color(255, 255, 255));
		  tf1 = new JTextField();
		  tf4 = new JTextField();
		  tf3 = new JTextField();
		  tfl = new JTextField();
		  p2 = new JPasswordField();
		  p1 = new JPasswordField();
		  btn1 = new JButton("Register");
		 
		  l1.setBounds(224, 0, 173, 30);
		  l2.setBounds(80, 48, 89, 30);
		  l3.setBounds(80, 90, 77, 30);
		  l4.setBounds(80, 132, 71, 30);
		  l5.setBounds(80, 174, 77, 30);
		  l6.setBounds(80, 222, 77, 30);
		  l7.setBounds(80, 264, 132, 30);
		  l8.setBounds(80, 460, 89, 30);
		  tf1.setBounds(224, 48, 200, 30);
		  tf4.setBounds(224, 174, 200, 30);
		  tf3.setBounds(224, 132, 200, 30);
		  tfl.setBounds(224, 90, 200, 30);
		  p2.setBounds(224, 264, 200, 30);
		  p1.setBounds(224, 222, 200, 30);
		  btn1.setBounds(224, 531, 100, 30);
		
		  frame.getContentPane().add(l1);
		  frame.getContentPane().add(l2);
		  frame.getContentPane().add(l3);
		  frame.getContentPane().add(l4);
		  frame.getContentPane().add(l5);
		  frame.getContentPane().add(l6);
		  frame.getContentPane().add(l7);
		  frame.getContentPane().add(l8);
		  frame.getContentPane().add(tf1);
		  
		  frame.getContentPane().add(tf4);
		  frame.getContentPane().add(tf3);
		  frame.getContentPane().add(tfl);
		  frame.getContentPane().add(p2);
		  frame.getContentPane().add(p1);
		  frame.getContentPane().add(l3);
		  frame.getContentPane().add(btn1);
		  
		  
		  t1 = new JRadioButton("Male");
		  t1.setForeground(new Color(255, 255, 255));
		  t2 = new JRadioButton("Female");
		  t2.setForeground(new Color(255, 255, 255));
		  t3 = new JRadioButton("Others");
		  t3.setForeground(new Color(255, 255, 255));
		  Type.add(t1);
		  Type.add(t2);
		  Type.add(t3);
		  
		  t1.setBounds(301, 316, 77, 23);
		  frame.getContentPane().add(t1);
		  t2.setBounds(224, 316, 77, 23);
		  frame.getContentPane().add(t2);
		  t3.setBounds(364, 316, 77, 23);
		  frame.getContentPane().add(t3);
		  frame.getContentPane().setForeground(Color.WHITE);
		  lblGender = new JLabel("Gender:");
		  lblGender.setForeground(new Color(255, 255, 255));
		  lblGender.setBounds(80, 320, 61, 16);
		  frame.getContentPane().add(lblGender);
		  
		  
		  
		  lblPresentAddress = new JLabel("Present Address:");
		  lblPresentAddress.setForeground(new Color(255, 255, 255));
		  lblPresentAddress.setBounds(80, 362, 132, 16);
		  frame.getContentPane().add(lblPresentAddress);
		  
		  textField = new JTextField();
		  textField.setBounds(224, 364, 200, 30);
		  frame.getContentPane().add(textField);
		  textField.setColumns(10);
		  
		  lblContactNo = new JLabel("Contact No. :");
		  lblContactNo.setForeground(new Color(255, 255, 255));
		  lblContactNo.setBounds(80, 414, 100, 16);
		  frame.getContentPane().add(lblContactNo);
		  
		  textField_1 = new JTextField();
		  textField_1.setBounds(224, 409, 197, 30);
		  frame.getContentPane().add(textField_1);
		  textField_1.setColumns(10);
		  
		  tf5 = new JTextPane();
		  tf5.setBounds(224, 460, 200, 49);
		  frame.getContentPane().add(tf5);
		  
		  btnNewButton = new JButton("");
		  btnNewButton.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
		  btnNewButton.setBounds(20, 8, 30, 29);
		  frame.getContentPane().add(btnNewButton);
		  if(page == 1)
		  {
			  btnNewButton.addActionListener(new ActionListener()
			  {
				  	public void actionPerformed(ActionEvent ae)
					 {
				  		frame.dispose();
				  		new User();
					 }
			  });
			  
		  }
		  btn1.addActionListener(this);
		  
	 }
	 
	 
	 public void actionPerformed(ActionEvent ae)
	 {
		String fname = tf1.getText();
		String lname = tfl.getText();
		String email = tf3.getText();
		String uname = tf4.getText();
		String pass = p2.getText();
		String cpass = p1.getText();
		String about = tf5.getText();
		String address = textField.getText();
		String contact = textField_1.getText();
		String gender = "None";
		int empty = 0;
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calobj = Calendar.getInstance();
		String date = df.format(calobj.getTime());
		
		if(fname.length() == 0 || lname.length() == 0 || email.length() == 0 || uname.length() == 0 || pass.length() == 0 || cpass.length() == 0 || about.length() == 0 || address.length() == 0 || contact.length() == 0)
			empty = 1;
		
		int check = 0;
		if(t1.isSelected())
			gender = "Female";
		else if(t2.isSelected())
			gender = "Male";
		else if(t3.isSelected())
			gender = "Others";
		else
			check = 1;
	
		
		Statement stmt = First.query();
		int flag1 = 0, flag2 = 0;
		
		try
		{
				ResultSet rs = stmt.executeQuery("SELECT username, email FROM user");
				while(rs.next())
				{
					if(rs.getString(1).equals(uname))
					{
						flag1 = 1;
					}
					if(rs.getString(2).equals(email))
					{
						flag2 = 1;
					}
				}
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		if(flag1 == 1 || flag2 == 1 || check == 1 || empty == 1)
		{
			if(empty == 1)
				JOptionPane.showMessageDialog(this,"Please fill the Empty fields..",
				      "Error",JOptionPane.ERROR_MESSAGE);
			else if(flag1 == 1)
				JOptionPane.showMessageDialog(this,"Sorry the username has already been taken..",
				      "Error",JOptionPane.ERROR_MESSAGE);
			else if(check == 1)
				JOptionPane.showMessageDialog(this,"Please Select your Gender..",
					      "Error",JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(this,"Sorry this email has already registered..",
					      "Error",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			if(fname.length() != 0 && email.length() != 0 && pass.length() != 0 && pass.equals(cpass) && about.length() > 25 )
			{
				try
				{
					
					stmt.execute("INSERT INTO user (firstname, lastname, email, username, password, about, registrationdate, gender, contact, tempaddress) VALUES ('"+fname+"','"+lname+"','"+ email+"','"+uname+"','"+ pass +"','"+ about+"','"+ date +"','"+ gender +"','"+contact+"','"+ address+"')");
					frame.dispose();
					String name = fname + " " + lname;
					new Blogger(name, uname);
				}
				
				catch(Exception e)
				{
					System.out.print(e);
				}
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Mismatch",
					      "Error",JOptionPane.ERROR_MESSAGE); 
			}
		}

	 }

}


/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Welcome extends JFrame implements ActionListener
{
	  Welcome()
	  {
	    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	    setTitle("Welcome");
	    setSize(400, 200);
	  }

	public void actionPerformed(ActionEvent e)
	{
	
		
	}
 }
*/
