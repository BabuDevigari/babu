package projectdatabase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class check {

	protected static final String Password = null;
	private JFrame frame;
	private JTextField t1;
	private JTextField p1;
	protected Object user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					check window = new check();
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
	public check() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Check");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(135, 11, 84, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(20, 95, 102, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(20, 211, 137, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		t1 = new JTextField();
		t1.setBounds(156, 107, 204, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		p1 = new JTextField();
		p1.setBounds(156, 219, 204, 20);
		frame.getContentPane().add(p1);
		p1.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=DriverManager.getConnection("jdbs:musql://localhost:3306/ece","root","mrec");
				String q="Select Count(*)from account wher username";
			    PreparedStatement ps=con.prepareStatement(q);
				
				ps.setrString(1,user name:);
				ps.setString(2, Password);
				ResultSet rs=ps.executeQuery();
				rs.next();
				int c=rs.getInt(1);
				if(c==0)
				{
					JOptionPane.showConfirmDialog(btnNewButton, "Invalid");
				}
				else
				{
					JOptionPane.showConfirmDialog(btnNewButton, "valid");
				}
				
						
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnNewButton.setBounds(121, 319, 126, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
