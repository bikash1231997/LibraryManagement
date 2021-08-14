import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class BillGenerateNewBill implements ActionListener 
{

	String addr;
	JFrame frameNewBill;
	JLabel lblConsumerName;
	JLabel label_cno;
	JLabel lblCityName;
	JSpinner sp_unit_price;
	JSpinner sp_unit_consumed;
	JTextArea textArea;
	
	static String unitConsumed;
	static String unitPrice;
	static String billAmount;
	
	JSpinner spinner, spinner_1;
	private JTextField accontNumber;

	String dateB;
	String mo = new String();
	String yr = new String();
	
	JButton btnPayNow = new JButton("Pay Now");
	JButton btnGoBack = new JButton("Go Back");
	JButton btnGetDetails = new JButton("Get Details");
	JButton btnSubmit= new JButton(" Submit");
	JLabel lblAddress = new JLabel("Address");

	public BillGenerateNewBill() 
	{
		
		frameNewBill = new JFrame();
		frameNewBill.setIconImage(Toolkit.getDefaultToolkit().getImage(BillGenerateNewBill.class.getResource("power_icon.png")));
		frameNewBill.setResizable(false);
		frameNewBill.setTitle("Generate New Bill");
		frameNewBill.setBounds(100, 100, 966, 706);
		frameNewBill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameNewBill.getContentPane().setLayout(null);
		
		JLabel lblEnterDetailsFor = new JLabel("Enter details for bill");
		lblEnterDetailsFor.setBounds(10, 35, 940, 23);
		lblEnterDetailsFor.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblEnterDetailsFor.setHorizontalAlignment(SwingConstants.CENTER);
		frameNewBill.getContentPane().add(lblEnterDetailsFor);
		
		JLabel label = new JLabel("_____________________________________________");
		label.setBounds(10, 57, 940, 14);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frameNewBill.getContentPane().add(label);
		
		JLabel lblEnterAccountNumber = new JLabel("Enter Account Number");
		lblEnterAccountNumber.setBounds(10, 82, 940, 14);
		lblEnterAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
		frameNewBill.getContentPane().add(lblEnterAccountNumber);
		
		accontNumber = new JTextField();
		accontNumber.setBounds(340, 107, 280, 20);
		accontNumber.setHorizontalAlignment(SwingConstants.CENTER);
		frameNewBill.getContentPane().add(accontNumber);
		accontNumber.setColumns(10);
		
		JLabel lblK = new JLabel("Login Name");
		lblK.setBounds(718, 644, 232, 23);
		lblK.setHorizontalAlignment(SwingConstants.RIGHT);
		lblK.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		frameNewBill.getContentPane().add(lblK);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(10, 196, 160, 14);
		lblCustomerName.setHorizontalAlignment(SwingConstants.RIGHT);
		frameNewBill.getContentPane().add(lblCustomerName);
		
		lblConsumerName = new JLabel("");
		lblConsumerName.setBounds(340, 182, 280, 28);
		lblConsumerName.setHorizontalAlignment(SwingConstants.CENTER);
		frameNewBill.getContentPane().add(lblConsumerName);
		
		
		lblAddress.setBounds(91, 221, 79, 14);
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		frameNewBill.getContentPane().add(lblAddress);
		
		JLabel lblCity = new JLabel("City/District");
		lblCity.setBounds(69, 308, 94, 14);
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		frameNewBill.getContentPane().add(lblCity);
		
		sp_unit_consumed = new JSpinner();
		sp_unit_consumed.setBounds(460, 386, 160, 20);
		sp_unit_consumed.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		frameNewBill.getContentPane().add(sp_unit_consumed);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(92, 283, 71, 14);
		lblContact.setHorizontalAlignment(SwingConstants.RIGHT);
		frameNewBill.getContentPane().add(lblContact);
		
		JLabel label_1 = new JLabel("+91");
		label_1.setBounds(340, 283, 31, 14);
		frameNewBill.getContentPane().add(label_1);
		
		label_cno = new JLabel("");
		label_cno.setBounds(340, 283, 258, 14);
		label_cno.setHorizontalAlignment(SwingConstants.CENTER);
		frameNewBill.getContentPane().add(label_cno);
		
		lblCityName = new JLabel("");
		lblCityName.setBounds(340, 302, 280, 20);
		lblCityName.setHorizontalAlignment(SwingConstants.CENTER);
		frameNewBill.getContentPane().add(lblCityName);
		
		JLabel lblUnitsConsumed = new JLabel("Units Consumed");
		lblUnitsConsumed.setBounds(283, 389, 107, 14);
		lblUnitsConsumed.setHorizontalAlignment(SwingConstants.RIGHT);
		frameNewBill.getContentPane().add(lblUnitsConsumed);
		
		JLabel lblUnitPrice = new JLabel("Unit Price");
		lblUnitPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUnitPrice.setBounds(311, 420, 79, 14);
		frameNewBill.getContentPane().add(lblUnitPrice);
		
		sp_unit_price = new JSpinner();
		sp_unit_price.setModel(new SpinnerNumberModel(8, 6, 10, 1));
		sp_unit_price.setBounds(559, 417, 61, 20);
		frameNewBill.getContentPane().add(sp_unit_price);
		
		JLabel lblMinnmax = new JLabel("6-10");
		lblMinnmax.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinnmax.setBounds(666, 417, 46, 20);
		frameNewBill.getContentPane().add(lblMinnmax);

		lblMinnmax.setVisible(true);
		
		frameNewBill.getContentPane().add(btnPayNow);
		
		btnPayNow.setVisible(false);
		
		btnPayNow.setBounds(421, 543, 127, 23);
		
		btnGetDetails.setBounds(340, 134, 280, 23);
		
		frameNewBill.getContentPane().add(btnGetDetails);
		
		btnGoBack.setBounds(445, 592, 89, 23);
		frameNewBill.getContentPane().add(btnGoBack);
		

		/* if(LoginPage.unametopass!=null){
		lblK.setText("Logged in as: "+LoginPage.unametopass);
		}
		else{
			lblK.setText("Logged in as: Anonymous");
	
		} */
		
		unitConsumed=sp_unit_consumed.getValue().toString();
		unitPrice=sp_unit_price.getValue().toString();
		
		btnSubmit.setBounds(340, 509, 280, 23);
		frameNewBill.getContentPane().add(btnSubmit);
		
		JLabel lblSelectBillCycle = new JLabel("Select Bill Cycle Month");
		lblSelectBillCycle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelectBillCycle.setBounds(151, 436, 253, 50);
		frameNewBill.getContentPane().add(lblSelectBillCycle);
		
		spinner = new JSpinner();
		spinner.setToolTipText("Select Month");
		spinner.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		spinner.setModel(new SpinnerListModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		spinner.setBounds(459, 447, 89, 23);
		frameNewBill.getContentPane().add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setToolTipText("Select Year");
		spinner_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		spinner_1.setModel(new SpinnerNumberModel(2017, 2013, 2023, 1));
		spinner_1.setBounds(553, 447, 67, 23);
		frameNewBill.getContentPane().add(spinner_1);
		
		textArea = new JTextArea();
		textArea.setBounds(340, 216, 610, 50);
		frameNewBill.getContentPane().add(textArea);
		
		JLabel label_3 = new JLabel("_______________________________________________________");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(10, 333, 940, 14);
		frameNewBill.getContentPane().add(label_3);
		
		JLabel lblEnterUnitsUnit = new JLabel("Enter Units, Unit Price and Bill Cycle");
		lblEnterUnitsUnit.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterUnitsUnit.setBounds(10, 358, 940, 14);
		frameNewBill.getContentPane().add(lblEnterUnitsUnit);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(BillGenerateNewBill.class.getResource("bg_gray.png")));
		label_2.setBounds(-18, 0, 1031, 697);
		frameNewBill.getContentPane().add(label_2);
		
		
		btnPayNow.addActionListener(this);
		btnGoBack.addActionListener(this);
		btnGetDetails.addActionListener(this);
		btnSubmit.addActionListener(this);
		/*b4.addActionListener(this);
		b4.addActionListener(this);
		b4.addActionListener(this);
		b4.addActionListener(this);
		b4.addActionListener(this);
		b4.addActionListener(this);*/

	}
	
	public void actionPerformed(ActionEvent e) 
	{
			if(e.getSource()==btnPayNow)
			{
				System.out.println("hi");
			}
			else if(e.getSource()==btnGoBack)
			{
				LandingPage page = new LandingPage();
				page.frameLandingPage.setVisible(true);
				frameNewBill.dispose();
				
			}
			else if(e.getSource()==btnGetDetails)
			{
     			String accountNumber=accontNumber.getText().toString();

				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");																
				String s1="select * from customerdetails where accno=?"; 
				//account
				PreparedStatement pst=con.prepareStatement(s1);  
				pst.setString(1,accountNumber);
				ResultSet rs=pst.executeQuery();
				if (rs.next()) 
				{
					JOptionPane.showMessageDialog(frameNewBill, " Details found for: "+accountNumber);
					lblConsumerName.setText(rs.getString("custname"));
					label_cno.setText(rs.getString("custContact"));
					addr=rs.getString("custaddr");
					textArea.setText(rs.getString("custaddr"));
					lblCityName.setText(rs.getString("custcity"));
				}
				else
				{
					JOptionPane.showMessageDialog(frameNewBill, "No such Account Number exist! Please check again");
					int response1 = JOptionPane.showConfirmDialog(null, "Do you want to goto Add Customer ?");
						    if (response1 ==0) 
							{
						     System.out.println("0");
						    	
						    } 
							else if (response1 ==1) 
							{
						    	System.out.println("1");
						     
						    } 
							else if (response1 ==2) 
							{
						    	System.out.println("2");
						     
						    } 
				}
				}	
				catch (ClassNotFoundException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e2) 
				{
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}				
					
					
			}
			else if(e.getSource()==btnSubmit)
			{
				String account2=accontNumber.getText().toString();
				String custname=lblConsumerName.getText().toString();
				String address=lblAddress.getText().toString();
				String contactno=label_cno.getText().toString();
				String cityName=lblCityName.getText().toString();
				String unitC=sp_unit_consumed.getValue().toString();
				String unitP=sp_unit_price.getValue().toString();
				String paidStatus="0";
				
				String mo1=spinner.getValue().toString();
				String yr1=spinner_1.getValue().toString();
				String dateB1= mo1+" "+yr1 ;
				
				//System.out.println(" "+dateB1);
				
				String t2 = String.valueOf(Integer.valueOf(unitC) * Integer.valueOf(unitP));
				
			
				if (account2.equals("")) 
				{
					JOptionPane.showMessageDialog(frameNewBill, "Please enter Account Number");
				}

				else if (account2.contains(" ")) 
				{
					JOptionPane.showMessageDialog(frameNewBill, "Account Number cannot have spaces.");
					
				}
		
				else
				{
					try
					{
						
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String s1="select * from customerdetails where accno=?"; 
					PreparedStatement pst=con.prepareStatement(s1);  
					pst.setString(1,account2);
					ResultSet row2=pst.executeQuery();
					
															//																							//
					if (row2.next()) 
					{
						
					
					//	String qu2= "insert into customerdetails ( accno,custname, custaddr, custcity, custcontact, unitconsumed, unitprice, paid, billDate, billAmt)" + "values ('"+account2+"','"+custname+"','"+address+"','"+cityName+"','"+contactno+"','"+unitC+"','"+unitP+"','"+paidStatus+"','"+dateB1+"','"+t2+"')";

					//	String qu2= "insert into customerdetails (accno, custname, custaddr, custcity, custcontact, unitconsumed, unitprice, paid, billDate, billAmt) values ('"+account2+"','"+custname+"','"+address+"','"+cityName+"','"+contactno+"','"+unitC+"','"+unitP+"','"+paidStatus+"','"+dateB1+"','"+t2+"')";
						
						//String qu2 = "update into customerdetails values('" +account2+ "', '" +custname+"', '" +address+ "', '" +contactno+ "' , '" +cityName+"', '" +unitC+"', '" +unitP+ "', '" +paidStatus+ "' , '" +dateB1+"', '" +t2+ "')"; 

						//int x = stmt.executeUpdate(q1); 
						
						String q2 ="UPDATE customerdetails SET UNITCONSUMED = ? , UNITPRICE = ? , PAID = ? , BILLDATE = ? , BILLAMT = ? WHERE ACCNO= ?";
						PreparedStatement pst2=con.prepareStatement(q2); 
						pst2.setString(1, unitC);
						pst2.setString(2, unitP);
						pst2.setString(3, paidStatus);
						pst2.setString(4, dateB1);
						pst2.setString(5, t2);
						pst2.setString(6, account2);
						int row = pst2.executeUpdate();
						System.out.println(String.format("Row affected %d", row));
						
						if (row > 0 ) {   

						System.out.println("Successfully Inserted"); }

						else {

						System.out.println("Insert Failed"); }
					
						int response = JOptionPane.showConfirmDialog(null, row+" Bill Uploaded successfully!!! "+ "Do you want to continue?", "Bill Generated", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						    if (response == JOptionPane.NO_OPTION) 
							{
						     LandingPage page = new LandingPage();
						     page.frameLandingPage.setVisible(true);
						     frameNewBill.dispose();
						    	
						    } 
							else if (response == JOptionPane.YES_OPTION) 
							{
						    	btnPayNow.setVisible(true);
						    	//frameNewBill.dispose();
						    	
						    	/*BillGenerateNewBill n= new BillGenerateNewBill();
						    	n.frameNewBill.setVisible(true);*/
						     
						    } 
							
					}
					else
					{
						JOptionPane.showMessageDialog(frameNewBill, " Account not found");
						//frmAddNewCustomer.dispose();	
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
				catch (Exception e3) 
				{
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}  	
					
					
				}
				
			}
	
	}
	public static void main(String[] args) 
	{
		BillGenerateNewBill window = new BillGenerateNewBill();
		window.frameNewBill.setVisible(true);

	}
}
