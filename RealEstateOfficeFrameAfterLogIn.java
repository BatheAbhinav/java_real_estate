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
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
  
class JTableClass implements ActionListener{
    // frame
    JFrame f;
    // Table
    JTable j;
    JMenuBar mb;
    JMenu x;
  
    // Constructor
    JTableClass(String[][] data, String[] columnNames, String title)
    {
        // Frame initialization
        f = new JFrame();
  
        // Frame Title
        f.setTitle(title);
  
        // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setBounds(0, 0, 1000, 1000);
  
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        // Frame Size
        

        // create a menu bar
        mb = new JMenuBar();
  
        // create a menu
        x = new JMenu("Back");
        
        x.addActionListener(this);

  
        // add menu to menu bar
        mb.add(x);
  
        // add menu bar to frame
        f.setJMenuBar(mb);
        
        f.setBounds(100, 100, 819, 535);
        // Frame Visible = true
        
        f.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == x)
		{
			f.dispose();
		}
		
	}
}

public class RealEstateOfficeFrameAfterLogIn extends JFrame implements ActionListener{
		JButton rentReports;
		JButton saleReports;
		JButton back;
		RealEstateOfficeFrameAfterLogIn()
		{
			this.getContentPane().setForeground(new Color(64, 224, 208));
			this.getContentPane().setBackground(new Color(175, 238, 238));
			this.getContentPane().setLayout(null);
			this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\abhinandan\\OneDrive\\Desktop\\Dbsms_project\\background6.png")));
			
			
			JLabel lblNewLabel = new JLabel("Welcome to Real Estate Office");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(new Color(0, 0, 0));
			lblNewLabel.setBackground(new Color(30, 144, 255));
			lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
			lblNewLabel.setBounds(0, 44, 805 , 50);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			this.getContentPane().add(lblNewLabel);
		
			
			rentReports = new JButton("Rent Reports");
			rentReports.setBackground(new Color(214,202,221));
			rentReports.setFont(new Font("Sitka Small", Font.BOLD, 24));
			rentReports.setBounds(561, 322, 234, 66);
			this.getContentPane().add(rentReports);
			
			rentReports.addActionListener(this);
			
			saleReports = new JButton("Sale Reports");
			saleReports.setBackground(new Color(214,202,221));
			saleReports.setFont(new Font("Sitka Small", Font.BOLD, 24));
			saleReports.setBounds(561, 195, 234, 66);
			this.getContentPane().add(saleReports);
			
			saleReports.addActionListener(this);
			
			back = new JButton("Back");
			back.setFont(new Font("Sitka Display", Font.ITALIC, 22));
			back.setForeground(Color.WHITE);
			back.setBackground(Color.BLACK);
			back.setBounds(0, 0, 76, 31);
			
			back.addActionListener(this);
			
			this.getContentPane().add(back);
			this.setBounds(100, 100, 819, 535);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			this.setResizable(false);
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource() == saleReports)
			{
				try {
					GetConnection getConnection = new GetConnection();
					Statement st = getConnection.con.createStatement();
					ResultSet resultSet = st.executeQuery("select count(*) from transaction where Transaction_type = 'sold'");
					
					int size= 0;  
					resultSet.next();
					//System.out.println(resultSet.getInt(1));
					size = resultSet.getInt(1);
					resultSet = st.executeQuery("select * from transaction where Transaction_type = 'sold'");
					
					String data[][] = new String[size][];
					String columnName[] = {"Transaction_ID","Date", "Property_Id",
							"Agent_Id", "Client_id", "Owner_ID", "Price", "Transaction_type"};
					String title = "Rent Reports";
					
					int i = 0;
					while(resultSet.next()) {
						
						String str = String.format("%d %s %d %d %d %d %d %s",
								resultSet.getInt(1), resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4),
								resultSet.getInt(5), resultSet.getInt(6),resultSet.getInt(7), resultSet.getString(8));
						
						data[i] = str.split(" ");
						i++;
					       
					}
					
					new JTableClass(data, columnName, title);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			if(e.getSource() == rentReports)
			{
				try {
					GetConnection getConnection = new GetConnection();
					Statement st = getConnection.con.createStatement();
					ResultSet resultSet = st.executeQuery("select count(*) from transaction where Transaction_type = 'rent'");
					
					int size= 0;  
					resultSet.next();
					//System.out.println(resultSet.getInt(1));
					size = resultSet.getInt(1);
					resultSet = st.executeQuery("select * from transaction where Transaction_type = 'rent'");
					
					String data[][] = new String[size][];
					String columnName[] = {"Transaction_ID","Date", "Property_Id",
							"Agent_Id", "Client_id", "Owner_ID", "Price", "Transaction_type"};
					String title = "Rent Reports";
					
					int i = 0;
					while(resultSet.next()) {
						
						String str = String.format("%d %s %d %d %d %d %d %s",
								resultSet.getInt(1), resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4),
								resultSet.getInt(5), resultSet.getInt(6),resultSet.getInt(7), resultSet.getString(8));
						
						data[i] = str.split(" ");
						i++;
					       
					}
					
					new JTableClass(data, columnName, title);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			if(e.getSource() == back)
			{
				this.dispose();
				new RealEstateOfficeLogInFrame();
			}
			
		}



}
