import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.Color;
public class AddProfilePic extends JFrame {

	private JPanel contentPane;
	JFrame frame = new JFrame();
	JButton Browse;
	JTextField a;
	JFileChooser file ;
	File f;
	String ImageName;
	private JLabel lblAddAProfile;
	private JButton btnUpload;
	private JButton button;
	
	public AddProfilePic(String name, String username)
	{
		frame.getContentPane().setBackground(new Color(25, 25, 112));
		frame.setSize(600, 600);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		
		 	Browse = new JButton("Browse");
	        a = new JTextField(20);
	        Browse.setBounds(387, 125, 130, 26);
	        
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
	        a.setBounds(211, 122, 130, 31);
	        frame.getContentPane().add(a);
	        frame.getContentPane().add(Browse);
	        
	        lblAddAProfile = new JLabel("Add a Profile Picture:");
	        lblAddAProfile.setFont(new Font("American Typewriter", Font.PLAIN, 18));
	        lblAddAProfile.setForeground(new Color(165, 42, 42));
	        lblAddAProfile.setBounds(207, 33, 223, 31);
	        frame.getContentPane().add(lblAddAProfile);
	        
	        btnUpload = new JButton("Upload");
	        btnUpload.setBounds(308, 178, 117, 29);
	        frame.getContentPane().add(btnUpload);
	        
	        button = new JButton("");
	        button.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
	        button.setBounds(6, 6, 28, 29);
	        frame.getContentPane().add(button);
	        button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frame.dispose();
					new Blogger(name, username,13);
				}
			});
	        
	        
	        
	        btnUpload.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					Statement stmt = First.query();
			        try
					{
			        	int var = 1;
						stmt.execute("UPDATE user SET profilepic = '"+a.getText()+"', picupload = '"+var+"' WHERE username = '"+username+"'");
						new Blogger(name, username, 15); 
						
					}
					catch(Exception E)
					{
						System.out.println(E);
					}
				}
			});
	}

}
