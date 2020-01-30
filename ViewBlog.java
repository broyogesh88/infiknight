import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;


public class ViewBlog extends JFrame
{

	private JPanel contentPane;
	JLabel l1;
	
	JFrame frame = new JFrame("View Blog:");
	 
	public ViewBlog(String username,String name, String uname, String pname, int id, int page)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l1 = new JLabel("About this Blog:");
		l1.setForeground(new Color(165, 42, 42));
		l1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		l1.setBounds(209, 6, 208, 30);
		frame.getContentPane().add(l1);
		Statement stmt = First.query();
		try
		{
			ResultSet rs = stmt.executeQuery("SELECT title, experiences, about FROM blog WHERE id = '"+id+"'");
			
			while(rs.next())
			{
				String title = rs.getString(1);
				String experience = rs.getString(2);
				String about = rs.getString(3);
				
				JPanel panel = new JPanel();
				panel.setBounds(134, 81, 327, 376);
				frame.getContentPane().add(panel);
				panel.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("Title:");
				lblNewLabel.setBounds(18, 6, 61, 16);
				panel.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel(title);
				lblNewLabel_1.setBounds(68, 6, 239, 16);
				panel.add(lblNewLabel_1);
				
				
				
				JLabel lblAbout = new JLabel("About:");
				lblAbout.setBounds(18, 53, 61, 16);
				panel.add(lblAbout);
				
				JLabel lblExperience = new JLabel("Experience:");
				lblExperience.setBounds(18, 230, 85, 16);
				panel.add(lblExperience);
				
				
				
				JTextPane txtpane = new JTextPane();
				txtpane.setBounds(18, 81, 289, 137);
				panel.add(txtpane);
				txtpane.setEditable(false);
				txtpane.setText(about);
				
				JTextPane txtpane1 = new JTextPane();
				txtpane1.setBounds(18, 261, 289, 128);
				panel.add(txtpane1);
				txtpane1.setEditable(false);
				txtpane1.setText(experience);
			
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		frame.getContentPane().setBackground(new Color(25, 25, 112));
		
		frame.setSize(600, 600);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
		btnNewButton.setBounds(23, 8, 32, 28);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(477, 543, 117, 29);
		frame.getContentPane().add(btnHome);
		btnHome.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new Blogger(name,username, 20);
			}
		});
		
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new Blogger(name,username,7);
			}
		});
		
		if(username.equals(uname))
		{
			JButton btnEditThisBlog = new JButton("Edit this Blog");
			btnEditThisBlog.setBounds(235, 496, 117, 29);
			frame.getContentPane().add(btnEditThisBlog);
			btnEditThisBlog.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frame.dispose();
					new Blog(name, username,  7, 1, id);
				}
			});
		}
		
		
		frame.setVisible(true);
	}
}
