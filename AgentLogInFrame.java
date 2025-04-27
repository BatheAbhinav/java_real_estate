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
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;


public class AgentLogInFrame extends JFrame implements ActionListener{
	JTextField txtEnterAgentidHere;
	JTextField txtEnterPasswordHere;
	JButton back;
	JButton logIn;
	JLabel lblNewLabel;
	AgentLogInFrame()
	{
	
		this.getContentPane().setForeground(new Color(64, 224, 208));
		this.getContentPane().setBackground(new Color(175, 238, 238));
		this.getContentPane().setLayout(null);
		this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\abhinandan\\OneDrive\\Desktop\\Dbsms_project\\background6.png")));
		
		
		lblNewLabel = new JLabel("Welcome Agent");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		lblNewLabel.setBounds(0, 40, 805 , 50);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(lblNewLabel);
		
		logIn = new JButton("Log In");

		logIn.setForeground(new Color(240, 255, 240));
		logIn.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 24));
		logIn.setBackground(new Color(0, 0, 0));
		logIn.setBounds(316, 398, 180, 66);
		this.getContentPane().add(logIn);
		
		logIn.addActionListener(this);
		
		txtEnterAgentidHere = new JTextField("Enter Agent_id here..");
		txtEnterAgentidHere.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterAgentidHere.setBackground(Color.WHITE);
		txtEnterAgentidHere.setFont(new Font("Cambria", Font.ITALIC, 26));
		txtEnterAgentidHere.setBounds(204, 166, 394, 56);
		this.getContentPane().add(txtEnterAgentidHere);
		txtEnterAgentidHere.setColumns(10);
		
		
		
		txtEnterPasswordHere = new JTextField("Enter Password here..");
		txtEnterPasswordHere.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterPasswordHere.setBackground(Color.WHITE);
		txtEnterPasswordHere.setFont(new Font("Cambria", Font.ITALIC, 26));
		txtEnterPasswordHere.setColumns(10);
		txtEnterPasswordHere.setBounds(204, 284, 394, 56);
		this.getContentPane().add(txtEnterPasswordHere);
		
		back = new JButton("Back");
		back.setFont(new Font("Consolas", Font.ITALIC, 20));
		back.setForeground(Color.WHITE);
		back.setBackground(Color.DARK_GRAY);
		back.setBounds(0, 0, 79, 33);
		this.getContentPane().add(back);
		this.setBounds(100, 100, 819, 535);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		back.addActionListener(this);
		
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == back)
		{
			this.dispose();
			new RealEstatePortal();
		}
		if(e.getSource() == logIn)
		{
			//check the validity (is agent agent_id and password true or false)
			int id;
			boolean flag = false;
			
				id = Integer.parseInt(txtEnterAgentidHere.getText() );
				String name = null;
				try {
					GetConnection getConnection = new GetConnection();
					Statement st = getConnection.con.createStatement();
					ResultSet resultSet;
					
					int size= 1; 
					
					resultSet = st.executeQuery("select Agent_ID, Name from agent");

					while(resultSet.next()) {
						if(resultSet.getInt(1) == id)
						{
							flag = true;
							name = resultSet.getString(2);
							//System.out.println(name);
							break;
						}
					}

				} catch (SQLException e1) {
					System.out.println(e1.getStackTrace());
				}
			
			if(flag == true) {
				this.dispose();
				AgentFrameAfterLogIn addText = new AgentFrameAfterLogIn();
				addText.lblNewLabel.setText("Welcome " + name);;
			}
			else
				JOptionPane.showMessageDialog(this,"Invalid Agent-Id");
				
		}
		
	}

	private String getString(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
