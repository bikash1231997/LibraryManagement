import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class BillViewUnpaidBills implements ActionListener 
{

	JFrame frmViewUnpaidBills;
	private JTextField textField;
	String data_upb;
	JList list;
	JLabel lblName_1 ,lblAcNo,lblAddr,lblCno, lblCityyy ;
	
	JButton btnSubmit = new JButton("View Unpaid Bills");
	JButton btnPayBill = new JButton("Pay Bill");
	JButton btnGoBack = new JButton("Go Back");
	JButton btnGoHome = new JButton("Go Home");
	

	public BillViewUnpaidBills() 
	{
		frmViewUnpaidBills = new JFrame();
		frmViewUnpaidBills.setIconImage(Toolkit.getDefaultToolkit().getImage(BillViewUnpaidBills.class.getResource("power_icon.png")));
		frmViewUnpaidBills.setResizable(false);
		frmViewUnpaidBills.setTitle("View Unpaid Bills");
		frmViewUnpaidBills.setBounds(100, 100, 868, 649);
		frmViewUnpaidBills.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewUnpaidBills.getContentPane().setLayout(null);
		
		
		list = new JList();

		list.setBounds(67, 306, 684, 194);
		frmViewUnpaidBills.getContentPane().add(list);
		
		
		btnSubmit.setFont(new Font("Calibri", Font.BOLD, 17));
		btnSubmit.setBounds(214, 111, 404, 33);
		frmViewUnpaidBills.getContentPane().add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(214, 85, 404, 20);
		frmViewUnpaidBills.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterAccontNumber = new JLabel("Enter Account Number");
		lblEnterAccontNumber.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblEnterAccontNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterAccontNumber.setBounds(323, 28, 219, 33);
		frmViewUnpaidBills.getContentPane().add(lblEnterAccontNumber);
		
		btnGoBack.setBounds(191, 548, 141, 23);
		frmViewUnpaidBills.getContentPane().add(btnGoBack);
		
		btnGoHome.setBounds(488, 548, 141, 23);
		frmViewUnpaidBills.getContentPane().add(btnGoHome);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(67, 171, 200, 50);
		frmViewUnpaidBills.getContentPane().add(lblName);
		
		JLabel lblNewLabel = new JLabel("Address");
		lblNewLabel.setBounds(67, 207, 200, 33);
		frmViewUnpaidBills.getContentPane().add(lblNewLabel);
		
		JLabel lblContactDetails = new JLabel("Contact Details");
		lblContactDetails.setBounds(67, 232, 200, 33);
		frmViewUnpaidBills.getContentPane().add(lblContactDetails);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setBounds(67, 155, 200, 41);
		frmViewUnpaidBills.getContentPane().add(lblAccountNumber);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(67, 262, 200, 33);
		frmViewUnpaidBills.getContentPane().add(lblCity);
		
		lblName_1 = new JLabel(".");
		lblName_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName_1.setBounds(540, 171, 211, 50);
		frmViewUnpaidBills.getContentPane().add(lblName_1);
		
		lblAcNo = new JLabel(".");
		lblAcNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAcNo.setBounds(580, 150, 171, 50);
		frmViewUnpaidBills.getContentPane().add(lblAcNo);
		
		lblAddr = new JLabel(".");
		lblAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddr.setBounds(551, 207, 200, 32);
		frmViewUnpaidBills.getContentPane().add(lblAddr);
		
		lblCno = new JLabel(".");
		lblCno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCno.setBounds(619, 237, 132, 23);
		frmViewUnpaidBills.getContentPane().add(lblCno);
		
		lblCityyy = new JLabel(".");
		lblCityyy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCityyy.setBounds(551, 267, 200, 23);
		frmViewUnpaidBills.getContentPane().add(lblCityyy);
		
		btnPayBill.setBounds(299, 511, 200, 23);
		frmViewUnpaidBills.getContentPane().add(btnPayBill);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BillViewUnpaidBills.class.getResource("back_6.jpg")));
		label.setBounds(-15, 0, 902, 668);
		frmViewUnpaidBills.getContentPane().add(label);
		
		btnGoHome.addActionListener(this);
		btnGoBack.addActionListener(this);
		btnPayBill.addActionListener(this);
		btnSubmit.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
			if(e.getSource()==btnGoHome)
			{
				LandingPage page = new LandingPage();
				page.frameLandingPage.setVisible(true);
				frmViewUnpaidBills.dispose();
			}
			else if(e.getSource()==btnGoBack)
			{
				BillViewOldBillOptions viewOldBillOptions = new BillViewOldBillOptions();
				viewOldBillOptions.frmViewPreviousBills.setVisible(true);
				frmViewUnpaidBills.dispose();
			}
			else if(e.getSource()==btnPayBill)
			{
				BillPayBill payBill = new BillPayBill();
				payBill.frmPayBillsHere.setVisible(true);
				frmViewUnpaidBills.dispose();
			}
			else if(e.getSource()==btnSubmit)
			{
				//START
				String acno2=textField.getText().toString();

				if (acno2.equals("")) 
				{
					JOptionPane.showMessageDialog(frmViewUnpaidBills, "Please enter Account Number");
				}

				else if (acno2.contains(" ")) 
				{
					JOptionPane.showMessageDialog(frmViewUnpaidBills, "Account Number cannot have spaces.");
				}

				else
				{
					try
					{						
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");	
					String qu3= "select * from customerdetails where accno='"+acno2+"'  and paid='0'";
					Statement statement2= con.createStatement();
					ResultSet row2= statement2.executeQuery(qu3);
					

					if (row2.next()) 
					{
						lblAcNo.setText(row2.getString("accno"));
						lblName_1.setText(row2.getString("custname"));
						lblAddr.setText(row2.getString("custaddr"));
						lblCno.setText(row2.getString("custContact"));
						lblCityyy.setText(row2.getString("custcity"));
						
						
						
						DefaultListModel model = new DefaultListModel();
						
						 String firstEl=row2.getString("unitconsumed");
						 
						 String monthfr=row2.getString("billDate"); 
						 String billAmt2=row2.getString("billAmt"); 
						 String data2= "Consumed units: "+firstEl+" for Month: "+monthfr+" Amount: "+billAmt2;
					        model.addElement(data2); //add each item to the model

						 while (row2.next()) //go through each row that your query returns
						    {
						        String itemCode = row2.getString("unitconsumed"); //get the element in column "item_code"
						        String monthfr2=row2.getString("billDate"); 
						        String billAmt=row2.getString("billAmt"); 
								 String data22= "Consumed units: "+itemCode+" for Month: "+monthfr2+" Amount: "+billAmt;
							          
						        model.addElement(data22); //add each item to the model
						    }
						 
						 list.setModel(model);						
						JOptionPane.showMessageDialog(frmViewUnpaidBills, " User have Unpaid Bills");
						
					}
					else{
						JOptionPane.showMessageDialog(frmViewUnpaidBills, " No Unpaid Bills");
					
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
		BillViewUnpaidBills window = new BillViewUnpaidBills();
		window.frmViewUnpaidBills.setVisible(true);
	}
}
