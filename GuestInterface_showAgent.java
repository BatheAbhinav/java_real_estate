package realEstate_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuestInterface_showAgent extends JFrame implements ActionListener{
	JTextField txtEnterAgentidHere;
	JButton submit;
	JButton back;
	
	
	
	GuestInterface_showAgent()
	{
		
		this.getContentPane().setForeground(new Color(64, 224, 208));
		this.getContentPane().setBackground(new Color(175, 238, 238));
		this.getContentPane().setLayout(null);
		this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\abhinandan\\OneDrive\\Desktop\\Dbsms_project\\background6.png")));
		
		
		JLabel lblNewLabel = new JLabel("Welcome Guest");
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setBackground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(266, 39, 273, 52);
		this.getContentPane().add(lblNewLabel);
		
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		submit.setForeground(new Color(240, 255, 240));
		submit.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 26));
		submit.setBackground(new Color(0, 0, 0));
		submit.setBounds(505, 332, 180, 66);
		this.getContentPane().add(submit);
		
		submit.addActionListener(this);
		
		txtEnterAgentidHere = new JTextField("Enter Agent_id here..");
		txtEnterAgentidHere.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterAgentidHere.setFont(new Font("Cambria", Font.ITALIC, 26));
		txtEnterAgentidHere.setBounds(130, 332, 282, 66);
		this.getContentPane().add(txtEnterAgentidHere);
		txtEnterAgentidHere.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the Agent_id to get the detail of agent");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(106, 138, 594, 32);
		this.getContentPane().add(lblNewLabel_1);
		
		back = new JButton("Back");
		back.setFont(new Font("Yu Gothic", Font.ITALIC, 21));
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(0, 0, 95, 32);
		this.getContentPane().add(back);
		
		back.addActionListener(this);
		
		this.setBounds(100, 100, 819, 535);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit)
		{
			int id ;
			boolean flag = false;
			
				id = Integer.parseInt(txtEnterAgentidHere.getText() );
				try {
					GetConnection getConnection = new GetConnection();
					Statement st = getConnection.con.createStatement();
					ResultSet resultSet;
					
					int size= 1; 
					
					resultSet = st.executeQuery("select Agent_ID from agent");

					while(resultSet.next()) {
						if(resultSet.getInt(1) == id)
						{
							flag = true;
							break;
						}
					}

				} catch (SQLException e1) {
					System.out.println(e1.getStackTrace());
				}
				
				if(flag == true){
					try {
						GetConnection getConnection = new GetConnection();
						Statement st = getConnection.con.createStatement();
						ResultSet resultSet;
						
						int size= 1; 
						
						resultSet = st.executeQuery("select Agent_ID, Name, Email"
								+ " from agent where Agent_ID = " + id);
						
						String data[][] = new String[size][];
						String columnName[] = {"Agent_ID","Name", "Email"};
						String title = "Agent detail corrosponding to given Agent_id";
						
						int i = 0;
						while(resultSet.next()) {
							
							String str = String.format("%d_%s_%s",resultSet.getInt(1),
									resultSet.getString(2),resultSet.getString(3));
							
							data[i] = str.split("_");
							i++;
						       
						}
						
						new JTableClass(data, columnName, title);
					} catch (SQLException e1) {
						System.out.println(e1.getStackTrace());
					}
					
				}else {
					JOptionPane.showMessageDialog(this,"No detail exit for the given Agent_id");
		        }
		}
		if(e.getSource() == back)
		{
			this.dispose();
			new GuestInterface();
		}
	}
}
