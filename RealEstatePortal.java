package realEstate_project;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

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

public class RealEstatePortal extends JFrame implements ActionListener{
		JLabel lblNewLabel;
		JLabel background;
		JButton btnNewButton_1;
		JButton btnNewButton_2;
		JButton btnNewButton_3;
		
	    RealEstatePortal(){
		
			this.getContentPane().setForeground(new Color(64, 224, 208));
			this.getContentPane().setBackground(new Color(175, 238, 238));
			this.getContentPane().setLayout(null);
			this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\abhinandan\\OneDrive\\Desktop\\Dbsms_project\\background5.jpg")));
			
		    lblNewLabel = new JLabel("Welcome to Real Estate Portal");
			lblNewLabel.setForeground(Color.black);
			lblNewLabel.setBackground(new Color(30, 144, 255));
			lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 45));
			lblNewLabel.setBounds(0, 10, 805 , 50);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			this.getContentPane().add(lblNewLabel);
			
			
			
			btnNewButton_1 = new JButton("<html>Log In <br> &ensp As <br> Guest </html>");
			btnNewButton_1.setForeground(new Color(0, 0, 0));
			btnNewButton_1.setBackground(new Color(255, 204, 255));
			btnNewButton_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
			btnNewButton_1.setBounds(664, 364, 131, 77);
			this.getContentPane().add(btnNewButton_1);
			
			btnNewButton_1.addActionListener(this);
			
			btnNewButton_2 = new JButton("<html>Log In <br> &ensp As <br> Agent </html>");
			btnNewButton_2.setBackground(new Color(255, 255, 153));
			btnNewButton_2.setFont(new Font("Sitka Small", Font.BOLD, 12));
			btnNewButton_2.setBounds(664, 247, 131, 77);
			this.getContentPane().add(btnNewButton_2);
			
			btnNewButton_2.addActionListener(this);
			
			btnNewButton_3 = new JButton("<html>Log In to Real<br>&emsp Estate<br>Agent's office</html>");
			btnNewButton_3.setBackground(new Color(204, 255, 102));
			btnNewButton_3.setFont(new Font("Sitka Small", Font.BOLD, 12));
			btnNewButton_3.setBounds(664, 128, 131, 77);
			
			btnNewButton_3.addActionListener(this);
			
			this.getContentPane().add(btnNewButton_3);
			this.setBounds(100, 100, 819, 535);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			this.setResizable(false);
			this.setVisible(true);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btnNewButton_1)
			{
				this.dispose();
				new GuestInterface();
			}
			
			if(e.getSource() == btnNewButton_2) {
				this.dispose();
				new AgentLogInFrame();
			}
			
			if(e.getSource() == btnNewButton_3) {
				this.dispose();
				new RealEstateOfficeLogInFrame();
			}
			
		}

	
}
