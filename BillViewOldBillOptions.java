import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BillViewOldBillOptions implements ActionListener 
{

	JFrame frmViewPreviousBills;
	
	JButton btnViewUnpaidBills = new JButton("View Unpaid Bills");
	JButton btnNewButton = new JButton("View Paid Bills");
	JButton btnFeedback = new JButton("Feedback");
	JButton btnGoBack = new JButton("Go Back");
	
	
	public BillViewOldBillOptions() 
	{
		frmViewPreviousBills = new JFrame();
		frmViewPreviousBills.setIconImage(Toolkit.getDefaultToolkit().getImage(BillViewOldBillOptions.class.getResource("power_icon.png")));
		frmViewPreviousBills.setResizable(false);
		frmViewPreviousBills.setTitle("View Previous Bills");
		frmViewPreviousBills.setBounds(100, 100, 943, 589);
		frmViewPreviousBills.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewPreviousBills.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome User");
		
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Cookie", Font.PLAIN, 35));
		lblWelcome.setBounds(10, 37, 917, 54);
		/* if(LoginPage.unametopass==null){
			lblWelcome.setText("Welcome User!");
			
		}
		
		else{
			lblWelcome.setText("Welcome "+LoginPage.unametopass+"!");
			
		} */
		frmViewPreviousBills.getContentPane().add(lblWelcome);
		
		btnViewUnpaidBills.setBounds(103, 148, 276, 81);
		frmViewPreviousBills.getContentPane().add(btnViewUnpaidBills);
		
		btnNewButton.setBounds(533, 148, 276, 81);
		frmViewPreviousBills.getContentPane().add(btnNewButton);
	
		btnGoBack.setBounds(408, 327, 89, 23);
		frmViewPreviousBills.getContentPane().add(btnGoBack);
		
		btnFeedback.setBounds(357, 478, 200, 50);
		frmViewPreviousBills.getContentPane().add(btnFeedback);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BillViewOldBillOptions.class.getResource("bg_gray.png")));
		label.setBounds(-17, 0, 968, 579);
		frmViewPreviousBills.getContentPane().add(label);
		
		btnViewUnpaidBills.addActionListener(this);
		btnNewButton.addActionListener(this);
		btnGoBack.addActionListener(this);
		btnFeedback.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
			if(e.getSource()==btnViewUnpaidBills)
			{
				BillViewUnpaidBills viewUnpaidBills = new BillViewUnpaidBills();
				viewUnpaidBills.frmViewUnpaidBills.setVisible(true);
				frmViewPreviousBills.dispose();
			}
			else if(e.getSource()==btnNewButton)
			{
				BillViewPaidBills viewUnpaidBills = new BillViewPaidBills();
				viewUnpaidBills.frmViewPaidBils.setVisible(true);
				frmViewPreviousBills.dispose();
			}
			else if(e.getSource()==btnGoBack)
			{
				LandingPage page = new LandingPage();
				page.frameLandingPage.setVisible(true);
				frmViewPreviousBills.dispose();
			}
			else if(e.getSource()==btnFeedback)
			{
				MerchantFeedback feedback = new MerchantFeedback();
				feedback.frmFeedback.setVisible(true);
				frmViewPreviousBills.dispose();
			}
	}
	
	public static void main(String[] args) 
	{
		BillViewOldBillOptions window = new BillViewOldBillOptions();
		window.frmViewPreviousBills.setVisible(true);
	}


}
