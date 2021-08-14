import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewAllCustomer  implements ActionListener
{

	JFrame frmViewAllCustomers;
	JList list;
	JButton btnGet = new JButton("Get");
	JButton btnGoBack = new JButton("Go Back");

	public ViewAllCustomer() 
	{
		frmViewAllCustomers = new JFrame();
		frmViewAllCustomers.setResizable(false);
		frmViewAllCustomers.setTitle("View All Customers");
		frmViewAllCustomers.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewAllCustomer.class.getResource("power_icon.png")));
		frmViewAllCustomers.setBounds(100, 100, 874, 560);
		frmViewAllCustomers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewAllCustomers.getContentPane().setLayout(null);
		
		JLabel lblHereIsThe = new JLabel("Here is the list of All Customers");
		lblHereIsThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblHereIsThe.setBounds(10, 11, 848, 45);
		frmViewAllCustomers.getContentPane().add(lblHereIsThe);
		
		btnGoBack.setBounds(10, 6, 200, 64);
		frmViewAllCustomers.getContentPane().add(btnGoBack);
		
		list = new JList();
		list.setBounds(10, 81, 848, 440);
		frmViewAllCustomers.getContentPane().add(list);
		
		btnGet.setBounds(334, 47, 200, 23);
		frmViewAllCustomers.getContentPane().add(btnGet);
		
		btnGoBack.addActionListener(this);
		btnGet.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent e) 
	{
			if(e.getSource()==btnGoBack)
			{
				LandingPage landingPage = new LandingPage();
				landingPage.frameLandingPage.setVisible(true);
				frmViewAllCustomers.dispose();
			}
			else if(e.getSource()==btnGet)
			{
				
				
				try{
					
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");																
				
				String qu32= "select * from customerdetails";
				Statement statement22= con.createStatement();
				ResultSet row223= statement22.executeQuery(qu32);
				

				if (row223.next()) 
				{
					DefaultListModel model = new DefaultListModel();
					
					 String acno=row223.getString("accno");
					 String namee=row223.getString("custname"); 
					 String cnoo=row223.getString("custContact"); 
					 String data2= "A/c No: "+acno+"| Name: "+namee+" |Contact Number: "+cnoo;
				     model.addElement(data2); 

					 while (row223.next())
					    {
					        String acno2 = row223.getString("accno"); 
					        String cno2=row223.getString("custContact"); 
					        String namee2=row223.getString("custname"); 
					        String data22= "A/c No: "+acno2+"| Name: "+namee2+" |Contact Number: "+cno2;
						          
					        model.addElement(data22); 
					    }
					 
					 list.setModel(model);

			}
				} 
				catch (ClassNotFoundException e1) 
				{
					e1.printStackTrace();
				} 
				catch (SQLException e2) 
				{
					
					e2.printStackTrace();
				}  
					
				
			}
	}
	public static void main(String[] args) 
	{
		ViewAllCustomer window = new ViewAllCustomer();
		window.frmViewAllCustomers.setVisible(true);
	}
}
