import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Details extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int id = Integer.parseInt(args[0]);
					Details frame = new Details(args[1], args[2], id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Details(String username, String name, int id)
	{
		setBackground(new Color(25, 25, 112));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] Coloumns = {"Sl. No.", "Name", "Contact No."};
		Statement stmt = First.query();
		Statement stmt1 = First.query();
		
		try
		{
			ResultSet rs = stmt.executeQuery("SELECT username FROM futuretrip WHERE tripid = '"+id+"'");
			int length = 0;
			while(rs.next())
			{
				length++;
			}
			String[][] data = new String[length][3];
			int i = 0;
			rs = stmt.executeQuery("SELECT username FROM futuretrip WHERE tripid = '"+id+"'");
			while(rs.next())
			{
				String u = rs.getString(1);
				String n = "ABC", con = "95935";
				ResultSet rst = stmt1.executeQuery("Select firstname, lastname, contact FROM user WHERE username = '"+u+"'");
				if(rst.next())
				{
					u = rst.getString(1) + " " + rst.getString(2);
					con = rst.getString(3);
				}
				data[i][0] = Integer.toString(i + 1);
				data[i][1] = u;
				data[i][2] = con;
				i++;
			}
			
			JScrollPane scrollpane = new JScrollPane();
			scrollpane.setBounds(111,65,454,276);
			contentPane.add(scrollpane);
			
			
			JTable table = new JTable(data, Coloumns);
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			scrollpane.setViewportView(table);
			
			JButton btnHome = new JButton("Home");
			btnHome.setBounds(477, 6, 88, 29);
			contentPane.add(btnHome);
			btnHome.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					dispose();
					new Blogger(name, username, 20);
				}
			});
			
			JButton button = new JButton("");
			button.setIcon(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
			button.setBounds(6, 6, 30, 29);
			contentPane.add(button);
			button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					dispose();
					new ViewTrip(username,name, id, 20);
				}
			});
			
			
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		
		
		
	}

}
