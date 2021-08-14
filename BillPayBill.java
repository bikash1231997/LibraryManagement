import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class BillPayBill implements ActionListener
{

	JFrame frmPayBillsHere;
	private JTextField textField;
	JButton btnGetAmount;
	//JButton btnPayNow ;
	JLabel label_4 ;
	JLabel label_3;
	JLabel label_5 ;
	JLabel label_6; 
	
	JButton btnGo = new JButton("GO");
	JButton btnHome = new JButton("Go to Home");
	JButton btnPayNow = new JButton("Pay Now");
	
	
	public BillPayBill() 
	{
		
		frmPayBillsHere = new JFrame();
		frmPayBillsHere.setResizable(false);
		frmPayBillsHere.setIconImage(Toolkit.getDefaultToolkit().getImage(BillPayBill.class.getResource("power_icon.png")));
		frmPayBillsHere.getContentPane().setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		frmPayBillsHere.setTitle("Pay Bills here");
		frmPayBillsHere.setBounds(100, 100, 937, 671);
		frmPayBillsHere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPayBillsHere.getContentPane().setLayout(null);
		
		JLabel lblPayYourBills = new JLabel("Pay your bills here!");
		lblPayYourBills.setFont(new Font("Segoe UI Light", Font.PLAIN, 23));
		lblPayYourBills.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayYourBills.setBounds(335, 62, 246, 31);
		frmPayBillsHere.getContentPane().add(lblPayYourBills);
		
		JLabel lblFasterSecureAnd = new JLabel("Faster, Secure and Instant!");
		lblFasterSecureAnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblFasterSecureAnd.setBounds(354, 104, 182, 14);
		frmPayBillsHere.getContentPane().add(lblFasterSecureAnd);
		
		JLabel label = new JLabel("___________________________________________________");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(253, 129, 414, 14);
		frmPayBillsHere.getContentPane().add(label);
		
		JLabel lblCheckForBill = new JLabel("Check for Bill Status here");
		lblCheckForBill.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckForBill.setBounds(345, 480, 236, 14);
		frmPayBillsHere.getContentPane().add(lblCheckForBill);
		
		btnGo.setBounds(418, 505, 89, 23);
		frmPayBillsHere.getContentPane().add(btnGo);
		
		JLabel label_1 = new JLabel("__________________________________________");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(284, 455, 326, 14);
		frmPayBillsHere.getContentPane().add(label_1);
		
		btnHome.setBounds(345, 589, 236, 23);
		frmPayBillsHere.getContentPane().add(btnHome);
		
		JLabel lblOr = new JLabel("or");
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setBounds(439, 564, 46, 14);
		frmPayBillsHere.getContentPane().add(lblOr);
		
		JLabel label_2 = new JLabel("_____________");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(10, 539, 911, 14);
		frmPayBillsHere.getContentPane().add(label_2);
		
		JLabel lblEnterAccountNumber = new JLabel("Enter Account Number ");
		lblEnterAccountNumber.setFont(new Font("Segoe UI Light", Font.PLAIN, 19));
		lblEnterAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterAccountNumber.setBounds(284, 154, 326, 40);
		frmPayBillsHere.getContentPane().add(lblEnterAccountNumber);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(284, 205, 326, 20);
		frmPayBillsHere.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnPayNow.setVisible(true);
		btnPayNow.setBounds(315, 421, 266, 23);
		frmPayBillsHere.getContentPane().add(btnPayNow);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(213, 303, 96, 14);
		frmPayBillsHere.getContentPane().add(lblAmount);
		
		label_3 = new JLabel(".");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(587, 303, 80, 14);
		frmPayBillsHere.getContentPane().add(label_3);
		
		btnGetAmount = new JButton("Get Amount");
		btnGetAmount.setVisible(true);
		
		btnGetAmount.setBounds(373, 236, 163, 23);
		frmPayBillsHere.getContentPane().add(btnGetAmount);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(213, 269, 101, 23);
		frmPayBillsHere.getContentPane().add(lblName);
		
		label_4 = new JLabel(".");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(490, 270, 177, 20);
		frmPayBillsHere.getContentPane().add(label_4);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setBounds(213, 328, 146, 31);
		frmPayBillsHere.getContentPane().add(lblContactNumber);
		
		label_5 = new JLabel(".");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(512, 332, 155, 23);
		frmPayBillsHere.getContentPane().add(label_5);
		
		JLabel lblBillCycle = new JLabel("Bill Cycle");
		lblBillCycle.setBounds(213, 370, 119, 23);
		frmPayBillsHere.getContentPane().add(lblBillCycle);
		
		label_6 = new JLabel(".");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(529, 370, 138, 23);
		frmPayBillsHere.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(BillPayBill.class.getResource("back_8.png")));
		label_7.setBounds(-22, 0, 1006, 685);
		frmPayBillsHere.getContentPane().add(label_7);
		
		btnGetAmount.addActionListener(this);
		btnHome.addActionListener(this);
		btnGo.addActionListener(this);
		btnPayNow.addActionListener(this);
	
	}
	
	public void actionPerformed(ActionEvent e) 
	{
			if(e.getSource()==btnGetAmount)
			{
				String acno2=textField.getText().toString();
				if (acno2.equals("")) 
				{
					JOptionPane.showMessageDialog(frmPayBillsHere, "Please enter Account Number");
				}
				else if (acno2.contains(" ")) 
				{
					JOptionPane.showMessageDialog(frmPayBillsHere, "Account Number cannot have spaces.");
				}

				else
				{ 
					
					try
					{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					
					String s1="select * from customerdetails where accno=? and paid=? "; 
					PreparedStatement pst=con.prepareStatement(s1);  
					pst.setString(1,acno2);					
					pst.setString(2,"0");					
					ResultSet rs=pst.executeQuery();
					
					if (rs.next()) 
					{
						label_4.setText(rs.getString("custname"));
						label_3.setText(rs.getString("billAmt"));
						label_5.setText(rs.getString("custcontact"));
						label_6.setText(rs.getString("billDate"));
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(frmPayBillsHere, " No Unpaid Bills");
					
					}
					rs.close();			
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
			else if(e.getSource()==btnHome)
			{
				LandingPage landingPage = new LandingPage();
				landingPage.frameLandingPage.setVisible(true);
				frmPayBillsHere.dispose();
			}
			else if(e.getSource()==btnGo)
			{
				BillViewOldBillOptions billViewOldBillOptions = new BillViewOldBillOptions();
				billViewOldBillOptions.frmViewPreviousBills.setVisible(true);
				frmPayBillsHere.dispose();
			}
			else if(e.getSource()==btnPayNow)
			{
				String acno23=textField.getText().toString();	
				if (acno23.equals("")) 
				{
					JOptionPane.showMessageDialog(frmPayBillsHere, "Please enter Account Number");
				}

				else if (acno23.contains(" ")) 
				{
					JOptionPane.showMessageDialog(frmPayBillsHere, "Account Number cannot have spaces.");
				}

				else
				{
					
					try
					{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");

					String billdate=label_6.getText();		
					String billAmt3=label_3.getText();
					String qu3= "update customerdetails set paid='1' where acno='"+acno23+"'  && billDate='"+billdate+"' && billAmt='"+billAmt3+"'";
					Statement statement2= con.createStatement();
					int row2= statement2.executeUpdate(qu3);

				
					int response = JOptionPane.showConfirmDialog(null, " Bill Paid successfully!!! "+ "Do you want to continue?", "Bill Generated",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					    if (response == JOptionPane.NO_OPTION) 
						{
					     LandingPage page = new LandingPage();
					     page.frameLandingPage.setVisible(true);
					     frmPayBillsHere.dispose();
					    	
					    } 
						else if (response == JOptionPane.YES_OPTION) 
						{
					    	
					    	frmPayBillsHere.dispose();
					    	
					    	BillPayBill n= new BillPayBill();
					    	n.frmPayBillsHere.setVisible(true);
					     
					    } 
						else if (response == JOptionPane.CLOSED_OPTION) 
						{
					     
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
	}
	public static void main(String[] args) 
	{
		BillPayBill window = new BillPayBill();
		window.frmPayBillsHere.setVisible(true);
	}

	

}