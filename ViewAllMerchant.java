import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewAllMerchant  implements ActionListener 
{

	JFrame frm;

	JList list;
	private JButton btnGet = new JButton("Get");
	JButton btnGoBack = new JButton("Go Back");

	public ViewAllMerchant() 
	{
		frm = new JFrame();
		frm.setResizable(false);
		frm.setTitle("View All Merchants ");
		frm.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewAllCustomer.class.getResource("power_icon.png")));
		frm.setBounds(100, 100, 874, 560);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.getContentPane().setLayout(null);
		
		JLabel lblHereIsThe = new JLabel("Here is the list of All Merchants");
		lblHereIsThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblHereIsThe.setBounds(10, 11, 848, 45);
		frm.getContentPane().add(lblHereIsThe);
		
		btnGoBack.setBounds(10, 6, 200, 64);
		frm.getContentPane().add(btnGoBack);
		
		list = new JList();
		list.setBounds(10, 81, 848, 440);
		frm.getContentPane().add(list);
		
		btnGet.setBounds(334, 47, 200, 23);
		frm.getContentPane().add(btnGet);
		
		btnGoBack.addActionListener(this);
		btnGet.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
			if(e.getSource()==btnGoBack)
			{
				AdminLanding landingPage = new AdminLanding();
				landingPage.frmAdminLandingPage.setVisible(true);
				frm.dispose();			
			}
			else if(e.getSource()==btnGet)
			{
				try
				{
					
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");																
				
				String qu32= "select * from users";
				Statement statement22= con.createStatement();
				ResultSet row223= statement22.executeQuery(qu32);
				
				if (row223.next()) 
				{

					DefaultListModel model = new DefaultListModel();
					
					 String acno=row223.getString("USERNAME");
					 String namee=row223.getString("CONFIRM"); 
					 String cnoo=row223.getString("NAME"); 
					 String data2= "USERNAME: "+acno+"| NAME: "+namee+" |CONFIRM: "+cnoo;
				        model.addElement(data2);
						
					 while (row223.next()) 
					    {
					        String acno2 = row223.getString("USERNAME");
					        String cno2=row223.getString("CONFIRM"); 
					        String namee2=row223.getString("name"); 
					        String data22= "USERNAME: "+acno2+"| NAME: "+namee2+" |CONFIRM: "+cno2;
						          
					        model.addElement(data22); 
					    }
					 
					 list.setModel(model);					
				}
				} 
				catch (ClassNotFoundException e1) 
				{
					e1.printStackTrace();
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}  
			}
	}
	
	public static void main(String[] args) 
	{
		ViewAllMerchant window = new ViewAllMerchant();
		window.frm.setVisible(true);
	}
}
