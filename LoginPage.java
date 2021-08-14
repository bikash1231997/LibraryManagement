import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LoginPage implements ActionListener 
{

	JFrame frameLoginPage;
	JPasswordField passwordField;
	JTextField textFieldUName;
	JButton btnLogIn = new JButton("Log In");
	JButton btnGoBack = new JButton("Go Back");
	JButton btnSignup = new JButton("Signup");
	
	static String unametopass;
	
	LoginPage()
	{
		frameLoginPage = new JFrame();
		frameLoginPage.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("power_icon.png")));
		frameLoginPage.setResizable(false);
		frameLoginPage.getContentPane().setBackground(Color.WHITE);
		frameLoginPage.setBackground(Color.WHITE);
		frameLoginPage.setTitle("Log In to continue");
		frameLoginPage.setBounds(100, 100, 924, 634);
		frameLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLoginPage.getContentPane().setLayout(null);

		
		JLabel lblLogInTo = new JLabel("Log In to continue");
		lblLogInTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogInTo.setFont(new Font("Raleway", Font.PLAIN, 18));
		lblLogInTo.setBounds(10, 69, 847, 67);
		frameLoginPage.getContentPane().add(lblLogInTo);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Raleway", Font.PLAIN, 15));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(10, 184, 847, 23);
		frameLoginPage.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Raleway", Font.PLAIN, 15));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(10, 252, 847, 39);
		frameLoginPage.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter Password ");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(148, 302, 565, 23);
		frameLoginPage.getContentPane().add(passwordField);
		
		textFieldUName = new JTextField();
		textFieldUName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUName.setToolTipText("Enter Username");
		textFieldUName.setBounds(148, 218, 565, 23);
		frameLoginPage.getContentPane().add(textFieldUName);
		textFieldUName.setColumns(10);
		
		//JButton btnLogIn = new JButton("Log In");
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setFont(new Font("Raleway", Font.PLAIN, 13));
		btnLogIn.setBackground(new Color(100, 149, 237));
		
		
		btnLogIn.setBounds(225, 336, 401, 47);
		frameLoginPage.getContentPane().add(btnLogIn);
		
		JLabel lblOr = new JLabel("or");
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setBounds(363, 425, 115, 14);
		frameLoginPage.getContentPane().add(lblOr);
		
		//JButton btnSignup = new JButton("Signup");
		btnSignup.setForeground(new Color(0, 0, 0));
		btnSignup.setBackground(new Color(0, 250, 154));
		btnSignup.setFont(new Font("Raleway", Font.PLAIN, 12));
		btnSignup.setBounds(290, 465, 271, 39);
		frameLoginPage.getContentPane().add(btnSignup);
		
		JLabel lblMerchantLogin = new JLabel("Merchant Login");
		lblMerchantLogin.setBackground(Color.LIGHT_GRAY);
		lblMerchantLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMerchantLogin.setFont(new Font("Raleway", Font.PLAIN, 20));
		lblMerchantLogin.setBounds(297, 27, 264, 47);
		frameLoginPage.getContentPane().add(lblMerchantLogin);
		
		//JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(10, 10, 153, 23);
		frameLoginPage.getContentPane().add(btnGoBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginPage.class.getResource("main_bg.jpg")));
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(0, 0, 918, 617);
		frameLoginPage.getContentPane().add(label);
		
		
		btnLogIn.addActionListener(this);
		btnGoBack.addActionListener(this);
		btnSignup.addActionListener(this);		
		
	}
	public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource()==btnLogIn)
			{
				
				String username=textFieldUName.getText().toString();
				String password=passwordField.getText().toString();		
				
				unametopass=username;

				if (username.equals("")) 
				{
					JOptionPane.showMessageDialog(frameLoginPage, "Username cannot be blank ");
					
				}
				else if (username.contains(" ")) 
				{
					JOptionPane.showMessageDialog(frameLoginPage, "Username cannot have blank spaces! ");
					
				}
				else if (password.equals("")) 
				{
					JOptionPane.showMessageDialog(frameLoginPage, "Password cannot be blank");
					
				}
				
				else
				{
				
				
					try
					{  	
					
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
						String s1="select * from users where username=? and password=?"; 
						PreparedStatement pst=con.prepareStatement(s1);  
						pst.setString(1,username);
						pst.setString(2, password);
						ResultSet rs=pst.executeQuery();
						if (rs.next()) 
						{
							JOptionPane.showMessageDialog(frameLoginPage, " Logged In successfully!");
							
							LandingPage landingPage = new LandingPage();
							landingPage.frameLandingPage.setVisible(true);
							frameLoginPage.dispose();
							
						}
						else
						{
							JOptionPane.showMessageDialog(frameLoginPage, " Username/Password is Wrong or User is not verified by Admin. Contact Admin");
										
						}	
						con.close();
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
						e3.printStackTrace();
					}  
			    }
		    }
			else if(e.getSource()==btnGoBack)
			{
				StartPage page = new StartPage();
				page.frmWelcome.setVisible(true);
				frameLoginPage.dispose();
			}
			else if(e.getSource()==btnSignup)
			{
				SignUpPage page = new SignUpPage();
				page.frameSignUp.setVisible(true);
				frameLoginPage.dispose();
				
			}
				
				
		}
	public static void main(String[] args) 
	{
		LoginPage window = new LoginPage();
		window.frameLoginPage.setVisible(true);
				
	}

}
