package realEstate_project;

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
import javax.swing.JPasswordField;

import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class RealEstateOfficeLogInFrame extends JFrame implements ActionListener {
	JTextField txtEnterPasswordHere;
	JLabel level1;
	JButton logIn;
	JButton back;
	RealEstateOfficeLogInFrame()
	{
		this.getContentPane().setForeground(new Color(64, 224, 208));
		this.getContentPane().setBackground(new Color(175, 238, 238));
		this.getContentPane().setLayout(null);
		
		this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\abhinandan\\OneDrive\\Desktop\\Dbsms_project\\background6.png")));
		
		
		level1 = new JLabel("Log In to Real Estate Agent\u2019s Office");
		level1.setHorizontalAlignment(SwingConstants.CENTER);
		level1.setForeground(Color.BLACK);
		level1.setBackground(new Color(30, 144, 255));
		level1.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		level1.setBounds(78, 40, 629, 52);
		this.getContentPane().add(level1);
		
		logIn = new JButton("Log In");
		logIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logIn.setForeground(new Color(240, 255, 240));
		logIn.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 24));
		logIn.setBackground(new Color(0, 0, 0));
		logIn.setBounds(285, 338, 180, 66);
		this.getContentPane().add(logIn);
		
		logIn.addActionListener(this);
		
		txtEnterPasswordHere = new JTextField("Enter Password here....");
		txtEnterPasswordHere.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterPasswordHere.setFont(new Font("Cambria", Font.ITALIC, 26));
		txtEnterPasswordHere.setBounds(190, 177, 394, 66);
		this.getContentPane().add(txtEnterPasswordHere);
		txtEnterPasswordHere.setColumns(10);
		
		back = new JButton("Back");
		back.setFont(new Font("Sitka Heading", Font.ITALIC, 18));
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.setBounds(0, 0, 69, 30);
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
		if(e.getSource() == logIn)
		{
			
			String pswrd = txtEnterPasswordHere.getText().toString();
			
			if(pswrd.equals("password")) {
				this.dispose();
				new RealEstateOfficeFrameAfterLogIn();
				
			}
			else
				JOptionPane.showMessageDialog(this,"Invalid password!");  
		}
		
		if(e.getSource() == back)
		{
			this.dispose();
			new RealEstatePortal();
		}
		
	}

}
