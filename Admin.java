import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

public class Admin extends JFrame {

	private JPanel contentPane;
	JFrame frame = new JFrame();
	private JTable table_1;
	
	
	public Admin(String name, String username, int flag)
	{
		frame.getContentPane().setBackground(new Color(25, 25, 112));
		frame.setVisible(true);
		frame.setSize(600, 600);
		frame.getContentPane().setLayout(null);
		
		
		getContentPane().setBackground(new Color(25, 25, 112));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("View Users");
		btnNewButton.setBounds(130, 101, 117, 29);
		frame.getContentPane().add(btnNewButton);
		 btnNewButton.addActionListener(new ActionListener()
		  {
				public void actionPerformed(ActionEvent e)
				{
					frame.dispose();
					String[] args = {name, username, "1"};
					View.main(args);
					
				}
		  });
		
		
		JButton btnViewTrips = new JButton("View Trips");
		btnViewTrips.setBounds(418, 101, 117, 29);
		frame.getContentPane().add(btnViewTrips);
		btnViewTrips.addActionListener(new ActionListener()
		  {
				public void actionPerformed(ActionEvent e)
				{
					frame.dispose();
					String[] args = {name, username, "2"};
					View.main(args);
					
				}
		  });
		
		JButton btnViewBlogs = new JButton("View Blogs");
		btnViewBlogs.setBounds(251, 217, 117, 29);
		frame.getContentPane().add(btnViewBlogs);
		btnViewBlogs.addActionListener(new ActionListener()
		  {
				public void actionPerformed(ActionEvent e)
				{
					frame.dispose();
					String[] args = {name, username, "3"};
					View.main(args);
					
				}
		  });
		
		
		
		JButton btnLogOut = new JButton("");
		btnLogOut.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/Webp.net-resizeimage (5).jpg"));
		btnLogOut.setBounds(515, 6, 79, 38);
		frame.getContentPane().add(btnLogOut);
		
		JButton btnUpdateYourDetails = 	new JButton("Update Your Details");
		btnUpdateYourDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new Register(name, username, 2);
			}
		});
		btnUpdateYourDetails.setBounds(238, 358, 174, 29);
		frame.getContentPane().add(btnUpdateYourDetails);
		
		JLabel lblWelcome = new JLabel("Welcome " + name);
		lblWelcome.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblWelcome.setForeground(new Color(139, 0, 0));
		lblWelcome.setBounds(6, 6, 228, 29);
		frame.getContentPane().add(lblWelcome);
		btnLogOut.addActionListener(new ActionListener()
		  {
				public void actionPerformed(ActionEvent e)
				{
					frame.dispose();
					new User();
				}
		  });
		
		
		
		
		
	}
}
