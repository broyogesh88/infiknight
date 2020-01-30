import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Blogger extends JFrame implements ActionListener
{

	private JPanel contentPane;
	JLabel j1, j2, j3;
	JFrame frame = new JFrame("Welcome Page:");
	JTextField tf1;
	private JTextField txtSearch;
	JLabel notify;
	int pgid = 0;
	
	
	public Blogger(String name, String username)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		j1 = new JLabel("Welcome " + name);
		j1.setForeground(new Color(255, 255, 255));
		j1.setBounds(232, 6, 255, 30);
		frame.getContentPane().add(j1);
		frame.getContentPane().setBackground(new Color(25, 25, 112));
		frame.setSize(600, 600);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);;
		JLabel lblYourAccountIs = new JLabel("Your Account is not yet Activated.. Please contact 9593327905...");
		lblYourAccountIs.setForeground(new Color(255, 255, 255));
		lblYourAccountIs.setBounds(109, 121, 409, 16);
		frame.getContentPane().add(lblYourAccountIs);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/Webp.net-resizeimage (5).jpg"));
		button.setBounds(247, 170, 86, 38);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new User();
			}
		});
		
		
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public Blogger(String name, String username, int page)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		j1 = new JLabel("Welcome " + name);
		j1.setForeground(new Color(255, 255, 255));
		j1.setBounds(198, 12, 228, 30);
		frame.getContentPane().add(j1);
		frame.getContentPane().setBackground(new Color(25, 25, 112));
		frame.setSize(600, 600);
		frame.getContentPane().setLayout(null);
		
		JButton btnWriteABlog = new JButton("Write a Blog");
		btnWriteABlog.setBounds(6, 241, 117, 29);
		btnWriteABlog.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new Blog(name, username, 2, 0, 0);
			}
		});
		
		frame.getContentPane().add(btnWriteABlog);
		
		JButton btnAddYourNext = new JButton("Add new Trip");
		btnAddYourNext.setBounds(477, 241, 117, 29);
		frame.getContentPane().add(btnAddYourNext);
		btnAddYourNext.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new Trip(name, username); 
				
			}
		});
		
		JButton btnSignOut = new JButton("");
		btnSignOut.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/signout.jpg"));
		btnSignOut.setBounds(464, 48, 80, 36);
		frame.getContentPane().add(btnSignOut);
		
		txtSearch = new JTextField();
		txtSearch.setToolTipText("search");
		txtSearch.setBounds(251, 58, 130, 26);
		frame.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/Webp.net-resizeimage copy.png"));
		btnSearch.setBounds(393, 54, 33, 30);
		frame.getContentPane().add(btnSearch);
		
		
		
		JLabel lblSearchPeople = new JLabel("Search People");
		lblSearchPeople.setForeground(new Color(255, 255, 255));
		lblSearchPeople.setBounds(145, 63, 99, 16);
		frame.getContentPane().add(lblSearchPeople);
		
		
		JButton btnViewYourBlogs = new JButton("View Your blogs");
		btnViewYourBlogs.setBounds(6, 305, 167, 29);
		frame.getContentPane().add(btnViewYourBlogs);
		
		JButton btnSeeUpcomingTrips = new JButton("See Upcoming Trips");
		btnSeeUpcomingTrips.setBounds(212, 374, 169, 29);
		frame.getContentPane().add(btnSeeUpcomingTrips);
		
		JButton btnViewYourTrips = new JButton("View your Trips");
		btnViewYourTrips.setBounds(427, 305, 167, 29);
		frame.getContentPane().add(btnViewYourTrips);
		
		JPanel panel = new JPanel();
		panel.setBounds(198, 243, 204, 91);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("**notifications**");
		lblNewLabel.setBounds(50, 5, 104, 16);
		panel.add(lblNewLabel);
		
		notify = new JLabel("");
		notify.setBounds(6, 33, 167, 16);
		panel.add(notify);
		
		JLabel notify_1 = new JLabel("");
		notify_1.setBounds(6, 58, 167, 16);
		panel.add(notify_1);
		
		JButton btnUpdateYourDetails = new JButton("Update Your Details");
		btnUpdateYourDetails.setBounds(212, 456, 155, 29);
		frame.getContentPane().add(btnUpdateYourDetails);
		Statement stmntt = First.query();
		ResultSet rstt;
		try {
			rstt = stmntt.executeQuery("SELECT registrationdate FROM user WHERE username = '"+username+"'");
			if(rstt.next())
			{	
				JLabel lblJoinedOn = new JLabel("Joined on: " + rstt.getString(1));
				lblJoinedOn.setForeground(new Color(127, 255, 0));
				lblJoinedOn.setBounds(393, 19, 155, 16);
				frame.getContentPane().add(lblJoinedOn);
			}
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		
	
	
		btnUpdateYourDetails.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new Register(name, username, 2);
			}
		});
		
		
		
		btnViewYourTrips.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new AllTrips(username, name, 2);
			}
		});
		
		btnSeeUpcomingTrips.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new AllTrips(username, name, 2, 0);
			}
		});
		
		btnViewYourBlogs.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new AllBlogs(username, name, username, name, 3);
			}
		});
		
		Statement stmt = First.query();
		ResultSet rs2;
		
		try {
			rs2 = stmt.executeQuery("SELECT profilepic, picupload FROM user WHERE username = '"+username+"'");
			if(rs2.next())
			{
				
				if(rs2.getInt(2) == 0)
				{
					JButton btnAddProfilePic = new JButton("Add Profile Pic");
					
					btnAddProfilePic.setBounds(6, 17, 80, 80);
					frame.getContentPane().add(btnAddProfilePic);
					btnAddProfilePic.addActionListener(new ActionListener()
					  {
							public void actionPerformed(ActionEvent e)
							{
								frame.dispose();
								new AddProfilePic(name, username);
								
							}
					  });
				}
				else
				{
					JButton pic = new JButton("");
					pic.setIcon(new ImageIcon(rs2.getString(1)));
					pic.setBounds(21, 32, 102, 89);
					frame.getContentPane().add(pic);
					JButton btnChangePic = new JButton("Change Pic");
					btnChangePic.setBounds(16, 123, 105, 29);
					frame.getContentPane().add(btnChangePic);
					btnChangePic.addActionListener(new ActionListener()
					  {
							public void actionPerformed(ActionEvent e)
							{
								frame.dispose();
								new AddProfilePic(name, username);
								
							}
					  });
	
				}
				
				
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		btnSearch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String text = txtSearch.getText();
				if(text.length() == 0)
					JOptionPane.showInputDialog("Empty Search Fields");
				else
				{
					frame.dispose();
					new SearchResult(text, name, username);
				}
			}
		});
		
		
		btnSignOut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new User();
			}
		});
		
		if(page != 0)
		{
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/next.png"));
			
			btnNewButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frame.dispose();
					if(page == 1)
						new Blog(name, username, 2, 0, 0);
					else if(page == 4)
						new Trip(name, username);
					else if(page == 5)
					{
						String text = txtSearch.getText();
						new SearchResult(text, name, username);
					}
					else if(page == 6)
						new AllBlogs(username, name, username, name, 3);
					else if(page == 8)
						new AllTrips(name, username, 2, 0);
					else if(page == 12)
						new Register(name, username, 2);
					else if(page == 13)
						new AddProfilePic(name, username);
					
				}
			});
			btnNewButton.setBounds(555, 12, 27, 30);
			frame.getContentPane().add(btnNewButton);
		}
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		Statement stmnt = First.query();
		try
		{
			int max = 0;
			int secondmax = 0;
			int flag = 0;
			int t1 = 0, t2 = 0;
			ResultSet rs = stmnt.executeQuery("SELECT id, interested FROM trip");
			while(rs.next())
			{
				if(rs.getInt(2) > max)
				{
					max = rs.getInt(2);
					t1  = rs.getInt(1);
				}
				
			}
			
			rs = stmnt.executeQuery("SELECT id, interested FROM trip WHERE id <> '"+t1+"'");
			while(rs.next())
			{
				if(rs.getInt(2) > secondmax)
				{
					secondmax = rs.getInt(2);
					t2  = rs.getInt(1);
				}
				
			}
			if(t1 != 0)
			{
				rs = stmnt.executeQuery("SELECT username, destination, startdate, interested FROM trip WHERE id = '"+t1+"'");
				if(rs.next())
				{
					Date tripdate = rs.getDate(3);
					int tripid = t1;
					String unam = rs.getString(1);
					if(tripdate.after(date))
					{

						notify.setText("View about trip to " + rs.getString(2));
						JButton check_1 = new JButton("");
						check_1.setBounds(185, 33, 16, 16);
						panel.add(check_1);
						check_1.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/next.png"));
						check_1.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								frame.dispose();
								if(unam.equals(username))
									new ViewTrip(username,name,tripid, 2);
								else
									new ViewTrip(username,name, unam,tripid, 2);
							}
							
						});
					}
				}
			}
			if(t2 != 0)
			{
				rs = stmnt.executeQuery("SELECT username, destination, startdate, interested FROM trip WHERE id = '"+t2+"'");
				if(rs.next())
				{
					Date tripdate = rs.getDate(3);
					int tripid = t2;
					String unam = rs.getString(1);
					if(tripdate.after(date))
					{
						notify_1.setText("View about trip to " + rs.getString(2));
						JButton check_2 = new JButton("");
						check_2.setBounds(185, 58, 16, 16);
						panel.add(check_2);
						check_2.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/next.png"));
						check_2.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								frame.dispose();
								if(unam.equals(username))
									new ViewTrip(username,name, tripid, 2);
								else
									new ViewTrip(username,name,unam, tripid, 2);
							}
							
						});
						
					}
				}
				
			}
			if(t1 == 0)
				notify.setText("No Notifications..");
		}
		
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		
		
		
		
		
		frame.setVisible(true);
		
}
	 public void actionPerformed(ActionEvent e)
	 {
	      
	 }
}
