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
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;


public class AllBlogs extends JFrame
{

	private JPanel contentPane;
	JLabel l1;
	
	JFrame frame = new JFrame("View Blog:");
	 
	public AllBlogs(String username, String name, String uname, String pname, int page)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l1 = new JLabel("All Blogs: ");
		l1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		l1.setForeground(new Color(165, 42, 42));
		l1.setBounds(231, 22, 166, 30);
		frame.getContentPane().add(l1);
		Statement stmt = First.query();
		try
		{
			ResultSet rs = stmt.executeQuery("SELECT id, title, experiences, about, status FROM blog WHERE username = '"+uname+"'");
			int x2 = 84;
			int checkblog = 0;
			while(rs.next())
			{
				if(rs.getInt(5) != 0)
				{
					checkblog = 1;
					int id = rs.getInt(1);
					String title = rs.getString(2);
					String experience = rs.getString(2);
					String about = rs.getString(4);
					
					JPanel panel = new JPanel();
					panel.setBorder(new CompoundBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "People", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
					panel.setBounds(92, x2, 322, 146);
					frame.getContentPane().add(panel);
					panel.setLayout(null);
					
					JLabel lblName = new JLabel("Title:");
					lblName.setBounds(17, 30, 55, 16);
					panel.add(lblName);
					
					JLabel lblAbout = new JLabel("About:");
					lblAbout.setBounds(17, 62, 61, 16);
					panel.add(lblAbout);
					
					JLabel lblNewLabel = new JLabel(title);
					lblNewLabel.setBounds(126, 30, 141, 16);
					panel.add(lblNewLabel);
				
					JLabel lblNewLabel_1 = new JLabel(about);
					lblNewLabel_1.setBounds(126, 62, 190, 16);
					panel.add(lblNewLabel_1);
					
					JButton btnViewBlog = new JButton("View Blog");
					btnViewBlog.setBounds(100, 111, 117, 29);
					panel.add(btnViewBlog);
					btnViewBlog.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							frame.dispose();
							new ViewBlog(username, name, uname, pname, id, 7);
						}
					});
					x2 = x2 + 165;
				}
				
			}
			if(checkblog == 0)
			{
				
				JLabel lblThisPersonHas = new JLabel("No Blogs has been Uploaded Yet..");
				lblThisPersonHas.setForeground(new Color(178, 34, 34));
				lblThisPersonHas.setFont(new Font("Hoefler Text", Font.PLAIN, 18));
				lblThisPersonHas.setBounds(137, 136, 397, 67);
				frame.getContentPane().add(lblThisPersonHas);
				
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		frame.getContentPane().setBackground(new Color(25, 25, 112));
		
		
		
		frame.setSize(600, 600);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
		btnNewButton.setBounds(23, 8, 30, 28);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new Blogger(name, username, 6);
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
		
		frame.setVisible(true);
	}

}
