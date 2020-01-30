import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;

public class SearchResult extends JFrame
{

	private JPanel contentPane;
	JFrame frame = new JFrame();
	
	public SearchResult(String text, String name, String username)
	{
		getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
		btnNewButton.setBounds(6, 6, 29, 22);
		frame.getContentPane().add(btnNewButton);
		
		
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new Blogger(name, username, 5);
			}
		});
		
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
		
		
		try
		{
			Statement stmt = First.query();
			ResultSet rs = stmt.executeQuery("SELECT firstname, lastname, username,about, account FROM user WHERE firstname LIKE '%"+text+"%' OR lastname  LIKE '%"+text+"%'");
			
			int x2 = 84;
			int checkpeople = 0;
			while(rs.next())
			{
				String uname = rs.getString(3);
				if(!username.equals(uname) && !uname.equals("broyogesh88") && rs.getInt(5) != 0)
				{
					checkpeople = 1;
					String peoplename = rs.getString(1) + " " + rs.getString(2);
					String about = rs.getString(4);
					JPanel panel = new JPanel();
					panel.setBorder(new CompoundBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "People", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
					panel.setBounds(92, x2, 322, 146);
					frame.getContentPane().add(panel);
					panel.setLayout(null);
					
					JLabel lblName = new JLabel("Name:");
					lblName.setBounds(17, 30, 55, 16);
					panel.add(lblName);
					
					JLabel lblAbout = new JLabel("About:");
					lblAbout.setBounds(17, 62, 61, 16);
					panel.add(lblAbout);
					
					JLabel lblNewLabel = new JLabel(peoplename);
					lblNewLabel.setBounds(126, 30, 141, 16);
					panel.add(lblNewLabel);
					
					JLabel lblNewLabel_1 = new JLabel(about);
					lblNewLabel_1.setBounds(126, 62, 190, 16);
					panel.add(lblNewLabel_1);
					
					JButton btnViewPeople = new JButton("View People");
					btnViewPeople.setBounds(100, 111, 117, 29);
					panel.add(btnViewPeople);
					btnViewPeople.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							frame.dispose();
							try
							{
								new People(text, username, name, uname, peoplename);
							}
							catch (SQLException e1)
							{
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					x2 = x2 + 165;
					
				}
		
			}
			if(checkpeople == 0)
			{
				JLabel lblNoUsersAre = new JLabel("No Users are currently registered with this name ");
				lblNoUsersAre.setFont(new Font("Zapfino", Font.PLAIN, 18));
				lblNoUsersAre.setForeground(new Color(220, 20, 60));
				lblNoUsersAre.setBounds(46, 133, 535, 47);
				frame.getContentPane().add(lblNoUsersAre);
				
				JLabel lblTryAnotherName = new JLabel("try another name or use proper Keyword");
				lblTryAnotherName.setFont(new Font("Zapfino", Font.PLAIN, 18));
				lblTryAnotherName.setForeground(new Color(178, 34, 34));
				lblTryAnotherName.setBounds(108, 172, 429, 47);
				frame.getContentPane().add(lblTryAnotherName);
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		frame.getContentPane().setBackground(new Color(25, 25, 112));
		
	
		
		frame.setSize(600,600);
		frame.setVisible(true);
	}
}
