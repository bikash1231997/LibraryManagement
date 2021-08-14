import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewFeedbacks  implements ActionListener 
{

	JFrame frmViewFeedbackss;

	JList list;
	
	JButton btnGoBack = new JButton("Go Back");
	JButton btnGet = new JButton("Get");


	public ViewFeedbacks() 
	{
		frmViewFeedbackss = new JFrame();
		frmViewFeedbackss.setResizable(false);
		frmViewFeedbackss.setTitle("View All Customers");
		frmViewFeedbackss.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewFeedbacks.class.getResource("power_icon.png")));
		frmViewFeedbackss.setBounds(100, 100, 874, 560);
		frmViewFeedbackss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewFeedbackss.getContentPane().setLayout(null);
		
		JLabel lblHereIsThe = new JLabel("Here are the feedbacks from merchants");
		lblHereIsThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblHereIsThe.setBounds(10, 11, 848, 45);
		frmViewFeedbackss.getContentPane().add(lblHereIsThe);
		
		btnGoBack.setBounds(10, 6, 200, 64);
		frmViewFeedbackss.getContentPane().add(btnGoBack);
		
		list = new JList();
		list.setBounds(10, 81, 848, 440);
		frmViewFeedbackss.getContentPane().add(list);
		
		btnGet.setBounds(334, 47, 200, 23);
		frmViewFeedbackss.getContentPane().add(btnGet);
		
		btnGoBack.addActionListener(this);
		btnGet.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
			if(e.getSource()==btnGoBack)
			{
				AdminLanding landingPage = new AdminLanding();
				landingPage.frmAdminLandingPage.setVisible(true);
				frmViewFeedbackss.dispose();			
			}
			else if(e.getSource()==btnGet)
			{
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");																

				String qu32= "select * from merchantfeedback";
				Statement statement22= con.createStatement();
				ResultSet row223= statement22.executeQuery(qu32);
				

				if (row223.next()) {


					DefaultListModel model = new DefaultListModel();
					
					 String unamee=row223.getString("uname");
					 String emaill=row223.getString("email"); 
					 String msgg=row223.getString("msg"); 
					 String data2= "Username: "+unamee+" | Email: "+emaill+" | Message: "+msgg;
				        model.addElement(data2);

					 while (row223.next())
					    {
					    
						 String unamee2=row223.getString("uname");
						 
						 String emaill2=row223.getString("email"); 
						 String msgg2=row223.getString("msg"); 
							 String data22= "Username: "+unamee2+" | Email: "+emaill2+" | Message: "+msgg2;
						          
					        model.addElement(data22);
					    }
					 
					 list.setModel(model);
					
					
			}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}  
					
			}
	}
	public static void main(String[] args) 
	{
		ViewFeedbacks window = new ViewFeedbacks();
		window.frmViewFeedbackss.setVisible(true);
	}
}
