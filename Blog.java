import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Blog extends JFrame {

	JFrame frame = new JFrame("Add Blogs:");
	private JPanel contentPane;
	private JTextField textField;
	private JTextPane textField_1;
	private JTextPane textField_2;
	JFileChooser file ;
    JButton Browse , Ok ;
    JTextField a;
    private JButton btnCreateBlog;
    String ImageName;
    private JLabel lblAddAnImage;
    private JButton btnUpload, abtn;
 
    
    Statement stmt = First.query();
    FileInputStream inputStream = null;
    File f;
    private JLabel lblWriteABlog;
	public Blog(String name, String username, int page, int edit, int id)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		frame.getContentPane().setBackground(new Color(25, 25, 112));
		frame.setSize(600, 600);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		abtn = new JButton(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
		abtn.setBackground(Color.GRAY);
		abtn.setBounds(6, 6, 28, 30);
		frame.getContentPane().add(abtn);
		abtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				if(page == 2)
					new Blogger(name, username, 1);
				else if(page == 7)
					new ViewBlog(username, name,username, name, id ,1);
				
			}
		});
		
		if(edit == 0)
		{
			JLabel lblSource = new JLabel("Title:");
			lblSource.setForeground(new Color(255, 255, 255));
			lblSource.setBounds(153, 108, 61, 16);
			frame.getContentPane().add(lblSource);
			
			textField = new JTextField();
			textField.setBounds(275, 103, 176, 26);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			
			JLabel lblExperiences = new JLabel("Experiences:");
			lblExperiences.setForeground(new Color(255, 255, 255));
			lblExperiences.setBounds(153, 163, 91, 16);
			frame.getContentPane().add(lblExperiences);
			
			JLabel lblAbout = new JLabel("About:");
			lblAbout.setForeground(new Color(255, 255, 255));
			lblAbout.setBounds(153, 232, 61, 16);
			frame.getContentPane().add(lblAbout);
			
			textField_1 = new JTextPane();
			textField_1.setBounds(275, 148, 187, 46);
			frame.getContentPane().add(textField_1);
			
			textField_2 = new JTextPane();
			textField_2.setBounds(275, 227, 200, 95);
			frame.getContentPane().add(textField_2);
			
	   
	        Browse = new JButton("Browse");
	        a = new JTextField(20);
	        Browse.setBounds(417, 362, 130, 26);
	        
	    	Browse.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					file = new JFileChooser() ;
		            file.showOpenDialog(frame) ;
		             
		            String s = file.getSelectedFile().getAbsolutePath() ;
		            f = file.getSelectedFile();
		            a.setText(s) ;
		        }
			});
	        
	        a.setBounds(275, 359, 130, 31);
	        frame.getContentPane().add(a);
	        frame.getContentPane().add(Browse);
	     
			lblAddAnImage = new JLabel("Add an Image:");
			lblAddAnImage.setForeground(new Color(255, 255, 255));
			lblAddAnImage.setBounds(153, 366, 109, 16);
			frame.getContentPane().add(lblAddAnImage);
			
			btnUpload = new JButton("Add Blog");
			btnUpload.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					String title = textField.getText();
					String experience = textField_1.getText();
					String about = textField_2.getText();
					String imagetitle = a.getText();
					if(title.length() == 0 || experience.length() == 0 || about.length() == 0 || imagetitle.length() == 0 )
					{
						JOptionPane.showMessageDialog
						(frame,"Empty Fields..","Error",JOptionPane.ERROR_MESSAGE) ;
					}
					else
					{
						Connection connection = null;
				        PreparedStatement statement = null;
				        FileInputStream inputStream = null;
				        try {
				        	connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Travel", "root", "8101996@Yogesh");
							
						}
				        catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try
						{
							inputStream = new FileInputStream(f);
							
							statement = (PreparedStatement) connection.prepareStatement("INSERT INTO blog (username, title, experiences, about, imagetitle, imagedata) VALUES('"+username+"','"+title+"','"+experience+"','"+about+"','"+imagetitle+"',?)");
				       
				            statement.setBinaryStream(1, (InputStream) inputStream, (int)(f.length()));
				 
				            statement.executeUpdate();
				 
							
						}
						catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						frame.dispose();
						new Blogger(name, username,1);
					}
					 
				}
			});
			
			btnUpload.setBounds(272, 469, 117, 29);
			frame.getContentPane().add(btnUpload);
			
			lblWriteABlog = new JLabel("Write a blog....");
			lblWriteABlog.setFont(new Font("Luminari", Font.PLAIN, 20));
			lblWriteABlog.setForeground(new Color(165, 42, 42));
			lblWriteABlog.setBounds(244, 25, 161, 30);
			frame.getContentPane().add(lblWriteABlog);
			
			btnCreateBlog = new JButton("Create Blog");
			btnCreateBlog.setBounds(236, 478, 117, 29);
			
			btnCreateBlog.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frame.dispose();
					new AllBlogs(username, name, username, name, 4);
				}
			});
			
	}
		else
		{
				Statement stmt = First.query();
				try
				{
					String title = "default";
					String experience = "default";
					String about = "default";
					String imagetitle = "default";
					
					ResultSet rs = stmt.executeQuery("SELECT title, experiences, about, imagetitle FROM blog WHERE id = '"+id+"'");
					while(rs.next())
					{
						title = rs.getString(1);
						experience = rs.getString(2);
						about = rs.getString(3);
						imagetitle = rs.getString(4);
					}
					JLabel lblSource = new JLabel("Title:");
					lblSource.setForeground(new Color(255, 255, 255));
					lblSource.setBounds(153, 108, 61, 16);
					frame.getContentPane().add(lblSource);
					
					textField = new JTextField(title);
					textField.setBounds(275, 103, 176, 26);
					frame.getContentPane().add(textField);
					textField.setColumns(10);
					
					JLabel lblExperiences = new JLabel("Experiences:");
					lblExperiences.setForeground(new Color(255, 255, 255));
					lblExperiences.setBounds(153, 163, 91, 16);
					frame.getContentPane().add(lblExperiences);
					
					JLabel lblAbout = new JLabel("About:");
					lblAbout.setForeground(new Color(255, 255, 255));
					lblAbout.setBounds(153, 232, 61, 16);
					frame.getContentPane().add(lblAbout);
					
					textField_1 = new JTextPane();
					textField_1.setBounds(275, 148, 187, 46);
					frame.getContentPane().add(textField_1);
					textField_1.setText(about);
					
					textField_2 = new JTextPane();
					textField_2.setBounds(275, 227, 200, 95);
					frame.getContentPane().add(textField_2);
					textField_2.setText(experience);
					
					Browse = new JButton("Browse");
			        a = new JTextField(20);
			        Browse.setBounds(417, 362, 130, 26);
			        a.setText(imagetitle);
			        
			    	Browse.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							file = new JFileChooser() ;
				            file.showOpenDialog(frame) ;
				             
				            String s = file.getSelectedFile().getAbsolutePath() ;
				            f = file.getSelectedFile();
				            a.setText(s) ;
				        }
					});
			      
			        a.setBounds(275, 359, 130, 31);
			        frame.getContentPane().add(a);
			        frame.getContentPane().add(Browse);
			     
					lblAddAnImage = new JLabel("Add an Image:");
					lblAddAnImage.setForeground(new Color(255, 255, 255));
					lblAddAnImage.setBounds(153, 366, 109, 16);
					frame.getContentPane().add(lblAddAnImage);
					
					
					
					btnUpload = new JButton("Update Blog");
					btnUpload.setBounds(272, 469, 117, 29);
					frame.getContentPane().add(btnUpload);
					btnUpload.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							String title = textField.getText();
							String experience = textField_1.getText();
							String about = textField_2.getText();
							String imagetitle = a.getText();
							if(title.length() == 0 || experience.length() == 0 || about.length() == 0 || imagetitle.length() == 0 )
							{
								JOptionPane.showMessageDialog
								(frame,"Empty Fields..","Error",JOptionPane.ERROR_MESSAGE) ;
							}
							else
							{
								Statement stmt = First.query();
								try
								{
									stmt.execute("UPDATE blog SET title = '"+title+"', experiences = '"+experience+"', about = '"+about+"', imagetitle = '"+imagetitle+"' WHERE id = '"+id+"'");
								}
								catch (SQLException e1)
								{
									e1.printStackTrace();
								}
								frame.dispose();
								new Blogger(name, username,1);
							}
							 
						}
					});
					
					
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				
			
		}	
			
		
		
	}
}
