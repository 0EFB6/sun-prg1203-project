package Assignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Battle_UI extends JFrame implements ActionListener{
	
	
	public Battle_UI(){	
		// User chose "Battle"
		 this.setTitle("Battle");
		
		
		
		setSize(400, 200);
	    setLocationRelativeTo(null); // set location to middle
		setVisible(true);
    
		}

	public static void main(String[] args) { 
		new Battle_UI(); 
		} 


	public void actionPerformed(ActionEvent ae) {
		}
}
