import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class Forgot extends JFrame {

	private JPanel contentPane;
	JFrame frame = new JFrame();
	private JTextField textField;
	private JTextField textField_1;

	public Forgot(String username, String contact)
	{
		frame.getContentPane().setBackground(new Color(25, 25, 112));
		frame.setVisible(true);
		frame.setSize(600, 600);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Statement stmt = First.query();
		
		try
		{
			ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE username = '"+username+"' AND contact = '"+contact+"'");
			
			if(rs.next())
			{
				  
				textField = new JPasswordField();
				textField.setBounds(273, 74, 130, 26);
				frame.getContentPane().add(textField);
				textField.setColumns(10);
				
				JLabel lblUsername = new JLabel("New Password:");
				lblUsername.setForeground(new Color(255, 255, 255));
				lblUsername.setBounds(153, 79, 120, 16);
				frame.getContentPane().add(lblUsername);
				
				
				
				JLabel lblContactNo = new JLabel("Confirm Password:");
				lblContactNo.setForeground(new Color(255, 255, 255));
				lblContactNo.setBounds(153, 131, 130, 16);
				frame.getContentPane().add(lblContactNo);
				
				textField_1 = new JPasswordField();
				textField_1.setBounds(273, 131, 130, 26);
				frame.getContentPane().add(textField_1);
				textField_1.setColumns(10);
				
				JButton btnSubmit = new JButton("Change Password");
				btnSubmit.setBounds(239, 186, 83, 29);
				frame.getContentPane().add(btnSubmit);
				btnSubmit.addActionListener(new ActionListener()
				  {
						public void actionPerformed(ActionEvent e)
						{
							String password = textField.getText();
							String confirm = textField_1.getText();
							if(password.length() == 0 || confirm.length() == 0)
							{
								JOptionPane.showMessageDialog(btnSubmit,"Empty Fields",
									      "Error",JOptionPane.ERROR_MESSAGE);
							}
							else if(password.equals(confirm))
							{
								try
								{
									stmt.execute("UPDATE user SET password = '"+password+"' WHERE username = '"+username+"'");
									JOptionPane.showMessageDialog(btnSubmit,"Password Change Successful..",
										      "Error",JOptionPane.ERROR_MESSAGE);
									frame.dispose();
									new User();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							else
							{
								JOptionPane.showMessageDialog(btnSubmit,"Password Mismatched..",
									      "Error",JOptionPane.ERROR_MESSAGE);
							}
							
						}
				  });
			
				
			}
			else
			{
				JOptionPane.showMessageDialog(this,"No Such Username & Contact no. Exist..",
					      "Error",JOptionPane.ERROR_MESSAGE);
				frame.dispose();
				new Forgot();
				
			}
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	public Forgot()
	{
		frame.getContentPane().setBackground(new Color(25, 25, 112));
		frame.setVisible(true);
		frame.setSize(600, 600);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		textField = new JTextField();
		textField.setBounds(274, 74, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBounds(153, 79, 120, 16);
		frame.getContentPane().add(lblUsername);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(239, 186, 83, 29);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblContactNo = new JLabel("Contact No.:");
		lblContactNo.setForeground(new Color(255, 255, 255));
		lblContactNo.setBounds(153, 131, 130, 16);
		frame.getContentPane().add(lblContactNo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(274, 126, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnSubmit.addActionListener(new ActionListener()
		  {
				public void actionPerformed(ActionEvent e)
				{
					String username = textField.getText();
					String contact = textField_1.getText();
					if(username.length() == 0 || contact.length() == 0)
					{
						JOptionPane.showMessageDialog(btnSubmit,"Empty Fields..",
							      "Error",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						frame.dispose();
						new Forgot(username, contact);
					}
					
				}
		  });
		
		
		
	}

}
