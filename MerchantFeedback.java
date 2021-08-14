import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class MerchantFeedback  implements ActionListener 
{

	JFrame frmFeedback;
	private JTextField textField;
	 JLabel lblLoginName;
	 
	 JTextArea textArea ;
	static String uname=LoginPage.unametopass; 
	//String uname="bikash";
	
	JButton btnCancel = new JButton("Cancel");
	JButton btnSubmit = new JButton("Submit");
	JButton btnAboutDeveloper = new JButton("About Developer");
	
	public MerchantFeedback() 
	{
		frmFeedback = new JFrame();
		frmFeedback.setTitle("Feedback");
		frmFeedback.setResizable(false);
		frmFeedback.setIconImage(Toolkit.getDefaultToolkit().getImage(MerchantFeedback.class.getResource("power_icon.png")));
		frmFeedback.setBounds(100, 100, 1010, 762);
		frmFeedback.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFeedback.getContentPane().setLayout(null);
		
		btnCancel.setBounds(726, 11, 200, 50);
		frmFeedback.getContentPane().add(btnCancel);
		
		JLabel lblEnterYourFeedback = new JLabel("Enter Your Feedback...");
		lblEnterYourFeedback.setFont(new Font("Raleway", Font.PLAIN, 24));
		lblEnterYourFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourFeedback.setBounds(222, 110, 582, 56);
		frmFeedback.getContentPane().add(lblEnterYourFeedback);
		
		textField = new JTextField();
		textField.setBounds(363, 217, 306, 50);
		frmFeedback.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEmaik = new JLabel("Enter Email");
		lblEmaik.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmaik.setBounds(353, 178, 306, 25);
		frmFeedback.getContentPane().add(lblEmaik);
		
		textArea = new JTextArea();
		textArea.setToolTipText("Enter your feedback here");
		textArea.setBounds(353, 337, 306, 155);
		frmFeedback.getContentPane().add(textArea);
		
		JLabel lblEnterMessage = new JLabel("Enter Message ");
		lblEnterMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterMessage.setBounds(363, 278, 306, 32);
		frmFeedback.getContentPane().add(lblEnterMessage);
		
		btnSubmit.setBounds(404, 515, 200, 50);
		frmFeedback.getContentPane().add(btnSubmit);
		
		lblLoginName = new JLabel();
		if (uname==null) 
		{
			
			lblLoginName.setText("Hello User");
		}
		else
		{
			lblLoginName.setText("Logged in as: "+uname);
			
		} 
		lblLoginName.setFont(new Font("Raleway", Font.PLAIN, 13));
		lblLoginName.setBounds(10, 29, 501, 50);
		frmFeedback.getContentPane().add(lblLoginName);
		
		JLabel lblBikashMahapatra = new JLabel("Made by Bikash Mahapatra");
		lblBikashMahapatra.setHorizontalAlignment(SwingConstants.CENTER);
		lblBikashMahapatra.setBounds(342, 616, 329, 32);
		frmFeedback.getContentPane().add(lblBikashMahapatra);
		
		btnAboutDeveloper.setBounds(267, 665, 479, 32);
		frmFeedback.getContentPane().add(btnAboutDeveloper);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MerchantFeedback.class.getResource("back_4.jpg")));
		label.setBounds(0, -16, 1105, 796);
		frmFeedback.getContentPane().add(label);
		
		btnAboutDeveloper.addActionListener(this);
		btnCancel.addActionListener(this);
		btnSubmit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
			if(e.getSource()==btnAboutDeveloper)
			{
				AboutDeveloper developer = new AboutDeveloper();
				developer.frmAboutDeveloper.setVisible(true);
				frmFeedback.dispose();
			}
			else if(e.getSource()==btnCancel)
			{
				LandingPage page = new LandingPage();
				page.frameLandingPage.setVisible(true);
				frmFeedback.dispose();
			}
			else if(e.getSource()==btnSubmit)
			{
				String xemail=textField.getText().toString();
				String ymsg=textArea.getText().toString();
				
				if (xemail.equals("")) {
					JOptionPane.showMessageDialog(frmFeedback, "Email cannot be blank");
					
				}
				else
				{
					
					try
					{
						
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");																
					String qu2= "insert into merchantfeedback(uname, email, msg)" + "values ('"+uname+"','"+xemail+"','"+ymsg+"')";
					Statement statement= con.createStatement();
					int row= statement.executeUpdate(qu2);
					System.out.println(row+" row updated");
					
					JOptionPane.showMessageDialog(frmFeedback, " Your feedback has been Submitted successfully!! Thanks from developer. ");

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
		MerchantFeedback window = new MerchantFeedback();
		window.frmFeedback.setVisible(true);
	}

}
