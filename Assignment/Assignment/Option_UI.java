	package Assignment;
	
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	
	import javax.swing.ButtonGroup;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JRadioButton;
	
	public class Option_UI extends JFrame implements ActionListener{
		
	    private JRadioButton rb1;
	    private JRadioButton rb2;
	    private String username;
	    JLabel nextUserLabel = null;
	    ButtonGroup bg = null;
	    JButton optionSubmit = null;
	    JPanel optionPanel = null;
	    
		 public Option_UI(String username){	
			 this.username = username; // store the username
			 
			 this.setTitle("choose action");
		    // Content
		    nextUserLabel = new JLabel();
		    nextUserLabel.setText(" Hello " + username + "");
		    bg = new ButtonGroup();
		    // Add the radio buttons to the button group
		    rb1 = new JRadioButton("Battle", true);
		    rb2 = new JRadioButton("PokeDex", false);
		    bg.add(rb1);
		    bg.add(rb2);
		
		    // Add "SUBMIT" button
		    optionSubmit = new JButton("SUBMIT");
		
		    // Add to the panel and frame
		    optionPanel = new JPanel(new GridLayout(4, 1));
		    optionPanel.add(nextUserLabel);
		    optionPanel.add(rb1);
		    optionPanel.add(rb2);
		    optionPanel.add(optionSubmit);		
		    add(optionPanel);
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    // Set the size and visibility\
		    optionSubmit.addActionListener(this); 
		    setSize(400, 200);
		    setLocationRelativeTo(null); // set location to middle
		    setVisible(true);
			}	
		 
		public void actionPerformed(ActionEvent ae) {
			// Handle the action when the "SUBMIT" button is clicked
	    	if (rb1.isSelected()) {// User chose "Battle"
	    		this.dispose();
	    		ChooseStage_UI stage = new ChooseStage_UI();

	    		
	        } else if (rb2.isSelected()) {// User chose "PokeDex"
	            this.dispose();
	            Pokedex_UI pokedex = new Pokedex_UI(username);

	        }
		}
		
	}
