import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AllTrips extends JFrame {

	private JPanel contentPane;
	JFrame frame = new JFrame();
	
	
	public AllTrips(String username, String name, int page)
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setSize(600,600);
		frame.getContentPane().setBackground(new Color(25, 25, 112));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
		btnNewButton.setBounds(6, 6, 28, 29);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new Blogger(name, username, 8);
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
		
		
		
		JLabel lblTrips = new JLabel("Your Trips..");
		lblTrips.setForeground(new Color(165, 42, 42));
		lblTrips.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTrips.setBounds(248, 17, 224, 34);
		frame.getContentPane().add(lblTrips);
		
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		
		Statement stmt = First.query();
		try
		{
			ResultSet rs = stmt.executeQuery("SELECT id, username, destination, startdate from trip WHERE username = '"+username+"'");
			int x = 73;
			int check = 0;
			while(rs.next())
			{
				int tripid = rs.getInt(1);
				String uname = rs.getString(2);
				
				if(rs.getDate(4).after(date) && uname.equals(username))
				{
					check = 1;
					JPanel panel = new JPanel();
					panel.setBounds(106, x, 416, 71);
					frame.getContentPane().add(panel);
					panel.setBorder(new CompoundBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Upcoming Trips..", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
					panel.setLayout(null);
					
					JLabel lblNewLabel = new JLabel("Trip to " + rs.getString(3));
					lblNewLabel.setBounds(6, 30, 383, 16);
					panel.add(lblNewLabel);
					
					JButton btnViewTrip = new JButton("View Trip");
					btnViewTrip.setBounds(299, 36, 117, 29);
					panel.add(btnViewTrip);
					btnViewTrip.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							frame.dispose();
							new ViewTrip(username, name, tripid, 8);
						}
					});
					
					x = x + 100;
					
				}	
				
			}
			if(check == 0)
			{
				
				JLabel lblYouAreNot = new JLabel("You are not Hosting any Future Trips...");
				lblYouAreNot.setForeground(new Color(255, 255, 255));
				lblYouAreNot.setFont(new Font("Papyrus", Font.PLAIN, 20));
				lblYouAreNot.setBounds(160, 165, 378, 29);
				frame.getContentPane().add(lblYouAreNot);
				
				JButton btnAddTrips = new JButton("Add Trips");
				btnAddTrips.setBounds(257, 209, 117, 29);
				frame.getContentPane().add(btnAddTrips);
				btnAddTrips.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						frame.dispose();
						new Trip(name, username);
					}
				});
				
				
			}
		
		}
		catch (SQLException e1)
		{
			
			e1.printStackTrace();
		}
		
		
		
	}
	
	public AllTrips(String text, String username, String name, String user, String pname)
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setSize(600,600);
		frame.getContentPane().setBackground(new Color(25, 25, 112));
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
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
		btnNewButton.setBounds(6, 6, 28, 29);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				try {
					new People(text, username, name, user,pname);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		JLabel lblTrips = new JLabel("Person Trips..");
		lblTrips.setForeground(new Color(165, 42, 42));
		lblTrips.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTrips.setBounds(248, 17, 224, 34);
		frame.getContentPane().add(lblTrips);
		
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		
		Statement stmt = First.query();
		try
		{
			ResultSet rs = stmt.executeQuery("SELECT id, username, destination, startdate from trip WHERE username = '"+user+"'");
			int x = 73;
			int check = 0;
			while(rs.next())
			{
				int tripid = rs.getInt(1);
				if(rs.getDate(4).after(date))
				{
					check = 1;
					JPanel panel = new JPanel();
					panel.setBounds(106, x, 416, 71);
					frame.getContentPane().add(panel);
					panel.setBorder(new CompoundBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Upcoming Trips..", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
					panel.setLayout(null);
					
					JLabel lblNewLabel = new JLabel("Trip to " + rs.getString(3));
					lblNewLabel.setBounds(6, 30, 383, 16);
					panel.add(lblNewLabel);
					
					JButton btnViewTrip = new JButton("View Trip");
					btnViewTrip.setBounds(299, 36, 117, 29);
					panel.add(btnViewTrip);
					btnViewTrip.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							frame.dispose();
								new ViewTrip(username, name, tripid, 8);
						}
					});
					
					x = x + 100;
					
				}	
				
			}
			if(check == 0)
			{
				
				JLabel lblYouAreNot = new JLabel("This Person is not Hosting any Future Trips...");
				lblYouAreNot.setForeground(new Color(255, 255, 255));
				lblYouAreNot.setFont(new Font("Papyrus", Font.PLAIN, 20));
				lblYouAreNot.setBounds(160, 165, 378, 29);
				frame.getContentPane().add(lblYouAreNot);
				
				JButton btnAddTrips = new JButton("Add Trips");
				btnAddTrips.setBounds(257, 209, 117, 29);
				frame.getContentPane().add(btnAddTrips);
				btnAddTrips.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						frame.dispose();
						new Trip(name, username);
					}
				});
				
				
			}
		
		}
		catch (SQLException e1)
		{
			
			e1.printStackTrace();
		}
		
		
		
	}
	
	public AllTrips(String username, String name, int id, int page)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setSize(600,600);
		frame.getContentPane().setBackground(new Color(25, 25, 112));
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
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
		btnNewButton.setBounds(6, 6, 28, 29);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new Blogger(name, username, 8);
			}
		});
		
		JLabel lblTrips = new JLabel("Others Trips..");
		lblTrips.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTrips.setBounds(264, 17, 224, 16);
		frame.getContentPane().add(lblTrips);
		
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		
		Statement stmt = First.query();
		try
		{
			ResultSet rs = stmt.executeQuery("SELECT id, username, destination, startdate from trip");
			int x = 73;
			int check = 0;
			while(rs.next())
			{
				int tripid = rs.getInt(1);
				String uname = rs.getString(2);
				if(rs.getDate(4).after(date) && !uname.equals(username))
				{
					check = 1;
					JPanel panel = new JPanel();
					panel.setBounds(106, x, 416, 71);
					frame.getContentPane().add(panel);
					panel.setBorder(new CompoundBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Upcoming Trips..", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
					panel.setLayout(null);
					
					JLabel lblNewLabel = new JLabel("Trip to " + rs.getString(3));
					lblNewLabel.setBounds(6, 30, 383, 16);
					panel.add(lblNewLabel);
					
					JButton btnViewTrip = new JButton("View Trip");
					btnViewTrip.setBounds(299, 36, 117, 29);
					panel.add(btnViewTrip);
					btnViewTrip.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							frame.dispose();
							new ViewTrip(username, name, uname, tripid, 8);
						}
					});
					
					x = x + 100;
					
				}
			
			}
			if(check == 0)
			{
				JLabel lblYouAreNot = new JLabel("No any Future Trips to show...");
				lblYouAreNot.setForeground(new Color(255, 255, 255));
				lblYouAreNot.setFont(new Font("Papyrus", Font.PLAIN, 20));
				lblYouAreNot.setBounds(160, 165, 378, 29);
				frame.getContentPane().add(lblYouAreNot);
				
				JButton btnAddTrips = new JButton("Add Trips");
				btnAddTrips.setBounds(257, 209, 117, 29);
				frame.getContentPane().add(btnAddTrips);
				btnAddTrips.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						frame.dispose();
						new Trip(name, username);
					}
				});
			}
		
		}
		catch (SQLException e1)
		{
			
			e1.printStackTrace();
		}
		
		
		
	}

}
