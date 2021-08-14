import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class StartPage implements ActionListener
{

	JFrame frmWelcome;
	JButton btnLogIn1 = new JButton("LogIn");
	JButton btnLogin = new JButton("AdminLogin");
	JButton btnSignUp = new JButton("Sign Up");
	JButton btnAboutDeveloper = new JButton("About Developer");
	//JButton btnConfigure = new JButton("Configure");

	public StartPage()
	{
		frmWelcome = new JFrame();
		frmWelcome.setResizable(false);
		frmWelcome.setIconImage(Toolkit.getDefaultToolkit().getImage(StartPage.class.getResource("power_icon.png")));
		frmWelcome.setTitle("Welcome !");
		frmWelcome.getContentPane().setBackground(new Color(255, 255, 255));
		frmWelcome.getContentPane().setForeground(Color.BLACK);
		frmWelcome.setBackground(Color.WHITE);
		frmWelcome.setBounds(100, 100, 990, 750);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);
		
		JLabel lblElectricityBillGenerator = new JLabel("Electricity Bill Generator");
		lblElectricityBillGenerator.setHorizontalAlignment(SwingConstants.CENTER);
		lblElectricityBillGenerator.setFont(new Font("Cookie", Font.PLAIN, 36));
		lblElectricityBillGenerator.setBounds(10, 48, 1000, 55);
		frmWelcome.getContentPane().add(lblElectricityBillGenerator);
		
		/*JLabel lblAJdbcswingApplication = new JLabel("A JDBC-Swing Application");
		lblAJdbcswingApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblAJdbcswingApplication.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblAJdbcswingApplication.setBounds(10, 102, 990, 24);
		frmWelcome.getContentPane().add(lblAJdbcswingApplication);*/
		
		JLabel label = new JLabel("__________________________________________________________");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(20, 89, 1000, 14);
		frmWelcome.getContentPane().add(label);
		
		JLabel lblMadeBy = new JLabel("Made by");
		lblMadeBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblMadeBy.setBounds(10, 515, 1000, 14);
		frmWelcome.getContentPane().add(lblMadeBy);
		
		JLabel lblBikashMahapatra = new JLabel("Bikash Mahapatra");
		lblBikashMahapatra.setHorizontalAlignment(SwingConstants.CENTER);
		lblBikashMahapatra.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		lblBikashMahapatra.setBounds(10, 543, 1000, 32);
		frmWelcome.getContentPane().add(lblBikashMahapatra);
		
		btnLogIn1.setFont(new Font("Raleway", Font.PLAIN, 13));
		
		btnLogIn1.setBackground(UIManager.getColor("Button.background"));
		btnLogIn1.setBounds(45, 208, 296, 48);
		frmWelcome.getContentPane().add(btnLogIn1);
		
		JLabel lblOr = new JLabel("or");
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setBounds(45, 267, 296, 14);
		frmWelcome.getContentPane().add(lblOr);
		
		
		btnSignUp.setFont(new Font("Raleway", Font.PLAIN, 12));
		btnSignUp.setForeground(Color.BLACK);
		btnSignUp.setBackground(UIManager.getColor("Button.background"));
		
			
		btnSignUp.setBounds(45, 292, 296, 38);
		frmWelcome.getContentPane().add(btnSignUp);
		
		JLabel lblMerchantLogin = new JLabel("Customer Login");
		lblMerchantLogin.setFont(new Font("Raleway", Font.PLAIN, 15));
		lblMerchantLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMerchantLogin.setBounds(45, 165, 296, 32);
		frmWelcome.getContentPane().add(lblMerchantLogin);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setFont(new Font("Raleway", Font.PLAIN, 15));
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setBounds(692, 171, 268, 21);
		frmWelcome.getContentPane().add(lblAdminLogin);
		
				
		btnLogin.setFont(new Font("Raleway", Font.PLAIN, 13));
		btnLogin.setBounds(692, 208, 275, 48);
		frmWelcome.getContentPane().add(btnLogin);
		
		/*JLabel lblDiv = new JLabel("--------------------------------------------------------------------");
		lblDiv.setBounds(692, 267, 296, 14);
		frmWelcome.getContentPane().add(lblDiv);*/

		/*btnConfigure.setFont(new Font("Raleway", Font.PLAIN, 13));
		btnConfigure.setBounds(692, 292, 275, 38);
		frmWelcome.getContentPane().add(btnConfigure); */
		
		btnAboutDeveloper.setBounds(409, 581, 200, 32);
		frmWelcome.getContentPane().add(btnAboutDeveloper);
		
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(StartPage.class.getResource("back_3.jpg")));
		label_1.setBounds(0, 0, 1044, 743);
		frmWelcome.getContentPane().add(label_1);
		
		
		btnAboutDeveloper.addActionListener(this);
		btnLogin.addActionListener(this);
		btnSignUp.addActionListener(this);
		btnLogIn1.addActionListener(this);
		//btnConfigure.addActionListener(this);
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnLogin)
		{
			AdminLogin adminLogin = new AdminLogin();
			adminLogin.frmAdminLogin.setVisible(true);
			frmWelcome.dispose(); 
		}
		/*else if(e.getSource()==btnConfigure)
		{
			String pass=JOptionPane.showInputDialog("Enter Password");

				if (pass.equals("bikash"))
				{
					
					JOptionPane.showMessageDialog(frmWelcome, "Logged In Successfully!");
					System.out.println("hello i am configure");
					
					 SetDBValues setDBValues = new  SetDBValues();
					setDBValues.frmSetDbValues.setVisible(true);
					frmWelcome.dispose(); 
					
				}
				else 
				{
					JOptionPane.showMessageDialog(frmWelcome, "Error!");
					
				}
		}*/
		else if (e.getSource()==btnAboutDeveloper)
		{
			AboutDeveloper aboutDeveloper = new AboutDeveloper();
			aboutDeveloper.frmAboutDeveloper.setVisible(true);
			frmWelcome.dispose();
		}
		else if (e.getSource()==btnSignUp)
		{
			SignUpPage page = new SignUpPage();
			page.frameSignUp.setVisible(true);
			frmWelcome.dispose();
		}
		else if(e.getSource()==btnLogIn1)
		{
			LoginPage page = new LoginPage();
			page.frameLoginPage.setVisible(true);
			frmWelcome.dispose(); 
		} 
	}		
	
	
	public static void main(String[] args) 
	{
		StartPage s1 = new StartPage();
		s1.frmWelcome.setVisible(true);
	}

}
