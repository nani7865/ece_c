package Data_user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class login1 {

	private JFrame frame;
	private JTextField t1;
	private JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login1 window = new login1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 645, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(74, 74, 95, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(74, 143, 95, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setBackground(Color.RED);
		lblLoginPage.setFont(new Font("Sitka Heading", Font.PLAIN, 19));
		lblLoginPage.setBounds(232, 11, 197, 29);
		frame.getContentPane().add(lblLoginPage);
		
		t1 = new JTextField();
		t1.setBackground(Color.ORANGE);
		t1.setBounds(192, 71, 86, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		p1 = new JPasswordField();
		p1.setBackground(Color.CYAN);
		p1.setBounds(192, 143, 86, 20);
		frame.getContentPane().add(p1);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  user=t1.getText();
				String pass=p1.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ece_c","root","mrec");
					String q="select count(*) from sign where username=? and password=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setString(1, user);
					ps.setString(2,pass);
					ResultSet rs=ps.executeQuery();
					rs.next();
					int c=rs.getInt(1);
					if(c==0)
					{
						JOptionPane.showMessageDialog(btnNewButton, " invalid");
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton, " login done");	
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		});
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setFont(new Font("Sitka Heading", Font.PLAIN, 19));
		btnNewButton.setBounds(192, 250, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
