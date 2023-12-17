package Assignment;

import java.awt.BorderLayout; 
import java.awt.GridLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Assignment.Pokemon.*; 
public class User_UI extends JFrame implements ActionListener { 
	JPanel panel; 
	JLabel user_label, disk1_label,disk2_label, message; 
	JTextField userName_text; JTextField disk_text1; JTextField disk_text2;
	JButton submit; 
	
	User_UI() { 
		// User Label 
		user_label = new JLabel(); 
		user_label.setText("User Name :"); 
		userName_text = new JTextField(); 
		// Disk1
		disk1_label = new JLabel(); 
		disk1_label.setText("Disk1 :"); 
		disk_text1 = new JTextField(); 
		// Disk2
		disk2_label = new JLabel(); 
		disk2_label.setText("Disk2 :"); 
		disk_text2 = new JTextField(); 
		// Submit 
		submit = new JButton("SUBMIT"); 
		panel = new JPanel(new GridLayout(4, 1)); 
		panel.add(user_label); panel.add(userName_text); 
		panel.add(disk1_label); 
		panel.add(disk_text1); 
		panel.add(disk2_label); 
		panel.add(disk_text2); 
		message = new JLabel(); 
		panel.add(message); 
		panel.add(submit); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		// Adding the listeners to components.. 
		submit.addActionListener(this); 
		add(panel, BorderLayout.CENTER); 
		
		setTitle("User Login"); 
		setSize(400, 200);
	    setLocationRelativeTo(null); // set location to middle
		setVisible(true); 
		
		}
	
	
	public static void main(String[] args) { 
		new User_UI(); 
		} 
	
	
	public void actionPerformed(ActionEvent ae) {
	    String userName = userName_text.getText();
	    String disk1 = disk_text1.getText();
	    String disk2 = disk_text2.getText();

	    if (userName.trim().equals("admin")) {
	        this.dispose();
	    	Option_UI option = new Option_UI(userName);
	    } else {
	        message.setText(" Invalid user.. ");
	    }
	}
}

