import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BillViewPaidBills implements ActionListener 
{

	JFrame frmViewPaidBils;
	private JTextField textField;

	JList list ;
	JLabel lblName_12 ,lblAcNo2,lblAddr2,lblCno2, lblCityyy2 ;
	
	JButton btnSubmit = new JButton("View Paid Bills");
	JButton btnGoBack = new JButton("Go Back");
	JButton btnGoHome = new JButton("Go Home");

	public BillViewPaidBills() 
	{
		frmViewPaidBils = new JFrame();
		frmViewPaidBils.setResizable(false);
		frmViewPaidBils.setIconImage(Toolkit.getDefaultToolkit().getImage(BillViewPaidBills.class.getResource("power_icon.png")));
		frmViewPaidBils.setTitle("View Paid Bills");
		frmViewPaidBils.setBounds(100, 100, 885, 664);
		frmViewPaidBils.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewPaidBils.getContentPane().setLayout(null);
		
		JLabel lblEnterAccountNumber = new JLabel("Enter Account Number");
		lblEnterAccountNumber.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblEnterAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterAccountNumber.setBounds(317, 31, 233, 41);
		frmViewPaidBils.getContentPane().add(lblEnterAccountNumber);
		
		textField = new JTextField();
		textField.setBounds(163, 83, 489, 33);
		frmViewPaidBils.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		list = new JList();
		list.setToolTipText("\r\n");
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(69, 358, 722, 167);
		frmViewPaidBils.getContentPane().add(list);
	
		btnSubmit.setBounds(163, 127, 489, 41);
		frmViewPaidBils.getContentPane().add(btnSubmit);
		
		
		
		btnGoBack.setBounds(226, 536, 147, 23);
		frmViewPaidBils.getContentPane().add(btnGoBack);
		
		btnGoHome.setBounds(482, 536, 147, 23);
		frmViewPaidBils.getContentPane().add(btnGoHome);
		
		
		//START

		JLabel lblName2 = new JLabel("Name");
		lblName2.setBounds(104, 206, 200, 50);
		frmViewPaidBils.getContentPane().add(lblName2);
		
		JLabel lblNewLabel = new JLabel("Address");
		lblNewLabel.setBounds(104, 248, 200, 33);
		frmViewPaidBils.getContentPane().add(lblNewLabel);
		
		JLabel lblContactDetails = new JLabel("Contact Details");
		lblContactDetails.setBounds(104, 282, 200, 33);
		frmViewPaidBils.getContentPane().add(lblContactDetails);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setBounds(104, 179, 200, 41);
		frmViewPaidBils.getContentPane().add(lblAccountNumber);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(104, 314, 200, 33);
		frmViewPaidBils.getContentPane().add(lblCity);
		
		lblName_12 = new JLabel(".");
		lblName_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName_12.setBounds(467, 206, 211, 50);
		frmViewPaidBils.getContentPane().add(lblName_12);
		
		lblAcNo2 = new JLabel(".");
		lblAcNo2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAcNo2.setBounds(507, 174, 171, 50);
		frmViewPaidBils.getContentPane().add(lblAcNo2);
		
		lblAddr2 = new JLabel(".");
		lblAddr2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddr2.setBounds(477, 248, 200, 32);
		frmViewPaidBils.getContentPane().add(lblAddr2);
		
		lblCno2 = new JLabel(".");
		lblCno2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCno2.setBounds(548, 287, 132, 23);
		frmViewPaidBils.getContentPane().add(lblCno2);
		
		lblCityyy2 = new JLabel(".");
		lblCityyy2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCityyy2.setBounds(480, 319, 200, 23);
		frmViewPaidBils.getContentPane().add(lblCityyy2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BillViewPaidBills.class.getResource("back_6.jpg")));
		label.setBounds(-15, 0, 934, 705);
		frmViewPaidBils.getContentPane().add(label);
		
		btnGoHome.addActionListener(this);
		btnGoBack.addActionListener(this);
		btnSubmit.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
			if(e.getSource()==btnGoHome)
			{
				LandingPage page = new LandingPage();
				page.frameLandingPage.setVisible(true);
				frmViewPaidBils.dispose();
			}
			else if(e.getSource()==btnGoBack)
			{
				BillViewOldBillOptions viewOldBillOptions = new BillViewOldBillOptions();
				viewOldBillOptions.frmViewPreviousBills.setVisible(true);
				frmViewPaidBils.dispose();
			}
			else if(e.getSource()==btnSubmit)
			{
				String acno2=textField.getText().toString();

				if (acno2.equals("")) 
				{
					JOptionPane.showMessageDialog(frmViewPaidBils, "Please enter Account Number");
				}

				else if (acno2.contains(" ")) 
				{
					JOptionPane.showMessageDialog(frmViewPaidBils, "Account Number cannot have spaces.");
				}

				else
				{
					
				
					try
					{
						
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					
					String qu39= "select * from customerdetails where accno='"+acno2+"'  and paid='1'";
					Statement statement29= con.createStatement();
					ResultSet row22= statement29.executeQuery(qu39);
					

					if (row22.next()) 
					{
						
						String data=row22.getString("accno");
						JOptionPane.showMessageDialog(frmViewPaidBils, " User have Paid Bill Entries");
						
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
						
						String qu32= "select * from customerdetails where accno='"+acno2+"'  and paid='1'";
						Statement statement22= con2.createStatement();
						ResultSet row223= statement22.executeQuery(qu32);
						

						if (row223.next()) 
						{
							lblAcNo2.setText(row223.getString("ACCNO"));
							lblName_12.setText(row223.getString("CUSTNAME"));
							lblAddr2.setText(row223.getString("CUSTADDR"));
							lblCityyy2.setText(row223.getString("CUSTCITY"));
							lblCno2.setText(row223.getString("CUSTCONTACT"));
							
						
							DefaultListModel model = new DefaultListModel();
							
							 String firstEl=row22.getString("UNITCONSUMED");
							 
							 String monthfr=row22.getString("BILLDATE"); 
							 String billAmt2=row22.getString("BILLAMT"); 
							 String data2= "Consumed units: "+firstEl+" for Month: "+monthfr+" Amount: "+billAmt2;
						        model.addElement(data2); 

							 while (row22.next()) 
							    {
							        String itemCode = row22.getString("unitconsumed"); 
							        String monthfr2=row22.getString("billDate"); 
							        String billAmt=row22.getString("billAmt"); 
									 String data22= "Consumed units: "+itemCode+" for Month: "+monthfr2+" Amount: "+billAmt;
								          
							        model.addElement(data22); 
							    }
							 list.setModel(model);	
					}
					}
					else
					{
						JOptionPane.showMessageDialog(frmViewPaidBils, " User have Unpaid Bills");
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
		BillViewPaidBills window = new BillViewPaidBills();
		window.frmViewPaidBils.setVisible(true);
	}

}
