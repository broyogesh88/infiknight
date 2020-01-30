import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.Box;




public class Trip extends JFrame implements ActionListener
{

	
	JFrame frame = new JFrame("Add Trips:");
	private JPanel contentPane;
	private SpringLayout springLayout;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private SpringLayout springLayout_1;
	JButton next, back;
	public class DateLabelFormatter extends AbstractFormatter
	{

	    private String datePattern = "dd-MM-yyyy";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	    @Override
	    public Object stringToValue(String text) throws ParseException{
	        return dateFormatter.parseObject(text);
	    }

	    @Override
	    public String valueToString(Object value){
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }

	        return "";
	    }

	}

	
	public Trip(String name, String username)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		frame.getContentPane().setBackground(new Color(25, 25, 112));
		frame.setSize(600, 600);
		frame.getContentPane().setLayout(null);
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(349, 307, 154, 26);
		frame.getContentPane().add(datePicker);
		
		JLabel lblSource = new JLabel("Source");
		lblSource.setForeground(new Color(255, 255, 255));
		lblSource.setBounds(153, 121, 61, 16);
		frame.getContentPane().add(lblSource);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setForeground(new Color(255, 255, 255));
		lblDestination.setBounds(153, 166, 103, 16);
		frame.getContentPane().add(lblDestination);
		
		JLabel lblNoOfDays = new JLabel("No. of Days:");
		lblNoOfDays.setForeground(new Color(255, 255, 255));
		lblNoOfDays.setBounds(153, 211, 130, 16);
		frame.getContentPane().add(lblNoOfDays);
		
		JLabel lblApproxBudget = new JLabel("Approx. Budget:");
		lblApproxBudget.setForeground(new Color(255, 255, 255));
		lblApproxBudget.setBounds(153, 256, 130, 16);
		frame.getContentPane().add(lblApproxBudget);
		
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setBounds(153, 307, 61, 16);
		frame.getContentPane().add(lblDate);
		
		textField = new JTextField();
		textField.setBounds(349, 116, 154, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(349, 161, 154, 26);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(349, 206, 154, 26);
		frame.getContentPane().add(textField_2);
		
		textField_1.addKeyListener(new KeyAdapter()
		{
	        public void keyPressed(KeyEvent e)
	        {

	            int key = e.getKeyCode();
	            if (key  < 100)
	            	textField_2.setText("");
	        }
	    });
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(349, 251, 154, 26);
		frame.getContentPane().add(textField_3);
		
		JLabel lblAbout = new JLabel("About: ");
		lblAbout.setForeground(new Color(255, 255, 255));
		lblAbout.setBounds(153, 380, 61, 16);
		frame.getContentPane().add(lblAbout);
		
		JLabel lblAddYourNext = new JLabel("Add Your next Trip...");
		lblAddYourNext.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblAddYourNext.setForeground(new Color(165, 42, 42));
		lblAddYourNext.setBounds(214, 23, 219, 30);
		frame.getContentPane().add(lblAddYourNext);
		
		
		ImageIcon icon1 = new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/icons8-arrow-left-64.png");
		back = new JButton(new ImageIcon("/Users/infiknightians/Downloads/Required Files for Project/back.png"));
		back.setBounds(6, 6, 30, 30);
		frame.getContentPane().add(back);
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new Blogger(name, username, 4);
			}
		});
		
		JButton btnAddTrip = new JButton("Add Trip");
		btnAddTrip.setBounds(245, 462, 117, 29);
		frame.getContentPane().add(btnAddTrip);
		
		JTextArea textField_4 = new JTextArea();
		textField_4.setBounds(349, 363, 154, 50);
		frame.getContentPane().add(textField_4);
		btnAddTrip.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String source = textField.getText();
				String destination = textField_1.getText();
				int no_of_days;
				float budget;
				String description =textField_4.getText();
				
				Date dat = (Date) datePicker.getModel().getValue();
				
				
				if(source.length() == 0 || destination.length() == 0 || description.length() == 0 || textField_2.getText().length() == 0  || textField_3.getText().length() == 0 || datePicker.getModel().getValue() == null )
				{
					JOptionPane.showMessageDialog
					(frame,"Empty Fields..","Error",JOptionPane.ERROR_MESSAGE) ;
				}
				else
				{
					
					java.sql.Date date = new java.sql.Date(dat.getTime());
					
					int check1 = 0;
					int check2 = 0;
					try
					{
						no_of_days = Integer.parseInt(textField_2.getText());
						
					}
					catch (NumberFormatException ex)
					{
						check1 = 1;
						JOptionPane.showMessageDialog
						(frame,"No. of Days can only be a Number..","Error",JOptionPane.ERROR_MESSAGE) ;
					}
					
					try
					{
						budget = Float.parseFloat(textField_3.getText());
					}
					catch (NumberFormatException ex)
					{
						check2 = 1;
						JOptionPane.showMessageDialog
						(frame,"Enter Budget in Number..","Error",JOptionPane.ERROR_MESSAGE) ;
					}
					
					
					Statement stmt = First.query();
					if(check1 != 1 && check2 != 1)
					{
						try
						{
							no_of_days = Integer.parseInt(textField_2.getText());
							budget = Float.parseFloat(textField_3.getText());
							stmt.execute("INSERT INTO trip (username, source, destination, totaldays, budget,startdate, description) VALUES ('"+username+"','"+source+"','"+destination+"','"+no_of_days+"','"+ budget+"','"+ date+"','"+ description+"')");
						}
						
						catch(Exception E)
						{
							System.out.println(E);
							
						}
						frame.dispose();
						new Blogger(name, username, 2 );
					}
				}
				
			}
		});
		frame.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
