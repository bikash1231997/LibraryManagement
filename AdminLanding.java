import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AdminLanding implements ActionListener 
{

	JFrame frmAdminLandingPage;
	
	JButton btnNewButton = new JButton("Verify Merchants");
	JButton btnViewFeedbacksFrom = new JButton("View Feedbacks from Merchant");
	JButton btnViewAllMerchants = new JButton("View All Merchants");
	JButton btnLogOut = new JButton("Log out");
				

	
	public AdminLanding() 
	{
		frmAdminLandingPage = new JFrame();
		frmAdminLandingPage.setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLanding.class.getResource("power_icon.png")));
		frmAdminLandingPage.setTitle("Admin Landing Page");
		frmAdminLandingPage.setResizable(false);
		frmAdminLandingPage.setBounds(100, 100, 1010, 703);
		frmAdminLandingPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminLandingPage.getContentPane().setLayout(null);
		
		btnNewButton.setBounds(223, 226, 450, 50);
		frmAdminLandingPage.getContentPane().add(btnNewButton);
		
		JLabel lblHelloAdmin = new JLabel("Hello Admin!");
		lblHelloAdmin.setFont(new Font("Raleway", Font.PLAIN, 35));
		lblHelloAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelloAdmin.setBounds(10, 56, 911, 61);
		frmAdminLandingPage.getContentPane().add(lblHelloAdmin);
		
		
		btnViewAllMerchants.setBounds(223, 301, 451, 50);
		frmAdminLandingPage.getContentPane().add(btnViewAllMerchants);
		
		
		btnLogOut.setBounds(357, 525, 200, 50);
		frmAdminLandingPage.getContentPane().add(btnLogOut);
		
		
		btnViewFeedbacksFrom.setBounds(223, 382, 450, 50);
		frmAdminLandingPage.getContentPane().add(btnViewFeedbacksFrom);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminLanding.class.getResource("back_8.png")));
		label.setBounds(-23, 0, 1031, 700);
		frmAdminLandingPage.getContentPane().add(label);
		
		btnViewFeedbacksFrom.addActionListener(this);
		btnLogOut.addActionListener(this);
		btnNewButton.addActionListener(this);
		btnViewAllMerchants.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
			if(e.getSource()==btnViewFeedbacksFrom)
			{
				ViewFeedbacks feedbacks = new ViewFeedbacks();
				feedbacks.frmViewFeedbackss.setVisible(true);
				frmAdminLandingPage.dispose();
				
			}
			else if(e.getSource()==btnLogOut)
			{
				StartPage page = new StartPage();
				page.frmWelcome.setVisible(true);
				frmAdminLandingPage.dispose();
			}
			else if(e.getSource()==btnNewButton)
			{
				AdminVerifyMerchant verifyMerchant= new AdminVerifyMerchant();
				verifyMerchant.frmVerifyMerchants.setVisible(true);
				frmAdminLandingPage.dispose();
			}
			else if(e.getSource()==btnViewAllMerchants)
			{
				ViewAllMerchant allMerchant = new ViewAllMerchant();
				allMerchant.frm.setVisible(true);
				frmAdminLandingPage.dispose();
			}
	}
	
	
	public static void main(String[] args) 
	{
		AdminLanding window = new AdminLanding();
		window.frmAdminLandingPage.setVisible(true);
	}
}
