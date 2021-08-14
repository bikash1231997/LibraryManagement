import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class AdminVerifyMerchant implements ActionListener 
{

	JList list;
	 JFrame frmVerifyMerchants;
	 JTextField textField;

	 String uname2;
	 
	 JButton btnRefresh = new JButton("Refresh");
	 JButton btnVerify = new JButton("Verify");
	 JButton btnGoBack = new JButton("Go Back");
	
	
	public AdminVerifyMerchant() 
	{
		frmVerifyMerchants = new JFrame();
		frmVerifyMerchants.setResizable(false);
		frmVerifyMerchants.setTitle("Verify Merchants");
		frmVerifyMerchants.setIconImage(Toolkit.getDefaultToolkit().getImage(AdminVerifyMerchant.class.getResource("power_icon.png")));
		frmVerifyMerchants.setBounds(100, 100, 1261, 677);
		frmVerifyMerchants.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVerifyMerchants.getContentPane().setLayout(null);
		
		JButton btnVerifyMerchants = new JButton("Verify Merchants");
		btnVerifyMerchants.setForeground(Color.WHITE);
		btnVerifyMerchants.setBackground(Color.WHITE);
		btnVerifyMerchants.setEnabled(false);
		btnVerifyMerchants.setBounds(10, 11, 1235, 50);
		frmVerifyMerchants.getContentPane().add(btnVerifyMerchants);
		
		JLabel lblListOfNon = new JLabel("List of Non Verified Merchants");
		lblListOfNon.setHorizontalAlignment(SwingConstants.CENTER);
		lblListOfNon.setBounds(698, 72, 547, 39);
		frmVerifyMerchants.getContentPane().add(lblListOfNon);
		
		list = new JList();
		list.setBounds(708, 165, 537, 473);
		frmVerifyMerchants.getContentPane().add(list);
		
		JLabel lblVerifyMerchants = new JLabel("Verify Merchants");
		lblVerifyMerchants.setBackground(Color.YELLOW);
		lblVerifyMerchants.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerifyMerchants.setBounds(10, 84, 678, 27);
		frmVerifyMerchants.getContentPane().add(lblVerifyMerchants);
		
		textField = new JTextField();
		textField.setBounds(10, 145, 678, 50);
		frmVerifyMerchants.getContentPane().add(textField);
		textField.setColumns(10);
		

		btnVerify.setBounds(243, 242, 200, 50);
		frmVerifyMerchants.getContentPane().add(btnVerify);
		
		
		btnGoBack.setBounds(10, 505, 200, 133);
		frmVerifyMerchants.getContentPane().add(btnGoBack);
		
		
		btnRefresh.setBounds(708, 113, 537, 39);
		frmVerifyMerchants.getContentPane().add(btnRefresh);
		
		JLabel lblEnterUsernameTo = new JLabel("Enter Username to be verified");
		lblEnterUsernameTo.setForeground(Color.RED);
		lblEnterUsernameTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterUsernameTo.setBounds(10, 120, 678, 14);
		frmVerifyMerchants.getContentPane().add(lblEnterUsernameTo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminVerifyMerchant.class.getResource("bg_gray.png")));
		label.setBounds(-21, 0, 1336, 689);
		frmVerifyMerchants.getContentPane().add(label);
		
		btnVerify.addActionListener(this);
		btnRefresh.addActionListener(this);
		btnGoBack.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
				
			if(e.getSource()==btnVerify)
			{	
				uname2=textField.getText().toString();
				String unam=textField.getText().toString();
							
					if (uname2.equals("")) 
					{
						JOptionPane.showMessageDialog(frmVerifyMerchants, "Please enter Account Number");
					}

					else if (uname2.contains(" ")) 
					{
						JOptionPane.showMessageDialog(frmVerifyMerchants, "Account Number cannot have spaces.");
					}

					else
					{
						
						try
						{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");																

						String qu3= "update users set CONFIRM='1' where USERNAME='"+unam+"' ";
						Statement statement2= con.createStatement();
						int row2= statement2.executeUpdate(qu3);

					
						int response = JOptionPane.showConfirmDialog(null, " Verified!!! "+ "Do you want to continue?", "Verified",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						    if (response == JOptionPane.NO_OPTION) 
							{
						     AdminLanding page = new AdminLanding();
						     page.frmAdminLandingPage.setVisible(true);
						     frmVerifyMerchants.dispose();
						    	
						    } 
							else if (response == JOptionPane.YES_OPTION) 
							{
						    	JOptionPane.showMessageDialog(frmVerifyMerchants,"Sucessfully verified the user");  

						    	frmVerifyMerchants.dispose();
						    	
						    	AdminVerifyMerchant n= new AdminVerifyMerchant();
						    	n.frmVerifyMerchants.setVisible(true);
						     
						    } else if (response == JOptionPane.CLOSED_OPTION) 
							{
						     
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
			else if(e.getSource()==btnRefresh)
			{
					try
					{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
						
						PreparedStatement prepStmt = con.prepareStatement("select * from users where CONFIRM=?");
						prepStmt.setInt(1, 0);
						ResultSet row2 = prepStmt.executeQuery();

					//String qu3= "select * from users where CONFIRM='0'";
					//Statement statement2= con2.createStatement();
					//ResultSet row2= statement2.executeQuery("select * from users where CONFIRM='0'");
					
					//PreparedStatement stmt=con2.prepareStatement("select * from users");  
					//ResultSet row2=stmt.executeQuery();  

					if (row2.next()) 
					{
						DefaultListModel model = new DefaultListModel();
						
						 String cno=row2.getString("username");
						 
						 String name=row2.getString("name"); 
						 String data2=" Name: "+name+" Username: "+cno;
					        model.addElement(data2); 

						 while (row2.next())
						    {
							 String cno2=row2.getString("username");

							 String name2=row2.getString("name"); 
						        String data22= " Name: "+name2+" Username: "+cno2;
							          
						        model.addElement(data22); 
						    }
						 
						 list.setModel(model);
						
						JOptionPane.showMessageDialog(frmVerifyMerchants, " You have non verified users");
						
					}
					else{
						JOptionPane.showMessageDialog(frmVerifyMerchants, " No Entries");
					
					}	
					
					
				} catch (ClassNotFoundException e1) 
				{
					e1.printStackTrace();
				} catch (SQLException e2) 
				{
					
					e2.printStackTrace();
				}  
			
			}
			else if(e.getSource()==btnGoBack)
			{
				
				AdminLanding adminLanding = new AdminLanding();
				adminLanding.frmAdminLandingPage.setVisible(true);
				frmVerifyMerchants.dispose();
				
				
			}
	}
	
	
	public static void main(String[] args) 
	{	
		AdminVerifyMerchant window = new AdminVerifyMerchant();
		window.frmVerifyMerchants.setVisible(true);
	}


}
