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
	private JPanel panel; 
	private JLabel user_label,message; 
	private JTextField userName_text; 
	private JButton submit; 
	
	User_UI() { 
		setTitle("User Login"); 
		// User Label 
		user_label = new JLabel(); 
		user_label.setText("User Name :"); 
		userName_text = new JTextField(); 

		// Submit 
		submit = new JButton("SUBMIT"); 
		panel = new JPanel(new GridLayout(2, 1)); 
		panel.add(user_label); panel.add(userName_text); 
		message = new JLabel(); 
		panel.add(message); 
		panel.add(submit); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		submit.addActionListener(this); 
		add(panel, BorderLayout.CENTER); 
		
		setSize(400, 100);
	    setLocationRelativeTo(null); // set location to middle
		setVisible(true); 
		
		}		
	
	public static void main(String[] args) { 
		new User_UI(); 
		} 
	
	
	public void actionPerformed(ActionEvent ae) {
	    String userName = userName_text.getText();
	        this.dispose();
	    	new Option_UI(userName);
	}
}

