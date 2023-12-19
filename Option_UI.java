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
		
	    private JRadioButton rb1 = null;
	    private JRadioButton rb2 = null;
	    public String username = null;
	    private JLabel UserLabel = null;
	    private ButtonGroup bg = null;
	    private JButton optionSubmit = null;
	    private JPanel optionPanel = null;
	    
		 public Option_UI(String username){	
			 this.username = username; // store the username
			 
			 this.setTitle("choose action");
		    UserLabel = new JLabel();
		    UserLabel.setText(" Hello " + username + "");
		    bg = new ButtonGroup();
		    rb1 = new JRadioButton("Battle", true);
		    rb2 = new JRadioButton("PokeDex", false);
		    bg.add(rb1);
		    bg.add(rb2);
		
		    optionSubmit = new JButton("SUBMIT");
		
		    optionPanel = new JPanel(new GridLayout(4, 1));
		    optionPanel.add(UserLabel);
		    optionPanel.add(rb1);
		    optionPanel.add(rb2);
		    optionPanel.add(optionSubmit);		
		    add(optionPanel);
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    optionSubmit.addActionListener(this); 
		    setSize(400, 200);
		    setLocationRelativeTo(null); // set location to middle
		    setVisible(true);
			}	
		 
		public void actionPerformed(ActionEvent ae) {
	    	if (rb1.isSelected()) {// User chose "Battle"
	    		this.dispose();
	    		ChooseStage_UI stage = new ChooseStage_UI(username);

	    		
	        } else if (rb2.isSelected()) {// User chose "PokeDex"
	            this.dispose();
	            new Pokedex_UI(username);

	        }
		}
		
	}
