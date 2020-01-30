import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class View extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		View frame;
		if(args[2].contentEquals("1"))
		{
				try
				{
					frame = new View(args);
					frame.setVisible(true);
					
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
		}
		else if(args[2].contentEquals("2"))
		{
			try
			{
				frame = new View(args, 1);
				frame.setVisible(true);
				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else if(args[2].contentEquals("3"))
		{
			try
			{
				frame = new View(args, 1, 2);
				frame.setVisible(true);
				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	
	/**
	 * @wbp.parser.constructor
	 */
	public View(String[] arr, int num1, int num2)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(25, 25, 112));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Statement stmt1 = First.query();
		Statement stmt2 = First.query();
		Statement stmt3 = First.query();
		try
		{
			int length = 0;
			ResultSet rs, rs1;
			
			rs = stmt1.executeQuery("SELECT * FROM blog");
			while(rs.next())
			{
					length++;
			}
			
			String[] Columns = {"Sl. No.","Blogger Name","Contact No.", "Title", "About","Blog Id", "Status"};
			
			String[][] data = new String[length][7];
			int i = 0;
			
			rs = stmt2.executeQuery("SELECT id, username, title, about, status FROM blog");
			while(rs.next())
			{
					int id = rs.getInt(1);
					String title = rs.getString(3);
					String about = rs.getString(4);
					String name = "default", contact = "default";
					rs1 = stmt3.executeQuery("SELECT firstname, lastname, contact from user WHERE username = '"+rs.getString(2)+"'");
					if(rs1.next())
					{
						name = rs1.getString(1) + " " + rs1.getString(2);
						contact = rs1.getString(3);
					}
					data[i][0] = Integer.toString(i + 1);
					data[i][1] = name;
					data[i][2] = contact;
					data[i][3] = title;
					data[i][4] = about;
					data[i][5] = Integer.toString(id);
					if(rs.getInt(5) == 1)
						data[i][6] = "Approved";
					else
						data[i][6] = "Verification Stage";
					i++;
				
			}
			contentPane.setLayout(null);
			
		    
			
			
			JScrollPane scrollpane = new JScrollPane();
			scrollpane.setBounds(77,71,454,278);
			contentPane.add(scrollpane);
			
			JTable table = new JTable(data, Columns);
			scrollpane.setViewportView(table);
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			
			JButton abtn = new JButton(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
			abtn.setBackground(Color.GRAY);
			abtn.setBounds(6, 6, 36, 32);
			contentPane.add(abtn);
			 abtn.addActionListener(new ActionListener()
			  {
					public void actionPerformed(ActionEvent e)
					{
						dispose();
						new Admin(arr[0], arr[1], 1);
						
					}
			  });
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		JLabel lblViews = new JLabel("Blogs:");
		lblViews.setForeground(new Color(165, 42, 42));
		lblViews.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblViews.setBounds(245, 6, 53, 22);
		contentPane.add(lblViews);
		
		JButton btnApproveUsers = new JButton("Approve Blog");
		btnApproveUsers.setBounds(68, 376, 125, 29);
		contentPane.add(btnApproveUsers);
		btnApproveUsers.addActionListener(new ActionListener()
		  {
				public void actionPerformed(ActionEvent e)
				{
					dispose();
					int var = 1;
					String ids = JOptionPane.showInputDialog("Enter the Blog Id of the Trip you want to Approve...");
					
					try
					{
						int id = Integer.parseInt(ids);
						stmt1.execute("UPDATE blog SET status = '"+var+"' WHERE id = '"+id+"'");
						View.main(arr);
					}
					catch(Exception e1)
					{
						System.out.println(e1);
						
					}
					
						      
					
				}
		  });
		
		JButton btnRemoveUser = new JButton("Remove Blog");
		btnRemoveUser.setBounds(409, 376, 122, 29);
		contentPane.add(btnRemoveUser);
		btnRemoveUser.addActionListener(new ActionListener()
		  {
				public void actionPerformed(ActionEvent e)
				{
					dispose();
					String ids = JOptionPane.showInputDialog("Enter the Blog Id you want to Remove...");
					
					try
					{
						int id = Integer.parseInt(ids);
						stmt1.execute("DELETE FROM blog WHERE id = '"+id+"'");
						View.main(arr);
					}
					catch(Exception e1)
					{
						System.out.println(e1);
					}	      
					
				}
		  });
		
		
		
		
	}
	
	
	public View(String[] arr, int num)
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(25, 25, 112));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Statement stmt = First.query();
		Statement stmt1 = First.query();
		Statement stmt2 = First.query();
		
		
		try
		{
			int length = 0;
			ResultSet rs, rs1;
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			rs = stmt.executeQuery("SELECT * FROM trip");
			while(rs.next())
			{
					length++;
			}
			
			String[] Columns = {"Sl. No.","Source", "Destination", "Start Date", "Host","Contact No.", "Status","Trip Id"};
			
			String[][] data = new String[length][8];
			int i = 0;
			
			rs = stmt1.executeQuery("SELECT id, source, destination, username, startdate, status FROM trip");
			while(rs.next())
			{
					int id = rs.getInt(1);
					String source = rs.getString(2);
					String destination = rs.getString(3);
					String name = "default", contact = "default";
					rs1 = stmt2.executeQuery("SELECT firstname, lastname, contact from user WHERE username = '"+rs.getString(4)+"'");
					if(rs1.next())
					{
						name = rs1.getString(1) + " " + rs1.getString(2);
						contact = rs1.getString(3);
					}
					data[i][0] = Integer.toString(i + 1);
					data[i][1] = source;
					data[i][2] = destination;
					data[i][3] = rs.getDate(5).toString();
					data[i][4] = name;
					data[i][5] = contact;
					if(rs.getInt(6) == 1)
						data[i][6] = "Approved";
					else
						data[i][6] = "Verification Stage";
					data[i][7] = Integer.toString(id);
					i++;
				
			}
			
		    
			
			
			JScrollPane scrollpane = new JScrollPane();
			scrollpane.setBounds(47,77,510,82);
			contentPane.add(scrollpane);
			
			JTable table = new JTable(data, Columns);
			scrollpane.setViewportView(table);
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			
			JButton abtn = new JButton(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
			abtn.setBackground(Color.GRAY);
			abtn.setBounds(6, 6, 28, 30);
			contentPane.add(abtn);
			 abtn.addActionListener(new ActionListener()
			  {
					public void actionPerformed(ActionEvent e)
					{
						dispose();
						new Admin(arr[0], arr[1], 1);
						
					}
			  });
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		JLabel lblViews = new JLabel("Users:");
		lblViews.setForeground(new Color(165, 42, 42));
		lblViews.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblViews.setBounds(250, 6, 95, 30);
		contentPane.add(lblViews);
		
		JButton btnApproveUsers = new JButton("Approve Trip");
		btnApproveUsers.setBounds(47, 199, 117, 29);
		contentPane.add(btnApproveUsers);
		btnApproveUsers.addActionListener(new ActionListener()
		  {
				public void actionPerformed(ActionEvent e)
				{
					dispose();
					int var = 1;
					String ids = JOptionPane.showInputDialog("Enter the Trip Id of the Trip you want to Approve...");
					
					try
					{
						int id = Integer.parseInt(ids);
						stmt.execute("UPDATE trip SET status = '"+var+"' WHERE id = '"+id+"'");
						View.main(arr);
					}
					catch(Exception e1)
					{
						System.out.println(e1);
						
					}
					
						      
					
				}
		  });
		
		JButton btnRemoveUser = new JButton("Remove Trip");
		btnRemoveUser.setBounds(440, 199, 117, 29);
		contentPane.add(btnRemoveUser);
		btnRemoveUser.addActionListener(new ActionListener()
		  {
				public void actionPerformed(ActionEvent e)
				{
					dispose();
					int var = 1;
					String ids = JOptionPane.showInputDialog("Enter the Trip Id you want to Remove...");
					
					try
					{
						int id = Integer.parseInt(ids);
						stmt.execute("DELETE FROM trip WHERE id = '"+id+"'");
						View.main(arr);
					}
					catch(Exception e1)
					{
						System.out.println(e1);
					}	      
					
				}
		  });
		
		
		
	}
	public View(String[] arr)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(25, 25, 112));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Statement stmt = First.query();
		try
		{
			int length = 0;
			ResultSet rs;
			rs = stmt.executeQuery("SELECT firstname, lastname, email, tempaddress, contact FROM user");
			while(rs.next())
			{
				length++;
			}
			
			String[] Columns = {"Sl. No.","Name", "Email", "Address", "Contact No.","Account"};
			
			String[][] data = new String[length][6];
			int i = 0;
			
			rs = stmt.executeQuery("SELECT firstname, lastname, email, tempaddress, contact, account FROM user WHERE username <> 'broyogesh88'");
			while(rs.next())
			{
				String name1 = rs.getString(1) + " " + rs.getString(2);
				String email = rs.getString(3);
				String add = rs.getString(4);
				String contact = rs.getString(5);
				data[i][0] = Integer.toString(i + 1);
				data[i][1] = name1;
				data[i][2] = email;
				data[i][3] = add;
				data[i][4] = contact;
				if(rs.getInt(6) == 1)
					data[i][5] = "Approved";
				else
					data[i][5] = "Verification Stage";
				i++;
			}
			
		    
			
			
			JScrollPane scrollpane = new JScrollPane();
			scrollpane.setBounds(47,77,510,82);
			contentPane.add(scrollpane);
			
			JTable table = new JTable(data, Columns);
			scrollpane.setViewportView(table);
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			
			JButton abtn = new JButton(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
			abtn.setBackground(Color.GRAY);
			abtn.setBounds(6, 6, 28, 30);
			contentPane.add(abtn);
			 abtn.addActionListener(new ActionListener()
			  {
					public void actionPerformed(ActionEvent e)
					{
						dispose();
						new Admin(arr[0], arr[1], 1);
						
					}
			  });
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		JLabel lblViews = new JLabel("Users:");
		lblViews.setForeground(new Color(165, 42, 42));
		lblViews.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblViews.setBounds(250, 6, 95, 30);
		contentPane.add(lblViews);
		
		JButton btnApproveUsers = new JButton("Approve User");
		btnApproveUsers.setBounds(47, 199, 117, 29);
		contentPane.add(btnApproveUsers);
		btnApproveUsers.addActionListener(new ActionListener()
		  {
				public void actionPerformed(ActionEvent e)
				{
					dispose();
					int var = 1;
					String mail = JOptionPane.showInputDialog("Enter the Email address of the user you want to Approve...");
					ResultSet rs;
					System.out.println(mail);
					try
					{
						stmt.execute("UPDATE user SET account = '"+var+"' WHERE email = '"+mail+"'");
						View.main(arr);
					}
					catch(Exception e1)
					{
						System.out.println(e1);
					}
					
						      
					
				}
		  });
		
		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.setBounds(440, 199, 117, 29);
		contentPane.add(btnRemoveUser);
		btnRemoveUser.addActionListener(new ActionListener()
		  {
				public void actionPerformed(ActionEvent e)
				{
					dispose();
					int var = 1;
					String mail = JOptionPane.showInputDialog("Enter the Email address of the user you want to Approve...");
					ResultSet rs;
					System.out.println(mail);
					try
					{
						stmt.execute("DELETE FROM user WHERE email = '"+mail+"'");
						View.main(arr);
					}
					catch(Exception e1)
					{
						System.out.println(e1);
					}
					
						      
					
				}
		  });
		
		
	}

}
