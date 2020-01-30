import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class User extends JFrame implements ActionListener 
{

	
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try
				{
					new User();
				}
				
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	 JLabel lblDontHaveAn;
	 JButton btnSignUp;
	 JFrame frame = new JFrame("Login Form");
	 JLabel lblFollowing;
	 private JButton btnSignup;
	 private JLabel lblCreateAccount;
	 private JButton button;
	 private JPasswordField textpass;
	 private JTextField textuser;
	 private JLabel lblUser;
	 private JLabel lblPass;
	 private JLabel lblLoginForm;
	 private JButton btnForgotPassword;
	 
	 
	public User()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  
		 
		  
		  frame.getContentPane().setBackground(new Color(25, 25, 112));
		  frame.setVisible(true);
		  frame.setSize(600, 600);
		  frame.getContentPane().setLayout(null);
		  
		  
		  
		  lblCreateAccount = new JLabel("Don't have account ?");
		  lblCreateAccount.setForeground(new Color(165, 42, 42));
		  lblCreateAccount.setFont(new Font("Kokonor", Font.PLAIN, 20));
		  lblCreateAccount.setBounds(197, 354, 200, 25);
		  frame.getContentPane().add(lblCreateAccount);
		  
		  btnSignup = new JButton("");
		  btnSignup.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/Webp.net-resizeimage-2.jpg"));
		  btnSignup.setBounds(239, 391, 107, 103);
		  frame.getContentPane().add(btnSignup);
		  btnSignup.addActionListener(new ActionListener()
		  {
				public void actionPerformed(ActionEvent e)
				{
					frame.dispose();
					new Register(1);
					
				}
		  });
		  textpass = new JPasswordField();
		  textpass.setBounds(197, 188, 200, 31);
		  frame.getContentPane().add(textpass);
		  textpass.setColumns(10);
		  
		  textuser = new JTextField();
		  textuser.setBounds(197, 138, 200, 31);
		  frame.getContentPane().add(textuser);
		  textuser.setColumns(10);
		  
		  lblUser = new JLabel("Username:");
		  lblUser.setForeground(new Color(255, 255, 255));
		  lblUser.setBounds(91, 145, 92, 16);
		  frame.getContentPane().add(lblUser);
		  
		  lblPass = new JLabel("Password:");
		  lblPass.setForeground(new Color(255, 255, 255));
		  lblPass.setBounds(91, 195, 104, 16);
		  frame.getContentPane().add(lblPass);
		  
		  lblLoginForm = new JLabel("Login Form");
		  lblLoginForm.setForeground(new Color(255, 69, 0));
		  lblLoginForm.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		  lblLoginForm.setBounds(214, 19, 158, 45);
		  frame.getContentPane().add(lblLoginForm);
		  
		  button = new JButton("");
		  button.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/Webp.net-resizeimage.jpg"));
		  button.setBounds(239, 247, 107, 39);
		  frame.getContentPane().add(button);
		  
		  btnForgotPassword = new JButton("Forgot Password");
		  btnForgotPassword.setBounds(226, 298, 133, 29);
		  frame.getContentPane().add(btnForgotPassword);
		  btnForgotPassword.addActionListener(new ActionListener()
		  {
				public void actionPerformed(ActionEvent e)
				{
					frame.dispose();
					new Forgot();
					
				}
		  });
		  
		  
		  button.addActionListener(this);
		  
	}
	
	public void actionPerformed(ActionEvent ae)
		 {
	 
		   String uname = textuser.getText();
		   String pass = textpass.getText();
		   if(uname.length() == 0 || pass.length() == 0)
		   {
			 JOptionPane.showMessageDialog(this,"Empty Fields..",
			      "Error", JOptionPane.ERROR_MESSAGE);
		   }
		   else
		   {
			   int flag = 0;
			   String name = "default";
			   String username = "uname";
			   int account = 0;
			   Statement stmt = First.query();
				try
				{
						ResultSet rs = stmt.executeQuery("SELECT firstname, lastname, username, password, account FROM user");
						while(rs.next())
						{
							if(rs.getString(3).equals(uname) && rs.getString(4).equals(pass))
							{
								flag = 1;
								name = rs.getString(1) + " " + rs.getString(2);
								username = rs.getString(3);
								account = rs.getInt(5);	
							}
						}
						if(flag == 1 && username.equals("broyogesh88"))
						{
							frame.dispose();
							
							new Admin(name, username, 0);
						}
						
						else if(flag == 1 )
						{
							frame.dispose();
							if(account == 1)
								new Blogger(name, username, 0);
							else
								new Blogger(name, username);
						}
						
						else
					    {
							frame.dispose();
							JOptionPane.showMessageDialog(new User(), "Sorry Username doesn't exist");
					    }
				}
				
				catch (SQLException e)
				{
					
					e.printStackTrace();
				}
		   }
			      
		  }
	
	
}