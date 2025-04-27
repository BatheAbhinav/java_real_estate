package realEstate_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;


public class GuestInterface extends JFrame implements ActionListener{
	JLabel lblNewLabel;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JButton btnNewButton_3;
	JButton btnshowThePropertyemsp;
	JButton back;
	
	GuestInterface(){
		this.getContentPane().setForeground(new Color(64, 224, 208));
		this.getContentPane().setBackground(new Color(175, 238, 238));
		this.getContentPane().setLayout(null);
		this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\abhinandan\\OneDrive\\Desktop\\Dbsms_project\\background6.png")));
		
		
		lblNewLabel = new JLabel("Welcome Guest");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(288, 44, 273, 52);
		this.getContentPane().add(lblNewLabel);
		
	    btnNewButton_1 = new JButton("<html>Show the<br> Agent_id's </html>");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(152, 251, 152));
		btnNewButton_1.setFont(new Font("Sitka Small", Font.BOLD, 24));
		btnNewButton_1.setBounds(98, 133, 273, 141);
		this.getContentPane().add(btnNewButton_1);
		
		 btnNewButton_1.addActionListener(this);
		
		btnNewButton_2 = new JButton("<html>Show the<br>Property_id's</html>");
		btnNewButton_2.setBackground(new Color(255, 182, 193));
		btnNewButton_2.setFont(new Font("Sitka Small", Font.BOLD, 24));
		btnNewButton_2.setBounds(436, 133, 273, 138);
		this.getContentPane().add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(this);
		
		btnNewButton_3 = new JButton("<html>Show the Agent<br>&emsp Detail's<br> using Agent_id</html>");
		btnNewButton_3.setBackground(new Color(175, 205, 215));
		btnNewButton_3.setFont(new Font("Sitka Small", Font.BOLD, 24));
		btnNewButton_3.setBounds(98, 314, 273, 141);
		this.getContentPane().add(btnNewButton_3);
		
		btnNewButton_3.addActionListener(this);
		
		btnshowThePropertyemsp = new JButton("<html>Show the Property<br>&emsp Detail's<br> using Property_id</html>");
		btnshowThePropertyemsp.setFont(new Font("Sitka Small", Font.BOLD, 24));
		btnshowThePropertyemsp.setBackground(new Color(255, 239, 213));
		btnshowThePropertyemsp.setBounds(437, 314, 273, 141);
		this.getContentPane().add(btnshowThePropertyemsp);
		this.setBounds(100, 100, 819, 535);
		
		btnshowThePropertyemsp.addActionListener(this);
		
		back = new JButton("Back");
		back.setFont(new Font("Cambria", Font.ITALIC, 18));
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.setBounds(0, 0, 77, 34);
		this.getContentPane().add(back);
		this.setBounds(100, 100, 819, 535);
		
		back.addActionListener(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(false);
		this.setVisible(true);
		
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() ==  btnNewButton_1)
		{
			// write code to show Agents_id
			try {
				GetConnection getConnection = new GetConnection();
				Statement st = getConnection.con.createStatement();
				ResultSet resultSet = st.executeQuery("select count(*) from agent");
				
				int size= 0;  
				resultSet.next();
				//System.out.println(resultSet.getInt(1));
				size = resultSet.getInt(1);
				resultSet = st.executeQuery("select Agent_ID, Name from agent");
				
				String data[][] = new String[size][];
				String columnName[] = {"Agent_ID","Name"};
				String title = "Agent ID and thier name";
				
				int i = 0;
				while(resultSet.next()) {
					
					String str = String.format("%d %s",
							resultSet.getInt(1), resultSet.getString(2));
					
					data[i] = str.split(" ");
					i++;
				       
				}
				
				new JTableClass(data, columnName, title);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
		}
		if(e.getSource() ==  btnNewButton_2)
		{
			// write code to show property_id
			try {
				GetConnection getConnection = new GetConnection();
				Statement st = getConnection.con.createStatement();
				ResultSet resultSet = st.executeQuery("select count(*) from properties");
				
				int size= 0;  
				resultSet.next();
				//System.out.println(resultSet.getInt(1));
				size = resultSet.getInt(1);
				resultSet = st.executeQuery("select Property_ID, Address, pin_code, status from properties");
				
				String data[][] = new String[size][];
				String columnName[] = {"Property_ID","Address", "pin_code", "status"};
				String title = "property detail in different place";
				
				int i = 0;
				while(resultSet.next()) {
					
					String str = String.format("%d,%s,%d,%s",
							resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4));
					
					data[i] = str.split(",");
					i++;
				       
				}
				
				new JTableClass(data, columnName, title);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
		}
		if(e.getSource() ==  btnNewButton_3)
		{
			// show agent detail using agent id
			this.dispose();
			new GuestInterface_showAgent();
			
		}
		if(e.getSource() ==  btnshowThePropertyemsp)
		{
			// show to property detail using property_id
			this.dispose();
			new GuestInterface_propertyDetail();
			
		}
		if(e.getSource() == back)
		{
			this.dispose();
			new RealEstatePortal();
		}
		
	}

}
