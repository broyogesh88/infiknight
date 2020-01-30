import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class People extends JFrame {

	private JPanel contentPane;
	JFrame frame = new JFrame();
	
	public People(String text, String username, String name, String user, String pname) throws SQLException
	{
		getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
		btnNewButton.setBounds(6, 6, 26, 22);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new SearchResult(text, name, username);
			}
		});
		
		
		Statement stmt = First.query();
		ResultSet rs = null;
		try
		{
			rs = stmt.executeQuery("SELECT id, follower, following, date FROM favourites WHERE follower = '"+username+"' AND following = '"+user+"'");
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		
		if(!rs.next())
		{
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Calendar calobj = Calendar.getInstance();
			String date = df.format(calobj.getTime());
			
			JButton btnAddToFavourites = new JButton("Add to Favourites");
			btnAddToFavourites.setBounds(450, 29, 144, 16);
			frame.getContentPane().add(btnAddToFavourites);
			btnAddToFavourites.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						stmt.execute("INSERT INTO favourites (follower, following, date) VALUES('"+username+"','"+user+"','"+date+"')");
						frame.dispose();
						new People(text, username, name, user, pname);
							   
					}
					catch(SQLException e1)
					{
						e1.printStackTrace();
					}
					
				}
			});
		}
		else
		{
		
			JLabel lbl = new JLabel("Following Since: " + rs.getString(4));
			lbl.setFont(new Font("ITF Devanagari Marathi", Font.PLAIN, 16));
			lbl.setBounds(185, 58, 225, 29);
			lbl.setForeground(new Color(124, 252, 0));
			frame.getContentPane().add(lbl);
		
			JButton btnViewTrips = new JButton("View User Trips");
			btnViewTrips.setBounds(326, 259, 167, 29);
			frame.getContentPane().add(btnViewTrips);
			btnViewTrips.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frame.dispose();
					new AllTrips(text, username, name, user, pname);
					
				}
			});
			
			
			JButton btnViewHisherBlogs = new JButton("View User Blogs");
			btnViewHisherBlogs.setBounds(114, 259, 160, 29);
			frame.getContentPane().add(btnViewHisherBlogs);
			btnViewHisherBlogs.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frame.dispose();
					new AllBlogs(username, name, user, pname, 10);
					
				}
			});

			
		
			frame.getContentPane().setBackground(new Color(25, 25, 112));
		
			JButton btnStopFollowing = new JButton("Stop Following");
			btnStopFollowing.setBounds(231, 167, 137, 29);
			frame.getContentPane().add(btnStopFollowing);
			btnStopFollowing.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					Statement statement = First.query();
					try
					{
						statement.execute("DELETE from favourites WHERE follower = '"+username+"' AND following = '"+user+"'");
						frame.dispose();
						new People(text,pname, user, name,username);
					}
					catch (SQLException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		
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
		
		frame.getContentPane().setBackground(new Color(25, 25, 112));
		frame.setSize(600,600);
		frame.setVisible(true);
	}

}
