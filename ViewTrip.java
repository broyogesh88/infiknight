import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;

public class ViewTrip extends JFrame {

	private JPanel contentPane;
	JFrame frame = new JFrame();

	
	/**
	 * @wbp.parser.constructor
	 */
	public ViewTrip(String username, String name, int id, int page)
	{
		frame.setVisible(true);
		frame.setSize(600,600);
		frame.getContentPane().setLayout(null);
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
		
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
		button.setBounds(6, 6, 30, 29);
		frame.getContentPane().add(button);
		
		JButton btnViewInterested = new JButton("View Interested");
		btnViewInterested.setBounds(6, 543, 147, 29);
		frame.getContentPane().add(btnViewInterested);
		btnViewInterested.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				String[] arr = new String[3];
				arr[0] = Integer.toString(id);
				arr[1] = username;
				arr[2] = name;
				Details.main(arr);
			}
		});
		
		
		
		
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				if(page == 8)
					new AllTrips(username, name, 9);
				if(page == 2)
					new Blogger(name, username, 0);
			}
		});
		
		
		Statement stmt = First.query();
		
		
		
		try
		{
			ResultSet rs = stmt.executeQuery("SELECT username, source, destination, totaldays, budget, startdate, description, interested FROM trip WHERE id = '"+id+"'");
			while(rs.next())
			{
				String host = rs.getString(1);
				String source = rs.getString(2);
				String destination = rs.getString(3);
				int totaldays = rs.getInt(4);
				float budget = rs.getFloat(5);
				Date startdate = rs.getDate(6);
				String description = rs.getString(7);
				int interested = rs.getInt(8);
				
	
				
				
				JLabel lblSource = new JLabel("Trips Begins at: " + source);
				lblSource.setBounds(138, 92, 377, 16);
				frame.getContentPane().add(lblSource);
				lblSource.setForeground(new Color(255, 255, 255));
				
				JLabel lbldate = new JLabel("Trips Begins from: " + startdate);
				lbldate.setBounds(138, 134, 302, 16);
				frame.getContentPane().add(lbldate);
				lbldate.setForeground(new Color(255, 255, 255));
				
				JLabel lblNewLabel = new JLabel("Total Days: " + totaldays);
				lblNewLabel.setBounds(138, 320, 267, 16);
				frame.getContentPane().add(lblNewLabel);
				lblNewLabel.setForeground(new Color(255, 255, 255));
				
				JLabel lblTripTo = new JLabel("Trip to " + destination);
				lblTripTo.setBounds(221, 6, 197, 16);
				frame.getContentPane().add(lblTripTo);
				lblTripTo.setForeground(new Color(255, 255, 255));
				
				JLabel lblTripIsHosted = new JLabel("You are Hosting this Trip..");
				lblTripIsHosted.setBounds(138, 34, 253, 16);
				frame.getContentPane().add(lblTripIsHosted);
				lblTripIsHosted.setForeground(new Color(255, 255, 255));
				
				JLabel lblAboutTheTrip = new JLabel("About this Trip:");
				lblAboutTheTrip.setBounds(138, 174, 115, 16);
				frame.getContentPane().add(lblAboutTheTrip);
				lblAboutTheTrip.setForeground(new Color(255, 255, 255));
				
				JTextPane textPane = new JTextPane();
				textPane.setBounds(138, 202, 280, 90);
				textPane.setText(description);
				textPane.setEditable(false);
				frame.getContentPane().add(textPane);
				
				JLabel lblApproxBudget = new JLabel("Approx Budget: " + budget);
				lblApproxBudget.setBounds(138, 355, 267, 39);
				frame.getContentPane().add(lblApproxBudget);
				lblApproxBudget.setForeground(new Color(255, 255, 255));
				
				JLabel lblNoOfInterested = new JLabel("No. of Interested People: " + interested);
				lblNoOfInterested.setBounds(138, 421, 280, 16);
				frame.getContentPane().add(lblNoOfInterested);
				lblNoOfInterested.setForeground(new Color(255, 255, 255));
				
				}
		
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		
		
	}
	
	
	public ViewTrip(String username, String name, String user, int id, int page)
	{
		getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setSize(600,600);
		frame.getContentPane().setLayout(null);
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
		
		
		JButton button = new JButton("");
		button.setBounds(6, 6, 28, 32);
		button.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
		frame.getContentPane().add(button);
		
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				if(page == 8)
					new AllTrips(username, name, id, 9);
				if(page == 2)
					new Blogger(name, username, 9);
			}
		});
		
		
		Statement stmt = First.query();
		Statement newstmt = First.query();
		Statement statement = First.query();
		try
		{
			ResultSet rs = stmt.executeQuery("SELECT username, source, destination, totaldays, budget, startdate, description, interested FROM trip WHERE id = '"+id+"'");
			while(rs.next())
			{
				String host = rs.getString(1);
				ResultSet res = newstmt.executeQuery("SELECT firstname, lastname FROM user WHERE username = '"+host+"'");
				while(res.next())
				{
					host = res.getString(1) + " " + res.getString(2);
				}
				String source = rs.getString(2);
				String destination = rs.getString(3);
				int totaldays = rs.getInt(4);
				float budget = rs.getFloat(5);
				Date startdate = rs.getDate(6);
				String description = rs.getString(7);
				int interested = rs.getInt(8);
				
	
				
				
				JLabel lblSource = new JLabel("Trips Begins at: " + source);
				lblSource.setBounds(138, 92, 377, 16);
				frame.getContentPane().add(lblSource);
				lblSource.setForeground(new Color(255, 255, 255));
				
				JLabel lbldate = new JLabel("Trips Begins from: " + startdate);
				lbldate.setBounds(138, 134, 302, 16);
				frame.getContentPane().add(lbldate);
				lbldate.setForeground(new Color(255, 255, 255));
				
				JLabel lblNewLabel = new JLabel("Total Days: " + totaldays);
				lblNewLabel.setBounds(138, 320, 267, 16);
				frame.getContentPane().add(lblNewLabel);
				lblNewLabel.setForeground(new Color(255, 255, 255));
				
				JLabel lblTripTo = new JLabel("Trip to " + destination);
				lblTripTo.setBounds(221, 6, 197, 16);
				frame.getContentPane().add(lblTripTo);
				lblTripTo.setForeground(new Color(255, 255, 255));
				
				JLabel lblTripIsHosted = new JLabel("Trip is Hosted by: " + host);
				lblTripIsHosted.setBounds(138, 34, 253, 16);
				frame.getContentPane().add(lblTripIsHosted);
				lblTripIsHosted.setForeground(new Color(255, 255, 255));
				
				JLabel lblAboutTheTrip = new JLabel("About this Trip:");
				lblAboutTheTrip.setBounds(138, 174, 115, 16);
				frame.getContentPane().add(lblAboutTheTrip);
				lblAboutTheTrip.setForeground(new Color(255, 255, 255));
				
				JTextPane textPane = new JTextPane();
				textPane.setBounds(138, 202, 280, 90);
				textPane.setText(description);
				textPane.setEditable(false);
				frame.getContentPane().add(textPane);
				
				JLabel lblApproxBudget = new JLabel("Approx Budget: " + budget);
				lblApproxBudget.setBounds(138, 355, 267, 39);
				frame.getContentPane().add(lblApproxBudget);
				lblApproxBudget.setForeground(new Color(255, 255, 255));
				
				JLabel lblNoOfInterested = new JLabel("No. of Interested People: " + interested);
				lblNoOfInterested.setBounds(138, 421, 280, 16);
				frame.getContentPane().add(lblNoOfInterested);
				lblNoOfInterested.setForeground(new Color(255, 255, 255));
				int going = 0;
				ResultSet newres = statement.executeQuery("SELECT username FROM futuretrip WHERE tripid = '"+id+"'");
				while(newres.next())
				{
					if(newres.getString(1).equals(username))
					{
						going = 1;
					}
				}
				if(going == 0)
				{
							JLabel lblAreYouInterested = new JLabel("Are you Interested ?");
							lblAreYouInterested.setBounds(118, 478, 133, 16);
							frame.getContentPane().add(lblAreYouInterested);
							lblAreYouInterested.setForeground(new Color(255, 255, 255));
							JButton btnAreYouInterested = new JButton("Add to List");
							btnAreYouInterested.setBounds(259, 473, 97, 29);
							frame.getContentPane().add(btnAreYouInterested);
							
							btnAreYouInterested.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e)
								{
									int number = interested + 1;
									frame.dispose();
									try
									{
										stmt.execute("UPDATE trip SET interested = '"+number+"' WHERE id = '"+id+"'");
										newstmt.execute("INSERT INTO futuretrip (username, tripid) VALUES ('"+username+"','"+id+"')");
									}
									catch (SQLException e1)
									{
										e1.printStackTrace();
									}
									new ViewTrip(username, name, user, id, 8);
								}
							});
					}
					else
					{
						JLabel lblAreYouInterested = new JLabel("You are going to this Trip..");
						lblAreYouInterested.setFont(new Font("Apple Chancery", Font.PLAIN, 16));
						lblAreYouInterested.setBounds(189, 475, 258, 32);
						frame.getContentPane().add(lblAreYouInterested);
						lblAreYouInterested.setForeground(new Color(139, 0, 0));
					}	
				}
		
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		
		
	}
}
