import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class SignUpPage implements ActionListener
{

	JFrame frameSignUp;
	private JTextField txtFullName;
	private JTextField txtUserName;
	private JPasswordField passwordField;
	JButton btnSignUp = new JButton("Sign Up");
	JButton btnLogIn = new JButton("Log In");

	public SignUpPage() 
	{
		frameSignUp = new JFrame();
		frameSignUp.setIconImage(Toolkit.getDefaultToolkit().getImage(SignUpPage.class.getResource("power_icon.png")));
		frameSignUp.setResizable(false);
		frameSignUp.setTitle("Sign Up to continue");
		frameSignUp.setBounds(100, 100, 915, 658);
		frameSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSignUp.getContentPane().setLayout(null);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("GTWalsheimLight", Font.PLAIN, 23));
		lblSignUp.setBounds(10, 104, 889, 36);
		frameSignUp.getContentPane().add(lblSignUp);
		
		JLabel lblName = new JLabel("Full Name");
		lblName.setBounds(154, 208, 70, 22);
		frameSignUp.getContentPane().add(lblName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(154, 243, 70, 14);
		frameSignUp.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(154, 274, 70, 14);
		frameSignUp.getContentPane().add(lblPassword);
		
		txtFullName = new JTextField();
		txtFullName.setBounds(341, 209, 309, 20);
		frameSignUp.getContentPane().add(txtFullName);
		txtFullName.setColumns(10);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(341, 240, 309, 20);
		frameSignUp.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(341, 271, 309, 20);
		frameSignUp.getContentPane().add(passwordField);
	
		btnSignUp.setBounds(260, 344, 349, 23);
		frameSignUp.getContentPane().add(btnSignUp);
		
		btnLogIn.setBounds(367, 428, 153, 23);
		frameSignUp.getContentPane().add(btnLogIn);
		
		JLabel label = new JLabel("______________________________________");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(289, 378, 269, 14);
		frameSignUp.getContentPane().add(label);
		
		JLabel lblAlreadyAUser = new JLabel("Already a User?");
		lblAlreadyAUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlreadyAUser.setBounds(357, 403, 153, 14);
		frameSignUp.getContentPane().add(lblAlreadyAUser);
		
		JLabel lblAsMerchant = new JLabel("as Merchant");
		lblAsMerchant.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsMerchant.setBounds(20, 143, 879, 14);
		frameSignUp.getContentPane().add(lblAsMerchant);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SignUpPage.class.getResource("back_3.jpg")));
		label_1.setBounds(-13, 0, 951, 685);
		frameSignUp.getContentPane().add(label_1);
		
		
		btnSignUp.addActionListener(this);
		btnLogIn.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==btnSignUp)
		{
		String xname=txtFullName.getText().toString();
		String yuname=txtUserName.getText().toString();
		String zpass2=new String(passwordField.getPassword());
		String cnfrmd="0";
		if (xname.equals("")) 
		{
		JOptionPane.showMessageDialog(frameSignUp, "Name cannot be blank");
			
		}
			
		else if (yuname.equals("")) 
		{
		JOptionPane.showMessageDialog(frameSignUp, "Username cannot be blank ");
					
		}
		else if (yuname.contains(" ")) 
		{
		JOptionPane.showMessageDialog(frameSignUp, "Username cannot have blank spaces! ");
				
		}
		else if (yuname.contains("admin")) 
		{
		JOptionPane.showMessageDialog(frameSignUp, "Cannot use keyword 'admin' in username. Reserved for administrator. Try Again ");
					
		}
		else if (zpass2.equals("")) 
		{
		JOptionPane.showMessageDialog(frameSignUp, "Password cannot be blank");
					
		}
				
		else
		{
		try
		{
		
					
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");		
		String qu3= "select * from users where USERNAME='"+yuname+"'";
		Statement statement2= con.createStatement();
		ResultSet row2= statement2.executeQuery(qu3);
					
		if (row2.next()) 
		{
			JOptionPane.showMessageDialog(frameSignUp, " Username already exists!!");
		}
		else
		{
			String qu2= "insert into users(USERNAME, PASSWORD, CONFIRM, NAME) values ('"+yuname+"','"+zpass2+"','"+cnfrmd+"','"+xname+"')";
			Statement statement= con.createStatement();
			int row= statement.executeUpdate(qu2);
			JOptionPane.showMessageDialog(frameSignUp, row+" user registered successfully!");
				
			LoginPage page = new LoginPage();
			page.frameLoginPage.setVisible(true);
			frameSignUp.dispose();	
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
		else if (e.getSource()==btnLogIn)
		{
			LoginPage page = new LoginPage();
			page.frameLoginPage.setVisible(true);
			frameSignUp.dispose();
			
		}
	}

	
	public static void main(String[] args)
	{
		
		SignUpPage window = new SignUpPage();
		window.frameSignUp.setVisible(true);
	}
}
