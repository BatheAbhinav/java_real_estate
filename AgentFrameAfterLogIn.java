package realEstate_project;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;

public class AgentFrameAfterLogIn extends JFrame implements ActionListener{
	JButton propertyDetail;
	JButton clientDetails;
	JButton ownerDetails;
	JButton updateTransaction;
	JButton back;
	JLabel lblNewLabel;
	
	AgentFrameAfterLogIn()
	{
		this.getContentPane().setForeground(new Color(64, 224, 208));
		this.getContentPane().setBackground(new Color(175, 238, 238));
		this.getContentPane().setLayout(null);
		this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\abhinandan\\OneDrive\\Desktop\\Dbsms_project\\background6.png")));
		
		
		lblNewLabel = new JLabel("Welcome Agent");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		lblNewLabel.setBounds(0, 40, 805 , 50);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(lblNewLabel);
			
		propertyDetail = new JButton("Property Details");
		propertyDetail.setForeground(new Color(0, 0, 0));
		propertyDetail.setBackground(new Color(152, 251, 152));
		propertyDetail.setFont(new Font("Sitka Small", Font.BOLD, 24));
		propertyDetail.setBounds(98, 133, 273, 141);
		this.getContentPane().add(propertyDetail);
		
		propertyDetail.addActionListener(this);
		
		updateTransaction = new JButton("<html> &nbsp &nbsp Update <br>Transaction</html>");
		updateTransaction.setBackground(new Color(255, 182, 193));
		updateTransaction.setFont(new Font("Sitka Small", Font.BOLD, 24));
		updateTransaction.setBounds(436, 133, 273, 138);
		this.getContentPane().add(updateTransaction);
		
		updateTransaction.addActionListener(this);
		
		clientDetails = new JButton("Client Details");
		clientDetails.setBackground(new Color(175, 205, 215));
		clientDetails.setFont(new Font("Sitka Small", Font.BOLD, 24));
		clientDetails.setBounds(98, 314, 273, 141);
		this.getContentPane().add(clientDetails);
		
		clientDetails.addActionListener(this);
		
		ownerDetails = new JButton("Owner Details");
		ownerDetails.setFont(new Font("Sitka Small", Font.BOLD, 24));
		ownerDetails.setBackground(new Color(255, 239, 213));
		ownerDetails.setBounds(437, 314, 273, 141);
		this.getContentPane().add(ownerDetails);
		
		ownerDetails.addActionListener(this);
		
		back = new JButton("Back");
		back.setFont(new Font("Sitka Display", Font.ITALIC, 23));
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(0, 0, 77, 30);
		this.getContentPane().add(back);
		
		back.addActionListener(this);
		
		this.setBounds(100, 100, 819, 535);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(false);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back)
		{
			this.dispose();
			new AgentLogInFrame();
		}
		
		if(e.getSource() == ownerDetails)
		{
			try {
				GetConnection getConnection = new GetConnection();
				Statement st = getConnection.con.createStatement();
				ResultSet resultSet = st.executeQuery("select count(*) from owners");
				
				int size= 0;  
				resultSet.next();
				//System.out.println(resultSet.getInt(1));
				size = resultSet.getInt(1);  
				resultSet = st.executeQuery("select Owner_ID, Name, Email from owners");
				
				String data[][] = new String[size][];
				String columnName[] = {"Owner_ID","Name", "Email_id"};
				String title = "Owner details";
				
				int i = 0;
				while(resultSet.next()) {
					
					String str = String.format("%d,%s,%s",resultSet.getInt(1),
							resultSet.getString(2),resultSet.getString(3));
					
					data[i] = str.split(",");
					i++;
				       
				}
				
				new JTableClass(data, columnName, title);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource() == clientDetails)
		{
			try {
				GetConnection getConnection = new GetConnection();
				Statement st = getConnection.con.createStatement();
				ResultSet resultSet = st.executeQuery("select count(*) from clients");
				
				int size= 0;  
				resultSet.next();
				//System.out.println(resultSet.getInt(1));
				size = resultSet.getInt(1);  
				resultSet = st.executeQuery("select Client_ID, Name, Email from clients");
				
				String data[][] = new String[size][];
				String columnName[] = {"Client_ID","Name", "Email_id"};
				String title = "client details";
				
				int i = 0;
				while(resultSet.next()) {
					
					String str = String.format("%d,%s,%s",resultSet.getInt(1),
							resultSet.getString(2),resultSet.getString(3));
					
					data[i] = str.split(",");
					i++;
				       
				}
				
				new JTableClass(data, columnName, title);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource() == updateTransaction)
		{
			this.dispose();
			new UpdateTransactionTable();
		}
		
		if(e.getSource() == propertyDetail)
		{
			try {
				GetConnection getConnection = new GetConnection();
				Statement st = getConnection.con.createStatement();
				ResultSet resultSet = st.executeQuery("select count(*) from properties");
				
				int size= 0;  
				resultSet.next();
				//System.out.println(resultSet.getInt(1));
				size = resultSet.getInt(1);  
				resultSet = st.executeQuery("select Property_ID, Address, "
						+ "pin_code, status,Asking_price, Rent_per_month,"
						+ " Size_sq_feet, BHK, Property_type from properties");
				
				String data[][] = new String[size][];
				String columnName[] = {"Property_ID","Address", "pin_code", "status",
						"sale_Price", "rent_price","size(sq_feet)", "BHK", "Property_type"};
				String title = "property details";
				
				int i = 0;
				while(resultSet.next()) {
					
					String str = String.format("%d,%s,%d,%s,%d,%d,%d,%d,%s",resultSet.getInt(1),
							resultSet.getString(2),resultSet.getInt(3), resultSet.getString(4),
							resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7), resultSet.getInt(8)
							,resultSet.getString(9));
					
					data[i] = str.split(",");
					i++;
				       
				}
				
				new JTableClass(data, columnName, title);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}
