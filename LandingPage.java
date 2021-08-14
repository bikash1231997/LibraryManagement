import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LandingPage implements ActionListener
{

	JFrame frameLandingPage;
	JButton btnCalculator = new JButton("Calculator");
	JButton btnGenerateANew = new JButton("Generate a new bill");
	JButton btnPayBill = new JButton("Pay Bill");
	JButton btnAddNewCustomer = new JButton("Add New Customer");
	JButton btnViewPreviousBills = new JButton("View Previous Bills");
	JButton btnLogOut = new JButton("Log Out");
	JButton btnAboutDeveloper = new JButton("About Developer");
	JButton btnFeedback = new JButton("Feedback");
	JButton btnViewAllCustomers = new JButton("View All Customers");
	JButton btnNewButton = new JButton("OTP via SMS");

	
	public LandingPage() 
	{

		frameLandingPage = new JFrame();
		frameLandingPage.setIconImage(Toolkit.getDefaultToolkit().getImage(LandingPage.class.getResource("power_icon.png")));
		frameLandingPage.setResizable(false);
		frameLandingPage.setTitle("Welcome Page");
		frameLandingPage.setBounds(100, 100, 1038, 765);
		frameLandingPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLandingPage.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Logged in as Merchant");
		lblWelcome.setFont(new Font("Sacramento", Font.PLAIN, 30));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(10, 70, 864, 45);
		frameLandingPage.getContentPane().add(lblWelcome);
		
		JLabel lblHelloUser = new JLabel("");
		lblHelloUser.setFont(new Font("Cookie", Font.PLAIN, 30));
		lblHelloUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelloUser.setBounds(10, 146, 1012, 34);
		frameLandingPage.getContentPane().add(lblHelloUser);

		if(LoginPage.unametopass != null)
		{
		lblHelloUser.setText("Hello "+LoginPage.unametopass);
		}
		else
		{
			lblHelloUser.setText("Hello User!");
				
		}
		JLabel label = new JLabel("_______________________________________________");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(8, 115, 880, 14);
		frameLandingPage.getContentPane().add(label);
		
		btnCalculator.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		btnCalculator.setBounds(154, 228, 89, 23);
		
		JLabel label_1 = new JLabel("_______________________________________________");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 30, 1012, 26);
		frameLandingPage.getContentPane().add(label_1);
		
		/*JLabel label_2 = new JLabel("____________");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(10, 178, 1012, 14);
		frameLandingPage.getContentPane().add(label_2);*/
		
		btnGenerateANew.setBounds(363, 262, 298, 68);
		frameLandingPage.getContentPane().add(btnGenerateANew);
	
		btnPayBill.setBounds(668, 262, 298, 68);
		frameLandingPage.getContentPane().add(btnPayBill);
		
		btnAddNewCustomer.setBounds(55, 261, 298, 68);
		frameLandingPage.getContentPane().add(btnAddNewCustomer);
		
		
		btnViewPreviousBills.setBounds(363, 357, 298, 63);
		frameLandingPage.getContentPane().add(btnViewPreviousBills);
		
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBackground(Color.RED);
		
		btnLogOut.setBounds(363, 473, 298, 26);
		frameLandingPage.getContentPane().add(btnLogOut);
		
		
		
		btnAboutDeveloper.setBounds(390, 602, 237, 23);
		frameLandingPage.getContentPane().add(btnAboutDeveloper);
		
		JLabel lblBikashMahapatra = new JLabel("Made");
		lblBikashMahapatra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBikashMahapatra.setHorizontalAlignment(SwingConstants.CENTER);
		lblBikashMahapatra.setBounds(10, 636, 1012, 26);
		frameLandingPage.getContentPane().add(lblBikashMahapatra);
		
		JLabel lblBy = new JLabel("by");
		lblBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblBy.setBounds(10, 661, 1012, 23);
		frameLandingPage.getContentPane().add(lblBy);
		
		JLabel lblBikashMahapatra1 = new JLabel("Bikash Mahapatra");
		lblBikashMahapatra1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBikashMahapatra1.setFont(new Font("Cookie", Font.PLAIN, 28));
		lblBikashMahapatra1.setBounds(10, 681, 1012, 45);
		frameLandingPage.getContentPane().add(lblBikashMahapatra1);
		
		JLabel lblElectricityBillGeneration = new JLabel("Electricity Bill Generation and Paying System");
		lblElectricityBillGeneration.setFont(new Font("Raleway", Font.PLAIN, 17));
		lblElectricityBillGeneration.setHorizontalAlignment(SwingConstants.CENTER);
		lblElectricityBillGeneration.setBounds(10, 11, 1012, 48);
		frameLandingPage.getContentPane().add(lblElectricityBillGeneration);
		
		btnFeedback.setBounds(407, 547, 200, 34);
		frameLandingPage.getContentPane().add(btnFeedback);
	
		btnViewAllCustomers.setBounds(55, 357, 298, 63);
		frameLandingPage.getContentPane().add(btnViewAllCustomers);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(LandingPage.class.getResource("back_5.jpg")));
		label_3.setBounds(0, 0, 1053, 760);
		frameLandingPage.getContentPane().add(label_3);
		
		
		
		btnNewButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		btnNewButton.setBounds(141, 203, 117, 34);
	//	frameLandingPage.getContentPane().add(btnNewButton);
		//TODO: Remove above comment
		
		btnGenerateANew.addActionListener(this);
		btnPayBill.addActionListener(this);
		btnAddNewCustomer.addActionListener(this);
		btnViewPreviousBills.addActionListener(this);
		btnLogOut.addActionListener(this);
		btnAboutDeveloper.addActionListener(this);
		btnCalculator.addActionListener(this);
		btnFeedback.addActionListener(this);
		btnViewAllCustomers.addActionListener(this);
		btnNewButton.addActionListener(this);
		/*b4.addActionListener(this);
		b4.addActionListener(this);
		b4.addActionListener(this);*/
	}
	
	public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource()==btnGenerateANew)
			{
				BillGenerateNewBill newBill = new BillGenerateNewBill();
				newBill.frameNewBill.setVisible(true);
				frameLandingPage.dispose();
				
			}
			else if(e.getSource()==btnPayBill)
			{
				BillPayBill payBill = new BillPayBill();
				payBill.frmPayBillsHere.setVisible(true);
				frameLandingPage.dispose();
			}
			else if(e.getSource()==btnAddNewCustomer)
			{
				BillAddNewCustomer addNewCustomer = new BillAddNewCustomer();
			   addNewCustomer.frmAddNewCustomer.setVisible(true);
				frameLandingPage.dispose();	
			}
			else if(e.getSource()==btnViewPreviousBills)
			{
				BillViewOldBillOptions viewOldBillOptions = new BillViewOldBillOptions();
				viewOldBillOptions.frmViewPreviousBills.setVisible(true);
				frameLandingPage.dispose();
			}
			else if(e.getSource()==btnLogOut)
			{
				StartPage page = new StartPage();
				page.frmWelcome.setVisible(true);
				frameLandingPage.dispose();
			}
			else if(e.getSource()==btnAboutDeveloper)
			{
				AboutDeveloper aboutDeveloper = new AboutDeveloper();
				aboutDeveloper.frmAboutDeveloper.setVisible(true);
				frameLandingPage.dispose();
			}
			else if(e.getSource()==btnCalculator)
			{
				
			}
			else if(e.getSource()==btnFeedback)
			{
				MerchantFeedback page = new MerchantFeedback();
				page.frmFeedback.setVisible(true);
				frameLandingPage.dispose();
			}
			else if(e.getSource()==btnViewAllCustomers)
			{
				ViewAllCustomer viewAllCustomer = new ViewAllCustomer();
				viewAllCustomer.frmViewAllCustomers.setVisible(true);
				frameLandingPage.dispose();
			}
			else if(e.getSource()==btnNewButton)
			{
				
			}
			/*else if(e.getSource()==btnGenerateANew)
			{
				
			}*/
		}
	
	public static void main(String[] args) 
	{

		LandingPage window = new LandingPage();
		window.frameLandingPage.setVisible(true);
	}


}
